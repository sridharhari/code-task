package com.smarthome.core.impl;

import com.smarthome.core.Appliance;

public class Fan implements Appliance {

    private int speed = 0;

    public void setSpeed(int speed) {
        if (speed < 0 || speed > 2) throw new IllegalArgumentException("Invalid speed for Fan. Allowed values are 0, 1, 2.");
        this.speed = speed;
    }

    public void turnOff() {
        this.speed = 0;
    }

    public boolean isOn() {
        return speed > 0;
    }

}
