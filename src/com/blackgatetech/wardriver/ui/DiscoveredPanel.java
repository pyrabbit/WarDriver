package com.blackgatetech.wardriver.ui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DiscoveredPanel extends JPanel {
    public DiscoveredPanel(JPanel mp) {
        setLayout(new FlowLayout());
        setVisible(true);
        JPanel labelsPanel = new JPanel(new GridLayout(6,2,60,0));
        
        JLabel unassociatedLabel = new JLabel("Unassociated");
        unassociatedLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel networksLabel = new JLabel("Networks");
        networksLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel openLabel = new JLabel("Open");
        openLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wepLabel = new JLabel("WEP");
        wepLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wpaLabel = new JLabel("WPA");
        wpaLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wpa2Label = new JLabel("WPA2");
        wpa2Label.setFont(new Font("Sans Serif", Font.PLAIN, 18));

        JLabel unassociatedCountLabel = new JLabel("7365");
        unassociatedCountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel networksCountLabel = new JLabel("18456");
        networksCountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel openCountLabel = new JLabel("7657");
        openCountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wepCountLabel = new JLabel("3455");
        wepCountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wpaCountLabel = new JLabel("54325");
        wpaCountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        JLabel wpa2CountLabel = new JLabel("64654");
        wpa2CountLabel.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        
        Icon backIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/back.png");
        JButton back = new JButton(backIcon);
        
        labelsPanel.add(unassociatedLabel);
        labelsPanel.add(unassociatedCountLabel);
        labelsPanel.add(networksLabel);
        labelsPanel.add(networksCountLabel);
        labelsPanel.add(openLabel);
        labelsPanel.add(openCountLabel);
        labelsPanel.add(wepLabel);
        labelsPanel.add(wepCountLabel);
        labelsPanel.add(wpaLabel);
        labelsPanel.add(wpaCountLabel);
        labelsPanel.add(wpa2Label);
        labelsPanel.add(wpa2CountLabel);
        add(labelsPanel);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                mp.setVisible(true);
            }
        });
    }
}

/*
Unassociated
Networks
Open
WEP
WPA
WPA2
*/