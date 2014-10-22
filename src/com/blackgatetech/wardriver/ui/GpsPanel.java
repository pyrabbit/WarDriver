package com.blackgatetech.wardriver.ui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GpsPanel extends JPanel {
    GpsPanel(JPanel mp) {
        setLayout(new FlowLayout());
        setVisible(true);
        
        JPanel labels = new JPanel(new GridLayout(5,2));
        
        JLabel latLabel = new JLabel("Latitude");
        latLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel latLoc = new JLabel("38°53'23\"N");
        latLoc.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel lonLabel = new JLabel("Longitude");
        lonLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel lonLoc = new JLabel("77°00'27\"W");
        lonLoc.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel accuracyLabel = new JLabel("Accuracy");
        accuracyLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel accuracyLabelVal = new JLabel("12ft");
        accuracyLabelVal.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel satLabel = new JLabel("Satellites");
        satLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel satLabelVal = new JLabel("13");
        satLabelVal.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel velocityLabel = new JLabel("Velocity");
        velocityLabel.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        JLabel velocityLabelVal = new JLabel("37 mph");
        velocityLabelVal.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        
        Icon backIcon = new ImageIcon("resources/back.png");
        JButton back = new JButton(backIcon);
        
        labels.add(latLabel);
        labels.add(latLoc);
        labels.add(lonLabel);
        labels.add(lonLoc);
        labels.add(accuracyLabel);
        labels.add(accuracyLabelVal);
        labels.add(satLabel);
        labels.add(satLabelVal);
        labels.add(velocityLabel);
        labels.add(velocityLabelVal);
        add(labels);
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
