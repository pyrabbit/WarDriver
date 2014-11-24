package com.blackgatetech.wardriver.lib;

import com.blackgatetech.wardriver.models.WardriverModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KismetListener implements ActionListener {
    private KismetClient conn;
    private boolean connectedToKismetServer;

    private final Icon startIcon = new ImageIcon("resources/start.png");
    private final Icon stopIcon = new ImageIcon("resources/stop.png");
    private final WardriverModel wardriverModel;

    public KismetListener(WardriverModel wardriverModel) {
        this.connectedToKismetServer = false;
        this.wardriverModel = wardriverModel;
        this.conn = new KismetClient(this.wardriverModel);
    }
    
    public KismetListener (WardriverModel wardriverModel, KismetClient conn) {
        this.wardriverModel = wardriverModel;
        this.conn = conn;
        this.connectedToKismetServer = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        if (isConnectedToKismetServer()) {
            conn.disconnectFromServer();
            setConnectedToKismetServer(false);
            button.setText("Start");
            button.setIcon(startIcon);
        } else {
            setConnectedToKismetServer(conn.connectToServer());
            wardriverModel.connectToMongo();
            button.setText("Stop");
            button.setIcon(stopIcon);
        }
    }
    
    public boolean isConnectedToKismetServer() {
        return connectedToKismetServer;
    }

    public void setConnectedToKismetServer(boolean connectedToKismetServer) {
            this.connectedToKismetServer = connectedToKismetServer;
    }
}
