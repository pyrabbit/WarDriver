package com.blackgatetech.wardriver.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

public class KismetClient implements Runnable {
    // Declare variables used throughout connection
    final private String host;
    final private int port;
    private BufferedReader fromServer;
    private BufferedWriter toServer;
    Socket socket;
    
    // Declare global variables for network statistics
    Set<String> networksSeen = new HashSet<>();
    private int networkCount = 0;
    
    public KismetClient() {
        this.port = 2501;
        this.host = "localhost";
    }
    
    public KismetClient(String h, int p) {
        this.port = p;
        this.host = h;     
    }

    public boolean connectToServer() throws ConnectException, UnknownHostException, IOException {
        try {
            // Open a socket connection
            socket = new Socket(this.host, this.port);
            
            // Create BufferReader/Writer for talking with Kismet Server
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            // Announce connection to console
            System.out.println("Connected to " + this.host + ":" + this.port);
            
            // Send Kismet commands 
            toServer.write("!0 REMOVE TIME\r\n");
            toServer.write("!0 ENABLE BSSID bssid,channel,type\r\n");
//            toServer.write("!0 ENABLE SSID mac,ssid\r\n");
            
            // Flush the output stream
            toServer.flush();
            
            // Begin a new thread
            Thread thread = new Thread(this);
            thread.start();
            
            // Respond with valid connection
            return true;
        } catch (ConnectException ex) {
            // Respond with invalid connection
            System.err.println("Cannot connect to kismet server, it is probably down.");
            return false;
        }
    }
    
    public void disconnectFromServer() {
        try {
            // Close the socket connection
            socket.close();
            System.out.println("You disconnected from the local server.");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                // grab next kismet message
                String kismetData = fromServer.readLine();
                System.out.println(kismetData);
                // Split kismet data by white space
                String[] pkt = kismetData.split("\\s+");

                // Grab BSSID
                if("*BSSID:".equals(pkt[0])) {
                    // if channel is not equal to zero and packet is added to set
                    if ("0".equals(pkt[3]) && !("0".equals(pkt[2])) && networksSeen.add(pkt[1])) {
                        // Add network to seen list
                        this.setNetworkCount(networksSeen.size());
                        System.out.println(networksSeen);
                    }
                }
                
                // do something with kismet message
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    
    public int getNetworkCount() { return this.networkCount; }
    public void setNetworkCount(int count) { this.networkCount+=1; }
}
