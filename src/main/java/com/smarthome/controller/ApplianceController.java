package com.smarthome.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarthome.service.SmartHomeService;

@RestController
@RequestMapping("/appliances")
public class ApplianceController {


	@Autowired
    private SmartHomeService smartHomeService;

    @PostMapping("/add")
    public String addDevice(@RequestParam String type, @RequestParam String id) {
        smartHomeService.addDevice(type, id);
        return type + " added with id " + id;
    }

    @PostMapping("/turnOn")
    public String turnOn(@RequestParam String id) {
        smartHomeService.turnOn(id);
        return "Device " + id + " turned on";
    }

    @PostMapping("/turnOff")
    public String turnOff(@RequestParam String id) {
        smartHomeService.turnOff(id);
        return "Device " + id + " turned off";
    }

    @PostMapping("/setFanSpeed")
    public String setFanSpeed(@RequestParam String id, @RequestParam int speed) {
    	smartHomeService.setFanSpeed(id, speed);
        return "Fan " + id + " speed set to " + speed;
    }

    @PostMapping("/setAcMode")
    public String setAcMode(@RequestParam String id, @RequestParam String mode) {
        smartHomeService.setAcMode(id, mode);
        return "AC " + id + " mode set to " + mode;
    }

    @GetMapping("/status")
    public Map<String, Boolean> getStatus() {
        return smartHomeService.getStatus();
    }
}
