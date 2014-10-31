package com.blackgatetech.wardriver.controllers;

import com.blackgatetech.wardriver.models.*;
import com.blackgatetech.wardriver.views.*;
import com.blackgatetech.wardriver.lib.KismetListener;

public class MainMenuController {
    private final MainMenuView mainMenuView;
    private final WardriverModel wardriverModel;
    
    public MainMenuController(MainMenuView mainMenuView, WardriverModel wardriverModel) {
        this.mainMenuView = mainMenuView;
        this.wardriverModel = wardriverModel;
        
        this.mainMenuView.addToggleKismetListener(new KismetListener(this.wardriverModel));
    }
}
