package com.blackgatetech.wardriver.ui;

import javax.swing.*;

/**
 *
 * @author matt
 */
public class Wardriver extends JFrame {
    public Wardriver() {
        JFrame appFrame = this;
        setTitle("Wardriver");
        setSize(320, 240);
        setResizable(false);
//        setExtendedState(Frame.MAXIMIZED_BOTH);
//        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainPanel m = new MainPanel(appFrame);
        add(m);
        m.setVisible(true);
    }
    
    public static void main(String[] args) {
        Wardriver wd = new Wardriver();
        wd.setVisible(true);
    }
}
