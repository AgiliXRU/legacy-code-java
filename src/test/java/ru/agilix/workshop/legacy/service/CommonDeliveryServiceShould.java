package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonDeliveryServiceShould {

    CommonDeliveryService commonDeliveryService;

    @BeforeEach
    void setUp() {
        commonDeliveryService = new CommonDeliveryService();
    }

    @Test
    void return_1249_when_Obichny_and_999_are_given() throws Exception {
        assertEquals(1249, commonDeliveryService.calculate(999).intValue());
    }

    @Test
    void return_1000_when_Obichny_and_1000_are_given() throws Exception {
        assertEquals(1000, commonDeliveryService.calculate(1000).intValue());
    }

}
