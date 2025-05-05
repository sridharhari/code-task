package com.controller.appliance.impl;

import com.controller.appliance.Appliance;

public class Fan implements Appliance {
    private int speed = 1; // Speed can be 0 (off), 1, or 2

    public void turnOff() {
        speed = 0;
    }

    public boolean isOn() {
        return speed > 0;
    }
}
