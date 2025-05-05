package com.controller.appliance.impl;

import com.controller.appliance.Appliance;

public class Light implements Appliance {
    private String switchPosition = "on";

    public void turnOff() {
        switchPosition = "off";
    }

    public boolean isOn() {
        return "on".equals(switchPosition);
    }
}