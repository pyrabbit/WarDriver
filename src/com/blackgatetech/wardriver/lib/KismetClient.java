package com.blackgatetech.wardriver.lib;

import com.blackgatetech.wardriver.models.WardriverModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;

public class KismetClient implements Runnable {
    // Declare variables used throughout connection
    final private String host;
    final private int port;
    private BufferedReader fromServer;
    private BufferedWriter toServer;
    Socket socket;
    private WardriverModel wardriverModel;
    
    public KismetClient(WardriverModel wardriverModel) {
        this.port = 2501;
        this.host = "localhost";
        this.wardriverModel = wardriverModel;
    }
    
    public KismetClient(String h, int p, WardriverModel wardriverModel) {
        this.port = p;
        this.host = h;
        this.wardriverModel = wardriverModel;
    }

    public boolean connectToServer() {
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
            toServer.write("!0 ENABLE BSSID bssid,channel\r\n");
            toServer.write("!0 CAPABILITY GPS\r\n");
            toServer.write("!0 CAPABILITY BSSID\r\n");
            toServer.write("!0 ENABLE GPS *\r\n");
            
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
        } catch (IOException ex) {
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

                this.wardriverModel.parseKismetPotocol(pkt);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
