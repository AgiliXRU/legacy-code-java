package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.agilix.workshop.legacy.ClientType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostCalculationServiceShould {

    DeliveryCostCalculationService deliveryCostCalculationService;

//    @BeforeEach
//    void setUp() {
//
//        final var handlers = new HashMap<ClientType, ClientTypeHandler>(){{
//            put(ClientType.COMMON, new CommonClientTypeHandler());
//        }};
//        deliveryCostCalculationService = new DeliveryCostCalculationService(handlers);
//    }
//
//    @Test
//    void returnCommonDeliveryService_whenClientIsCommon() {
//        ClientType clientType = ClientType.COMMON;
//
//        final var clientTypeHandler =  deliveryCostCalculationService.getClientDeliveryService(clientType);
//
//        assertEquals(CommonClientTypeHandler.class, clientTypeHandler.getClass());
//    }

}
