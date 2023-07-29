package ru.agilix.workshop.legacy.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FnFClientTypeHandlerShould {

    FnFClientTypeHandler fnFClientTypeHandler;

    @BeforeEach
    void setUp() {
        fnFClientTypeHandler = new FnFClientTypeHandler();
    }

    @Test
    void return_980_when_FriendsAndFamily_and_1000_are_given() throws Exception {
        assertEquals(980, fnFClientTypeHandler.calculate(1000).intValue());
    }
}
