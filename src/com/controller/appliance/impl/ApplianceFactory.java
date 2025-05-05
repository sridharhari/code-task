package com.controller.appliance.impl;

import com.controller.appliance.Appliance;

public class ApplianceFactory {
    public static Appliance createAppliance(String type) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light();
            case "fan":
                return new Fan();
            case "airconditioner":
            case "ac":
                return new AirConditioner();
            default:
                throw new IllegalArgumentException("Unknown appliance type: " + type);
        }
    }
}
