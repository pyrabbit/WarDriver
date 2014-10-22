package com.blackgatetech.wardriver.ui;

import com.blackgatetech.wardriver.lib.KismetClient;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainPanel extends JPanel {
    public MainPanel(JFrame af) {
        setLayout(new GridLayout(2,3));
        JPanel mainMenu = this;
        
        Icon settingsIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/settings.png");
        Icon startIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/start.png");
        Icon stopIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/stop.png");
        Icon locationIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/location.png");
        Icon seenIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/seen.png");
        Icon uploadIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/upload.png");
        Icon userIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/user.png");
        
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
        
       add(startButton);
       add(discoveredButton);
       add(gpsButton);
       add(uploadButton);
       add(userButton);
       add(settingsButton);

        startButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("Stop".equals(startButton.getText())) {
                    startButton.setIcon(startIcon);
                    startButton.setText("Start");
                } else {
                    startButton.setIcon(stopIcon);
                    startButton.setText("Stop");
                    
                    KismetClient conn = new KismetClient();
                    conn.connectToServer();
                }
                System.out.println("start/stop clicked");
            }
        });

        discoveredButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("discovered clicked");
                setVisible(false);
                DiscoveredPanel d = new DiscoveredPanel(mainMenu);
                af.add(d);
            }
        });
        
        gpsButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("gps clicked");
                setVisible(false);
                GpsPanel g = new GpsPanel(mainMenu);
                af.add(g);
            }
        });
        
        uploadButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("upload clicked");
                setVisible(false);
                UploadPanel u = new UploadPanel(mainMenu);
                af.add(u);
            }
        });

        userButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("user profile clicked");
                setVisible(false);
                UserPanel us = new UserPanel(mainMenu);
                af.add(us);
            }
        });
                
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
