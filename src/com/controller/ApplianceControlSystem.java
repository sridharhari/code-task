package com.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.controller.appliance.Appliance;

public class ApplianceControlSystem {
	
    private List<Appliance> devices = new ArrayList<>();

    public void addDevice(Appliance device) {
        devices.add(device);
    }

    public void performYearlyUpdate(LocalDateTime currentTime) {
        if (currentTime.getMonthValue() == 1 && currentTime.getDayOfMonth() == 1 && currentTime.getHour() == 1) {
            for (Appliance device : devices) {
                device.turnOff();
            }
        }
    }

}
