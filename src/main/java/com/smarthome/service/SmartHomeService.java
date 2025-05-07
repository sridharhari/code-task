package com.smarthome.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.smarthome.core.Appliance;
import com.smarthome.core.factory.ApplianceFactory;
import com.smarthome.core.impl.AirConditioner;
import com.smarthome.core.impl.Fan;
import com.smarthome.core.impl.Light;

@Component
public class SmartHomeService {
	
	  	private final Map<String, Appliance> devices = new HashMap<>();

	    public void addDevice(String type, String id) {
	        devices.put(id, ApplianceFactory.createAppliance(type));
	    }
	    

	    public void turnOff(String id) {
	        if (devices.containsKey(id)) {
	            devices.get(id).turnOff();
	        }
	    }

	    public void turnOn(String id) {
	        Appliance appliance = devices.get(id);
	        if (appliance instanceof Light) {
	            ((Light) appliance).turnOn();
	        } else if (appliance instanceof Fan) {
	            ((Fan) appliance).setSpeed(1);
	        } else if (appliance instanceof AirConditioner) {
	            ((AirConditioner) appliance).setMode("cool");
	        }
	    }

	    public void setFanSpeed(String id, int speed) {
	    	
	        Appliance appliance = devices.getOrDefault(id, ApplianceFactory.createAppliance("fan"));
	        if (appliance instanceof Fan) {
	            ((Fan) appliance).setSpeed(speed);
	            devices.putIfAbsent(id, appliance);
	        }
	    }

	    public void setAcMode(String id, String mode) {
	        Appliance appliance = devices.getOrDefault(id, ApplianceFactory.createAppliance("airconditioner"));
	        if (appliance instanceof AirConditioner) {
	            ((AirConditioner) appliance).setMode(mode);
	            devices.putIfAbsent(id, appliance);
	        }
	    }

	    public Map<String, Boolean> getStatus() {
	        Map<String, Boolean> statusMap = new HashMap<>();
	        for (Map.Entry<String, Appliance> entry : devices.entrySet()) {
	            statusMap.put(entry.getKey(), entry.getValue().isOn());
	        }
	        return statusMap;
	    }

	    public void turnOffAllDevices() {
	        for (Appliance device : devices.values()) {
	            device.turnOff();
	        }
	    }

}
