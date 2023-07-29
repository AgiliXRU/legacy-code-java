package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryCostCalculationServiceShould {

    DeliveryCostCalculationService deliveryCostCalculationService;

    @BeforeEach
    void setUp() {
        deliveryCostCalculationService = new DeliveryCostCalculationService();
    }

    @Test
    void throwException_whenUnknownClientTypeIsGiven() {
        String unknownClientType = "Неизвестный";
        UnknownClientTypeException unknownClientTypeException = assertThrows(UnknownClientTypeException.class, () -> {
            deliveryCostCalculationService.calculate(unknownClientType, 100500);
        });
        assertEquals("Client type is not found: " + unknownClientType, unknownClientTypeException.getMessage());
    }
}
