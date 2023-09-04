package ru.agilix.workshop.legacy.service.clientType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VipClientTypeHandlerShould {

    VipClientTypeHandler vipClientTypeHandler;

    @BeforeEach
    void setUp() {
        vipClientTypeHandler = new VipClientTypeHandler();
    }

    @Test
    void return_999_when_VIP_and_999_are_given() {
        assertEquals(999, vipClientTypeHandler.calculate(999).intValue());
    }

    @Test
    void return_2499_when_VIP_and_2499_are_given() {
        assertEquals(2499, vipClientTypeHandler.calculate(2499).intValue());
    }

    @Test
    void return_2500_when_VIP_and_2375_are_given() {
        assertEquals(2375, vipClientTypeHandler.calculate(2500).intValue());
    }
}
