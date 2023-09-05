package ru.andreyTw.delivery.service;

import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException;

public interface CostCalculationService {
    Integer calculate(String clientType, Integer cartAmount)  throws UnknownClientTypeException;
}
