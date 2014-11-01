package com.blackgatetech.wardriver.views;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GpsPanelView extends JPanel {
    private final JPanel labels = new JPanel(new GridLayout(6,2));
    private final JLabel latLabel = new JLabel("Latitude");
    private final JLabel latLoc = new JLabel("");
    private final JLabel lonLabel = new JLabel("Longitude");
    private final JLabel lonLoc = new JLabel("");
    private final JLabel fixLabel = new JLabel("Fix");
    private final JLabel fixVal = new JLabel("");
    private final JLabel speedLabel = new JLabel("Speed");
    private final JLabel speedVal = new JLabel("");
    private final JLabel headingLabel = new JLabel("Heading");
    private final JLabel headingVal = new JLabel("");
    private final JLabel altLabel = new JLabel("Altitude");
    private final JLabel altVal = new JLabel("");
    private final Icon backIcon = new ImageIcon("resources/back.png");
    private final JButton back = new JButton(backIcon);

    GpsPanelView(JPanel mp) {
        setLayout(new FlowLayout());
                
        latLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        latLoc.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        lonLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        lonLoc.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        fixLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        fixVal.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        speedLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        speedVal.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        headingLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        headingVal.setFont(new Font("Sans Serif", Font.PLAIN, 17));        
        altLabel.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        altVal.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        
        labels.add(latLabel);
        labels.add(latLoc);
        labels.add(lonLabel);
        labels.add(lonLoc);
        labels.add(fixLabel);
        labels.add(fixVal);
        labels.add(speedLabel);
        labels.add(speedVal);
        labels.add(headingLabel);
        labels.add(headingVal);
        labels.add(altLabel);
        labels.add(altVal);
        add(labels);
        add(back);
        
        back.addActionListener((ActionEvent e) -> {
            setVisible(false);
            mp.setVisible(true);
        });
    }
    
    public void setLatLabel(double lat) {
        this.latLoc.setText(Double.toString(lat) + "N");
    }
    
    public void setLonLabel(double lon) {
        this.lonLoc.setText(Double.toString(lon) + "W");
    }
    
    public void setFixLabel(int fix) {
        if (fix == 2 || fix == 3) {
            this.fixVal.setText(Integer.toString(fix) + "D fix");
        } else {
            this.fixVal.setText("No fix");
        }
            
    }
    
    public void setSpeedLabel(float speed) {
        this.speedVal.setText(Float.toString(speed) + "mph");
    }
    
    public void setHeadingLabel(float heading) {
        this.headingVal.setText(Float.toString(heading));
    }
    
    public void setAltLabel(float alt) {
        this.altVal.setText(Float.toString(alt) + "ft"); 
    }
}
