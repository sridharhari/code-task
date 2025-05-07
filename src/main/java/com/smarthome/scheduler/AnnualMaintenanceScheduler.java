package com.smarthome.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

import com.smarthome.service.SmartHomeService;

public class AnnualMaintenanceScheduler {
	
	private SmartHomeService smartHomeService;
	
    @Scheduled(cron = "0 0 1 1 1 *")
    public void yearlyMaintenance() {
        smartHomeService.turnOffAllDevices();
        System.out.println("[Scheduled] Yearly maintenance: all devices turned off.");
    }

}
