package com.blackgatetech.wardriver.lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract public class KismetListener {
    // Create a hash to store all the kismet message subscriptions
    Map<String, Set<Class>> subscriptions = new HashMap<>();
    
    // Create a method for subscribing to messages and their fields
    public void subscribe(Class messageType, String fields) throws IOException {
        // Subscribe passes in the class as messageType and requested fields
        Protocol protocol = (Protocol) messageType.getAnnotation(Protocol.class);
    }
}
