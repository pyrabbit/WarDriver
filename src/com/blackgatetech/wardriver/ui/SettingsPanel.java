package com.blackgatetech.wardriver.ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SettingsPanel extends JPanel {
    SettingsPanel(JPanel mp) {
        // Initiate Settings Layout and make it visible
        setLayout(new GridLayout(2,3));
        setVisible(true);
        
        // Instantiate needed icons
        Icon channelsIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/channels.png");
        Icon dwellIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/dwell.png");
        Icon backIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/back.png");
        
        // Create buttons and modify them
        JButton back = new JButton(backIcon);
        JButton lowbandButton = new JButton("2.4 Ghz", channelsIcon);
        lowbandButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        lowbandButton.setHorizontalTextPosition(SwingConstants.CENTER);
        lowbandButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        JButton highbandButton = new JButton("5 Ghz", channelsIcon);
        highbandButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        highbandButton.setHorizontalTextPosition(SwingConstants.CENTER);
        highbandButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        highbandButton.setEnabled(false);
        JButton dwellButton = new JButton("Dwell Time", dwellIcon);
        dwellButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        dwellButton.setHorizontalTextPosition(SwingConstants.CENTER);
        dwellButton.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        
        // Add elements to screen
        add(lowbandButton);
        add(highbandButton);
        add(dwellButton);
        add(back);

        // actions for back button
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mp.setVisible(true);
            }
        });
        
        // actions for low band button
        lowbandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("low band pressed");
            }
        });
        
        // actions for high band button
        highbandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("high band pressed");
            }
        });
        
        // actions for dwell button
        dwellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dwell pressed");
            }
        });    
    }
}
