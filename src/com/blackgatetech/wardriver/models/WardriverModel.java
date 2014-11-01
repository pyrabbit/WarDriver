package com.blackgatetech.wardriver.models;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

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
    
    public void parseKismetPotocol(String[] pkt) {
        switch(pkt[0]) {
            
            case "*BSSID:":
                // if channel is not equal to zero and packet is added to set
                if (!"0".equals(pkt[2]) && networksSeen.add(pkt[1])) {
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
