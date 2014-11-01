
package com.blackgatetech.wardriver.controllers;

import com.blackgatetech.wardriver.models.*;
import com.blackgatetech.wardriver.views.*;
import java.util.Observable;
import java.util.Observer;

public class GpsController implements Observer {
    private final GpsPanelView gpsView;
    private final WardriverModel wardriverModel;
    
    public GpsController(GpsPanelView gpsView, WardriverModel wardriverModel) {
        this.gpsView = gpsView;
        this.wardriverModel = wardriverModel;
    }

    @Override
    public void update(Observable o, Object arg) {
        gpsView.setLatLabel(wardriverModel.getLatitude());
        gpsView.setLonLabel(wardriverModel.getLongitude());
        gpsView.setFixLabel(wardriverModel.getFix());
        gpsView.setSpeedLabel(wardriverModel.getSpeed());
        gpsView.setHeadingLabel(wardriverModel.getHeading());
        gpsView.setAltLabel(wardriverModel.getAltitude());
    }
}
