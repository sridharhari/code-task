package com.controller.appliance.impl;

import com.controller.appliance.Appliance;

public class AirConditioner implements Appliance {
    private String thermostatMode = "cool"; // Modes: 'cool', 'heat', 'off'

    public void turnOff() {
        thermostatMode = "off";
    }

    public boolean isOn() {
        return !"off".equals(thermostatMode);
    }
}
