
package com.blackgatetech.wardriver.views;

import com.blackgatetech.wardriver.controllers.*;
import com.blackgatetech.wardriver.lib.KismetListener;
import com.blackgatetech.wardriver.models.WardriverModel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuView extends JPanel {
        // Instantiate views
        private final DiscoveredPanelView discoveredView = new DiscoveredPanelView(this);
        private final GpsPanelView gpsView = new GpsPanelView(this);
        private final UploadPanelView uploadView = new UploadPanelView(this);
        private final UserPanelView userView = new UserPanelView(this);
        private final SettingsPanelView settingsView = new SettingsPanelView(this);
        
        // Instantiate models
        WardriverModel wardriverModel = new WardriverModel();

        // Declare Icons needed
        private final Icon settingsIcon = new ImageIcon("resources/settings.png");
        private final Icon startIcon = new ImageIcon("resources/start.png");
        private final Icon stopIcon = new ImageIcon("resources/stop.png");
        private final Icon locationIcon = new ImageIcon("resources/location.png");
        private final Icon seenIcon = new ImageIcon("resources/seen.png");
        private final Icon uploadIcon = new ImageIcon("resources/upload.png");
        private final Icon userIcon = new ImageIcon("resources/user.png");

        // Create main menu buttons
        final JButton startButton = new JButton("Start", startIcon);
        final JButton discoveredButton = new JButton("Discovered", seenIcon);
        final JButton gpsButton = new JButton("GPS", locationIcon);
        final JButton uploadButton = new JButton("Upload", uploadIcon);
        final JButton profileButton = new JButton("Profile", userIcon);
        final JButton settingsButton = new JButton("Settings", settingsIcon);        

        
        MainMenuController mainMenuController = new MainMenuController(this, wardriverModel);
        DiscoveredController discoveredController = new DiscoveredController(discoveredView, wardriverModel);
        GpsController gpsController = new GpsController(gpsView, wardriverModel);
//        UploadController uploadController = new UploadController(uploadView, wardriverModel);
//        UserController userController = new UserController(userView, wardriverModel); Will probably need to create a user model and api
//        SettingsController settingsController = new SettingsControlelr(settingsView, wardriverModel);
                
        public MainMenuView(MainView mf) {
            this.setLayout(new GridLayout(2,3));
            this.setVisible(true);
        
            // Set button attributes
            startButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            startButton.setHorizontalTextPosition(SwingConstants.CENTER);
            startButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));

            discoveredButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            discoveredButton.setHorizontalTextPosition(SwingConstants.CENTER);
            discoveredButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));            

            gpsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            gpsButton.setHorizontalTextPosition(SwingConstants.CENTER);
            gpsButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));            

            uploadButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            uploadButton.setHorizontalTextPosition(SwingConstants.CENTER);
            uploadButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));            

            profileButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            profileButton.setHorizontalTextPosition(SwingConstants.CENTER);
            profileButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));            

            settingsButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            settingsButton.setHorizontalTextPosition(SwingConstants.CENTER);
            settingsButton.setFont(new Font("Sans Serif", Font.PLAIN, 12));
            
            this.add(startButton);
            this.add(discoveredButton);
            this.add(gpsButton);
            this.add(uploadButton);
            this.add(profileButton);
            this.add(settingsButton);
            
            this.wardriverModel.addObserver(this.discoveredController);
            this.wardriverModel.addObserver(this.gpsController);

            discoveredButton.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                mf.add(discoveredView);
                discoveredView.setVisible(true);
            });
            
            gpsButton.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                mf.add(gpsView);
                gpsView.setVisible(true);
            });
            
            uploadButton.addActionListener((ActionEvent e) -> {
               this.setVisible(false);
               mf.add(uploadView);
               uploadView.setVisible(true);
            });
            
            profileButton.addActionListener((ActionEvent e) -> {
               this.setVisible(false);
               mf.add(userView);
               userView.setVisible(true);
            });
            
            settingsButton.addActionListener((ActionEvent e) -> {
               this.setVisible(false);
               mf.add(settingsView);
               settingsView.setVisible(true);
            });
            
            startButton.addActionListener(new KismetListener(wardriverModel));
        }
        
        
//        public void addToggleKismetListener (ActionListener listenForKismetToggle) {
//            startButton.addActionListener(listenForKismetToggle);
//        }
//         
        public void displayErrorMessage(String errorMessage) {
            JOptionPane.showMessageDialog(this, errorMessage);
        }
}
