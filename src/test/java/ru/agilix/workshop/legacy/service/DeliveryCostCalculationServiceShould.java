package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.agilix.workshop.legacy.ClientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeliveryCostCalculationServiceShould {

    DeliveryCostCalculationService deliveryCostCalculationService;

    @BeforeEach
    void setUp() {
        deliveryCostCalculationService = new DeliveryCostCalculationService();
    }

    @Test
    void returnCommonDeliveryService_whenClientIsCommon() {
        ClientType clientType = ClientType.ОБЫЧНЫЙ;

        final var clientTypeHandler =  deliveryCostCalculationService.getClientDeliveryService(clientType);

        assertEquals(CommonClientTypeHandler.class, clientTypeHandler.getClass());
    }

    @Test
    void returnVipDeliveryService_whenClientIsVip() {
        ClientType clientType = ClientType.VIP;

        final var clientTypeHandler =  deliveryCostCalculationService.getClientDeliveryService(clientType);

        assertEquals(VipClientTypeHandler.class, clientTypeHandler.getClass());
    }

    @Test
    void returnFnFDeliveryService_whenClientIsFnF() {
        ClientType clientType = ClientType.FnF;

        final var clientTypeHandler =  deliveryCostCalculationService.getClientDeliveryService(clientType);

        assertEquals(FnFClientTypeHandler.class, clientTypeHandler.getClass());
    }
}
