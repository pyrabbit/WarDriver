package com.blackgatetech.wardriver.models;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class WardriverModel extends Observable {
    Set<String> networksSeen = new HashSet<>();
    private int networkCount = 0;
    
    public void parseKismetPotocol(String[] pkt) {
        switch(pkt[0]) {
            
            case "*BSSID:":
                // if channel is not equal to zero and packet is added to set
                if (!"0".equals(pkt[2]) && networksSeen.add(pkt[1])) {
                    setNetworkCount(networksSeen.size());
                }          
                break;
        }
    }
    
    public int getNetworkCount() { return this.networkCount; }
    
    public void setNetworkCount(int count) { 
        this.networkCount = count;
        setChanged();
        notifyObservers();
    }
}
