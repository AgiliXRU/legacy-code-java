package ru.agilix.workshop.legacy.service.clientType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonClientTypeHandlerShould {

    CommonClientTypeHandler commonClientTypeHandler;

    @BeforeEach
    void setUp() {
        commonClientTypeHandler = new CommonClientTypeHandler();
    }

    @Test
    void return_1249_when_Obichny_and_999_are_given() {
        assertEquals(1249, commonClientTypeHandler.calculate(999).intValue());
    }

    @Test
    void return_1000_when_Obichny_and_1000_are_given() {
        assertEquals(1000, commonClientTypeHandler.calculate(1000).intValue());
    }
}
