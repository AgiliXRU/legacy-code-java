package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VipDeliveryServiceShould {

    VipDeliveryService vipDeliveryService;

    @BeforeEach
    void setUp() {
        vipDeliveryService = new VipDeliveryService();
    }

    @Test
    void return_999_when_VIP_and_999_are_given() throws Exception {
        assertEquals(999, vipDeliveryService.calculate(999).intValue());
    }

    @Test
    void return_2499_when_VIP_and_2499_are_given() throws Exception {
        assertEquals(2499, vipDeliveryService.calculate(2499).intValue());
    }

    @Test
    void return_2500_when_VIP_and_2375_are_given() throws Exception {
        assertEquals(2375, vipDeliveryService.calculate(2500).intValue());
    }

}
