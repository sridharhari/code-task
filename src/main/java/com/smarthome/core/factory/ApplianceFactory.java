package com.smarthome.core.factory;

import com.smarthome.core.Appliance;
import com.smarthome.core.impl.*;

public class ApplianceFactory {
    public static Appliance createAppliance(String type) {
        return switch (type.toLowerCase()) {
            case "light" -> new Light();
            case "fan" -> new Fan();
            case "ac", "airconditioner" -> new AirConditioner();
            default -> throw new IllegalArgumentException("Unknown appliance type");
        };
    }
}