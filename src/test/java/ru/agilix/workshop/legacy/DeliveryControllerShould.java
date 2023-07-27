package ru.agilix.workshop.legacy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryControllerShould {

    DeliveryController deliveryController;

    @BeforeEach
    void setUp() {
        deliveryController = new DeliveryController();
    }

    @Test
    void return_1249_when_Obichny_and_999_are_given() throws Exception {
        assertEquals(1249, deliveryController.calculate("Обычный", 999).intValue());
    }

    @Test
    void return_1000_when_Obichny_and_1000_are_given() throws Exception {
        assertEquals(1000, deliveryController.calculate("Обычный", 1000).intValue());
    }

    @Test
    void return_999_when_VIP_and_999_are_given() throws Exception {
        assertEquals(999, deliveryController.calculate("VIP", 999).intValue());
    }

    @Test
    void return_2499_when_VIP_and_2499_are_given() throws Exception {
        assertEquals(2499, deliveryController.calculate("VIP", 2499).intValue());
    }

    @Test
    void return_2500_when_VIP_and_2375_are_given() throws Exception {
        assertEquals(2375, deliveryController.calculate("VIP", 2500).intValue());
    }

    @Test
    void return_980_when_FriendsAndFamily_and_1000_are_given() throws Exception {
        assertEquals(980, deliveryController.calculate("Friends&Family", 1000).intValue());
    }

    @Test
    void throwException_whenUnknownClientTypeIsGiven() {
        String unknownClientType = "Неизвестный";
        Exception unknownClientTypeException = Assertions.assertThrows(Exception.class, () -> {
            deliveryController.calculate(unknownClientType, 100500);
        });
        Assertions.assertEquals("Client type is not found: " + unknownClientType, unknownClientTypeException.getMessage());
    }
}
