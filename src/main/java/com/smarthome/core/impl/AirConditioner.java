package com.smarthome.core.impl;

import com.smarthome.core.Appliance;

public class AirConditioner implements Appliance {


    private String thermostatMode = "off";

    public void setMode(String mode) {
        if (!mode.equals("cool") && !mode.equals("heat") && !mode.equals("off")) {
            throw new IllegalArgumentException("Invalid AC mode. Allowed values are: cool, heat, off.");
        }
        this.thermostatMode = mode;
    }

    public void turnOff() {
        this.thermostatMode = "off";
    }

    public boolean isOn() {
        return !"off".equals(thermostatMode);
    }

    public String getMode() {
        return thermostatMode;
    }

}
