
package com.blackgatetech.wardriver.controllers;

import com.blackgatetech.wardriver.models.*;
import com.blackgatetech.wardriver.views.*;
import java.util.Observable;
import java.util.Observer;

public class DiscoveredController implements Observer {
    private final DiscoveredPanelView discoveredView;
    private final WardriverModel wardriverModel;
    
    public DiscoveredController(DiscoveredPanelView discoveredView, WardriverModel wardriverModel) {
        this.discoveredView = discoveredView;
        this.wardriverModel = wardriverModel;
    }

    @Override
    public void update(Observable o, Object arg) {
        discoveredView.setNetworkCountLabel(wardriverModel.getNetworkCount());
    }
}
