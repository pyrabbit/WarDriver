package com.blackgatetech.wardriver.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class KismetClient implements Runnable {
    final private String host;
    final private int port;
    private BufferedReader fromServer;
    private BufferedWriter toServer;
    Socket socket;
    
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
            socket = new Socket(this.host, this.port);
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connected to " + this.host + ":" + this.port);
            System.out.println("Subscribing to BSSID headers");
            toServer.write("!0 REMOVE TIME\r\n");
            toServer.write("!0 ENABLE BSSID bssid,channel\r\n");
            toServer.write("!0 ENABLE SSID mac,ssid\r\n");
            toServer.flush();
            Thread thread = new Thread(this);
            thread.start();
            return true;
        } catch (ConnectException ex) {
            System.err.println("Cannot connect to kismet server, it is probably down.");
            return false;
        }
    }
    
    public void disconnectFromServer() {
        try {
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
                System.out.println(fromServer.readLine());
                // parse kismet message
                // do something with kismet message
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
