package com.smarthome.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smarthome.service.SmartHomeService;

@Component
public class AnnualMaintenanceScheduler {
	
	@Autowired
	private SmartHomeService smartHomeService;
	
    @Scheduled(cron = "${app.annual.maintenance.schedule}")
    public void yearlyMaintenance() {
        smartHomeService.turnOffAllDevices();
        System.out.println("[Scheduled] Yearly maintenance: all devices turned off.");
    }

}
