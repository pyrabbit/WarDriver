package com.blackgatetech.wardriver.ui;

import java.awt.Color;
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

public class UserPanel extends JPanel {
    UserPanel(JPanel mp) {
        setLayout(new FlowLayout());
        setVisible(true);
        JPanel labels = new JPanel(new GridLayout(3,1));
        
        JLabel usernameLabel = new JLabel("rgr_matt");
        JLabel scoreLabel = new JLabel("10,743 points");
        JLabel onlineLabel = new JLabel("Online");
        
        usernameLabel.setFont(new Font("Sans Serif", Font.PLAIN, 36));
        scoreLabel.setFont(new Font("Sans Serif", Font.PLAIN, 36));
        onlineLabel.setFont(new Font("Sans Serif", Font.PLAIN, 36));
        onlineLabel.setForeground(Color.green);
        
        Icon backIcon = new ImageIcon("/Users/matt/Dropbox/Matthew/Programming/Wardriver/WarDriver/src/com/blackgatetech/wardriver/ui/back.png");
        JButton back = new JButton(backIcon);
        
        labels.add(usernameLabel);
        labels.add(scoreLabel);
        labels.add(onlineLabel);
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
