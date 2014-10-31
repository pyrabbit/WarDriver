package com.blackgatetech.wardriver.views;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class DiscoveredPanelView extends JPanel {
    private JLabel networksCountLabel = new JLabel("");
    private final JLabel networksLabel = new JLabel("Networks");
    private final Icon backIcon = new ImageIcon("resources/back.png");
    private final JButton back = new JButton(backIcon);
    private final JPanel labelsPanel = new JPanel(new GridLayout(6,2));

        
    public DiscoveredPanelView(JPanel mp) {
        setLayout(new FlowLayout());
        
        labelsPanel.add(networksLabel);
        labelsPanel.add(networksCountLabel);
        
        add(labelsPanel);
        add(back);

        back.addActionListener((ActionEvent e) -> {
            setVisible(false);
            mp.setVisible(true);
        });
    }
    
    public void setNetworkCountLabel(int count) {
        this.networksCountLabel.setText(Integer.toString(count));
    }
}