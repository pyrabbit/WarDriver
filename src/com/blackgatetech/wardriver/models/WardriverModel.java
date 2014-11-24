package com.blackgatetech.wardriver.models;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import com.mongodb.DBObject;

import java.net.UnknownHostException;

import java.util.Date;

public class WardriverModel extends Observable {
    Set<String> networksSeen = new HashSet<>();
    private int networkCount = 0;
    private double latitude = 0.0d;
    private double longitude = 0.0d;
    private float altitude = 0.0f;
    private float speed = 0.0f;
    private float heading = 0.0f;
    private int fix = 0;
    private boolean connected = false;
    
    private MongoClient mongoClient;
    private DB db;
    private DBCollection coll;
    
    public void connectToMongo() {
        try {
            this.mongoClient = new MongoClient();
            this.db = mongoClient.getDB("wardriver");
            this.coll = db.getCollection("networks");
        } catch (UnknownHostException ex) {
            System.err.println("Could not connect to MongoDB");
        }
    }
    
    public void parseKismetPotocol(String[] pkt) {
        switch(pkt[0]) {
            
            case "*BSSID:":
                // pkt 1 = bssid
                // pkt 2 = channel
                if (!"0".equals(pkt[2])) {
                    BasicDBObject query = new BasicDBObject("bssid", pkt[1]);

                     DBObject update = new BasicDBObject(
                            "$setOnInsert", new BasicDBObject(
                                "channel", pkt[2]
                            )
                        ).append(
                            "$push", new BasicDBObject(
                                "heardpoints", new BasicDBObject(
                                    "$each", new DBObject[]{
                                        new BasicDBObject(
                                            "geometry",
                                            new BasicDBObject("type","Point").append(
                                                "coordinates", new double[]{longitude, latitude}
                                            )
                                        ).append(
                                            "time", new Date()
                                        )
                                    }
                                ).append(
                                    "$sort", new BasicDBObject(
                                        "time", -1
                                    )
                                ).append("$slice", -1000)
                            )
                        );
                     
                     coll.update(query, update, true, true);
                     networksSeen.add(pkt[1]);
                     setNetworkCount(networksSeen.size());
                }
                break;
            case "*GPS:":
                setLatitude(Double.parseDouble(pkt[1]));
                setLongitude(Double.parseDouble(pkt[2]));
                setAltitude(Float.parseFloat(pkt[3]));
                setSpeed(Float.parseFloat(pkt[4]));
                setHeading(Float.parseFloat(pkt[5]));
                setFix(Integer.parseInt(pkt[6]));
                if ("1".equals(pkt[10])) {
                    // GPS is Connected
                    setConnected(true);
                } else {
                    setConnected(false);
                }
        }
    }
    
    public int getNetworkCount() { return this.networkCount; }
    
    public void setNetworkCount(int count) { 
        this.networkCount = count;
        setChanged();
        notifyObservers();
    }
    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
        setChanged();
        notifyObservers();
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
        setChanged();
        notifyObservers();
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
        setChanged();
        notifyObservers();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
        setChanged();
        notifyObservers();
    }

    public float getHeading() {
        return heading;
    }

    public void setHeading(float heading) {
        this.heading = heading;
        setChanged();
        notifyObservers();
    }

    public int getFix() {
        return fix;
    }

    public void setFix(int fix) {
        this.fix = fix;
        setChanged();
        notifyObservers();
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
        setChanged();
        notifyObservers();
    }
}
