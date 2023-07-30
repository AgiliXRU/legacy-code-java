package ru.agilix.workshop.legacy.service;

public interface CostCalculationService {
    Integer calculate(String clientType, Integer cartAmount)  throws UnknownClientTypeException;
}
