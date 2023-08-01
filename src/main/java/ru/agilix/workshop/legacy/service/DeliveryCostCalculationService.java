package ru.agilix.workshop.legacy.service;

import lombok.AllArgsConstructor;
import ru.agilix.workshop.legacy.ClientType;

import java.util.Map;

@AllArgsConstructor
public class DeliveryCostCalculationService implements CostCalculationService {

    private final Map<ClientType, ClientTypeHandler> handlers;

    @Override
    public Integer calculate(String clientType, Integer cartAmount) throws UnknownClientTypeException {
        return getClientDeliveryService(ClientType.titleOf(clientType)).calculate(cartAmount);
    }


    public ClientTypeHandler getClientDeliveryService(ClientType clientType) {
        return handlers.get(clientType);
    }
}
