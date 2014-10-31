package com.blackgatetech.wardriver.lib;

import com.blackgatetech.wardriver.models.WardriverModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KismetListener implements ActionListener {
    
    private final KismetClient conn;
    private boolean connectedToKismetServer = false;
    private final Icon startIcon = new ImageIcon("resources/start.png");
    private final Icon stopIcon = new ImageIcon("resources/stop.png");
    private final WardriverModel wardriverModel;

    public KismetListener(WardriverModel wardriverModel) {
        this.wardriverModel = wardriverModel;
        this.conn = new KismetClient(this.wardriverModel);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        
        if (!connectedToKismetServer) {
            if (conn.connectToServer()) {
                connectedToKismetServer = true;
                button.setText("Stop");
                button.setIcon(stopIcon);
            }
        } else {
            conn.disconnectFromServer();
            connectedToKismetServer = false;
            button.setText("Start");
            button.setIcon(startIcon);
        }
    }
    
}
