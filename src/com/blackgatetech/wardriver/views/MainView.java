package com.blackgatetech.wardriver.views;

import javax.swing.*;

public class MainView extends JFrame {
        public MainView(){
            // Set main frame attributes
            this.setTitle("Wardriver");
            this.setSize(320, 240);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Add main panel to main frame
            this.add(new MainMenuView(this));
        }
}
