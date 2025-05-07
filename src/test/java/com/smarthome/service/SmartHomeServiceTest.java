package com.smarthome.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class SmartHomeServiceTest {

    private SmartHomeService smartHomeService;

    @BeforeEach
    void setUp() {
        smartHomeService = new SmartHomeService();
        smartHomeService.addDevice("light", "1");
        smartHomeService.addDevice("fan", "2");
        smartHomeService.addDevice("ac", "3");
    }

    @Test
    void testTurnOnLight() {
        smartHomeService.turnOn("1");
        assertTrue(smartHomeService.getStatus().get("1"));
    }

    @Test
    void testTurnOffLight() {
        smartHomeService.turnOn("1");
        smartHomeService.turnOff("1");
        assertFalse(smartHomeService.getStatus().get("1"));
    }

    @Test
    void testSetFanSpeed() {
        smartHomeService.setFanSpeed("2", 2);
        assertTrue(smartHomeService.getStatus().get("2"));
    }

    @Test
    void testSetAcMode() {
        smartHomeService.setAcMode("3", "heat");
        assertTrue(smartHomeService.getStatus().get("3"));
    }

    @Test
    void testTurnOffAllDevices() {
        smartHomeService.turnOn("1");
        smartHomeService.turnOn("2");
        smartHomeService.turnOn("3");
        smartHomeService.turnOffAllDevices();

        Map<String, Boolean> statuses = smartHomeService.getStatus();
        assertFalse(statuses.get("1"));
        assertFalse(statuses.get("2"));
        assertFalse(statuses.get("3"));
    }
    
    @Test
    void testSetInvalidFanSpeed() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            smartHomeService.setFanSpeed("2", 5);
        });
        assertEquals("Invalid speed for Fan. Allowed values are 0, 1, 2.", exception.getMessage());
    }

    @Test
    void testSetInvalidAcMode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            smartHomeService.setAcMode("3", "freeze");
        });
        assertEquals("Invalid AC mode. Allowed values are: cool, heat, off.", exception.getMessage());
    }
}