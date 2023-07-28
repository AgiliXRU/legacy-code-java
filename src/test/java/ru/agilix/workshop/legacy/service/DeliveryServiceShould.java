package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.agilix.workshop.legacy.service.DeliveryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryServiceShould {

    DeliveryService deliveryService;

    @BeforeEach
    void setUp() {
        deliveryService = new DeliveryService();
    }

    @Test
    void return_1249_when_Obichny_and_999_are_given() throws Exception {
        assertEquals(1249, deliveryService.calculate("Обычный", 999).intValue());
    }

    @Test
    void return_1000_when_Obichny_and_1000_are_given() throws Exception {
        assertEquals(1000, deliveryService.calculate("Обычный", 1000).intValue());
    }

    @Test
    void return_999_when_VIP_and_999_are_given() throws Exception {
        assertEquals(999, deliveryService.calculate("VIP", 999).intValue());
    }

    @Test
    void return_2499_when_VIP_and_2499_are_given() throws Exception {
        assertEquals(2499, deliveryService.calculate("VIP", 2499).intValue());
    }

    @Test
    void return_2500_when_VIP_and_2375_are_given() throws Exception {
        assertEquals(2375, deliveryService.calculate("VIP", 2500).intValue());
    }

    @Test
    void return_980_when_FriendsAndFamily_and_1000_are_given() throws Exception {
        assertEquals(980, deliveryService.calculate("Friends&Family", 1000).intValue());
    }

    @Test
    void throwException_whenUnknownClientTypeIsGiven() {
        String unknownClientType = "Неизвестный";
        Exception unknownClientTypeException = assertThrows(Exception.class, () -> {
            deliveryService.calculate(unknownClientType, 100500);
        });
        assertEquals("Client type is not found: " + unknownClientType, unknownClientTypeException.getMessage());
    }
}
