package com.blackgatetech.wardriver.lib;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class KismetClient implements Runnable {
    final private String host;
    final private int port;
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    
    public KismetClient() {
        this.port = 2501;
        this.host = "localhost";
    }
    
    public KismetClient(String h, int p) {
        this.port = p;
        this.host = h;     
    }

    public void connectToServer() {
        try {
            Socket socket = new Socket(this.host, this.port);
            System.out.println("Connected to " + this.host + ":" + this.port);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                // grab next kismet message
                // parse kismet message
                // do something with kismet message
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
