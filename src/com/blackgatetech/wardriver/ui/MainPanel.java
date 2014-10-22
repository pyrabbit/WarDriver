package com.blackgatetech.wardriver.ui;

import com.blackgatetech.wardriver.lib.KismetClient;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainPanel extends JPanel {
    public MainPanel(JFrame af) {
        // Instantiate KismetClient connection
        KismetClient conn = new KismetClient();
        
        // GUI Magic
        setLayout(new GridLayout(2,3));
        JPanel mainMenu = this;
        
        // Declare Icons needed
        Icon settingsIcon = new ImageIcon("resources/settings.png");
        Icon startIcon = new ImageIcon("resources/start.png");
        Icon stopIcon = new ImageIcon("resources/stop.png");
        Icon locationIcon = new ImageIcon("resources/location.png");
        Icon seenIcon = new ImageIcon("resources/seen.png");
        Icon uploadIcon = new ImageIcon("resources/upload.png");
        Icon userIcon = new ImageIcon("resources/user.png");
        
        // Create and modify main menu buttons
        JButton startButton = new JButton("Start", startIcon);
        startButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        startButton.setHorizontalTextPosition(SwingConstants.CENTER);
        startButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton discoveredButton = new JButton("Discovered", seenIcon);
        discoveredButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        discoveredButton.setHorizontalTextPosition(SwingConstants.CENTER);
        discoveredButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton gpsButton = new JButton("GPS", locationIcon);
        gpsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        gpsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        gpsButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton uploadButton = new JButton("Upload", uploadIcon);
        uploadButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        uploadButton.setHorizontalTextPosition(SwingConstants.CENTER);
        uploadButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton userButton = new JButton("Profile", userIcon);
        userButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        userButton.setHorizontalTextPosition(SwingConstants.CENTER);
        userButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton settingsButton = new JButton("Settings", settingsIcon);
        settingsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        settingsButton.setHorizontalTextPosition(SwingConstants.CENTER);
        settingsButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        
        // Add elements to GUI
        add(startButton);
        add(discoveredButton);
        add(gpsButton);
        add(uploadButton);
        add(userButton);
        add(settingsButton);

        // ActionListener for start button
        startButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e){
                if("Start".equals(startButton.getText())) {
                    try {
                        if (conn.connectToServer()) {
                            startButton.setIcon(stopIcon);
                            startButton.setText("Stop");
                        }
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    startButton.setIcon(startIcon);
                    startButton.setText("Start");
                    conn.disconnectFromServer();
                }
            }
        });

        // ActionListener for discovered button
        discoveredButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("discovered clicked");
                setVisible(false);
                DiscoveredPanel d = new DiscoveredPanel(mainMenu, conn);
                af.add(d);
            }
        });

        // ActionListener for gps button
        gpsButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("gps clicked");
                setVisible(false);
                GpsPanel g = new GpsPanel(mainMenu);
                af.add(g);
            }
        });
        
        // ActionListener for upload button       
        uploadButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("upload clicked");
                setVisible(false);
                UploadPanel u = new UploadPanel(mainMenu);
                af.add(u);
            }
        });

        // ActionListener for user button
        userButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("user profile clicked");
                setVisible(false);
                UserPanel us = new UserPanel(mainMenu);
                af.add(us);
            }
        });
           
        // ActionListener for settings button
        settingsButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("settings clicked");
                setVisible(false);
                SettingsPanel s = new SettingsPanel(mainMenu);
                af.add(s);
            }
        });
        
    }
}
