package ru.agilix.workshop.legacy;

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
    void calculate_sum_of_order_1249_when_Obichny_type_and_sum_of_basket_999_are_given() {
        assertEquals(1249, deliveryController.calculate("Обычный", 999).intValue());
    }

    @Test
    void calculate_sum_of_order_1000_when_Obichny_type_and_sum_of_basket_1000_are_given() {
        assertEquals(1000, deliveryController.calculate("Обычный", 1000).intValue());
    }

    @Test
    void calculate_sum_of_order_999_when_VIP_type_and_sum_of_basket_999_are_given() {
        assertEquals(999, deliveryController.calculate("VIP", 999).intValue());
    }

    @Test
    void calculate_sum_of_order_2499_when_VIP_type_and_sum_of_basket_2499_are_given() {
        assertEquals(2499, deliveryController.calculate("VIP", 2499).intValue());
    }

    @Test
    void calculate_sum_of_order_2500_when_VIP_type_and_sum_of_basket_2375_are_given() {
        assertEquals(2375, deliveryController.calculate("VIP", 2500).intValue());
    }
}
