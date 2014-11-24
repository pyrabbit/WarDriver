package com.blackgatetech.wardriver.controllers;

import com.blackgatetech.wardriver.models.*;
import com.blackgatetech.wardriver.views.*;
import com.blackgatetech.wardriver.lib.KismetListener;

public class MainMenuController {
    private final KismetListener kismetListener;
    private final MainMenuView mainMenuView;
    private final WardriverModel wardriverModel;
    
    public MainMenuController(MainMenuView mainMenuView, WardriverModel wardriverModel) {
        this.wardriverModel = wardriverModel;
        this.kismetListener = new KismetListener(this.wardriverModel);
        this.mainMenuView = mainMenuView;
//        this.mainMenuView.addToggleKismetListener(this.kismetListener);
    }
}
