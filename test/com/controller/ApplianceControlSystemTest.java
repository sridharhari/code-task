package com.controller;

import com.controller.appliance.Appliance;
import com.controller.appliance.impl.ApplianceFactory;

import java.time.LocalDateTime;

public class ApplianceControlSystemTest {
	
	   public static void main(String[] args) {
	        Appliance light = ApplianceFactory.createAppliance("light");
	        Appliance fan = ApplianceFactory.createAppliance("fan");
	        Appliance ac = ApplianceFactory.createAppliance("ac");
	        ApplianceControlSystem controller = new ApplianceControlSystem();

	        controller.addDevice(light);
	        controller.addDevice(fan);
	        controller.addDevice(ac);

	        // Test turnOff
	        light.turnOff();
	        assert !light.isOn() : "Light should be off";

	        fan.turnOff();
	        assert !fan.isOn() : "Fan should be off";

	        ac.turnOff();
	        assert !ac.isOn() : "AC should be off";

	        // Reset states
	        light = ApplianceFactory.createAppliance("light");
	        fan = ApplianceFactory.createAppliance("fan");
	        ac = ApplianceFactory.createAppliance("ac");

	        controller = new ApplianceControlSystem();
	        controller.addDevice(light);
	        controller.addDevice(fan);
	        controller.addDevice(ac);

	        // Simulate yearly update
	        LocalDateTime updateTime = LocalDateTime.of(2025, 1, 1, 1, 0);
	        controller.performYearlyUpdate(updateTime);

	        assert !light.isOn() : "Light should be off after yearly update";
	        assert !fan.isOn() : "Fan should be off after yearly update";
	        assert !ac.isOn() : "AC should be off after yearly update";

	        // Simulate wrong time
	        light = ApplianceFactory.createAppliance("light");
	        fan = ApplianceFactory.createAppliance("fan");
	        ac = ApplianceFactory.createAppliance("ac");

	        controller = new ApplianceControlSystem();
	        controller.addDevice(light);
	        controller.addDevice(fan);
	        controller.addDevice(ac);

	        LocalDateTime wrongTime = LocalDateTime.of(2025, 6, 1, 1, 0);
	        controller.performYearlyUpdate(wrongTime);

	        assert light.isOn() : "Light should still be on";
	        assert fan.isOn() : "Fan should still be on";
	        assert ac.isOn() : "AC should still be on";

	        System.out.println("All tests passed.");
	   }

}
