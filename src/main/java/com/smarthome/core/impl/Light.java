package com.smarthome.core.impl;

import com.smarthome.core.Appliance;

public class Light implements Appliance {
	
    private String switchPosition = "off";

    public void turnOn() {
        switchPosition = "on";
    }

    public void turnOff() {
        switchPosition = "off";
    }

    public boolean isOn() {
        return "on".equals(switchPosition);
    }

}
