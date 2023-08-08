package ru.agilix.workshop.legacy.service;

import ru.agilix.workshop.legacy.ClientType;

public interface ClientTypeHandler {
    Integer calculate(Integer cartAmount);

    ClientType getType();
}
