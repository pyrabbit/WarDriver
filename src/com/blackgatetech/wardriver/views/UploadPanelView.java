package com.blackgatetech.wardriver.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class UploadPanelView extends JPanel {
    UploadPanelView(JPanel mp) {
        setLayout(new FlowLayout());
        setVisible(true);
        JPanel progressPanel = new JPanel(new FlowLayout());
        
        JProgressBar progress = new JProgressBar();
        progress.setValue(84);
        JButton uploadButton = new JButton("Upload");
        
        JEditorPane console = new JEditorPane();
        console.setEditable(false);
        console.setPreferredSize(new Dimension(300,85));
        console.setText("Connecting to server...\nUploading heard points...");
        console.setBackground(Color.BLACK);
        console.setForeground(Color.WHITE);
        
        Icon backIcon = new ImageIcon("resources/back.png");
        JButton back = new JButton(backIcon);
        
        progressPanel.add(uploadButton);
        progressPanel.add(progress);
        
        progressPanel.setVisible(true);
        add(progressPanel);
        add(console);
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
