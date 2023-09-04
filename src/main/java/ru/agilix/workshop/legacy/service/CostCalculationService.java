package ru.agilix.workshop.legacy.service;

import ru.agilix.workshop.legacy.service.clientType.UnknownClientTypeException;

public interface CostCalculationService {
    Integer calculate(String clientType, Integer cartAmount)  throws UnknownClientTypeException;
}
