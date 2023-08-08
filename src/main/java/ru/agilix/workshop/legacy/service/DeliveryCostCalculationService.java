package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.ClientType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeliveryCostCalculationService implements CostCalculationService {

    private final Map<ClientType, ClientTypeHandler> handlers;

    public DeliveryCostCalculationService(List<ClientTypeHandler> handlerList) {
        handlers = handlerList.stream().collect(Collectors.toMap(ClientTypeHandler::getType, (it) -> it));
    }

    @Override
    public Integer calculate(String clientType, Integer cartAmount) throws UnknownClientTypeException {
        return getClientDeliveryService(ClientType.titleOf(clientType)).calculate(cartAmount);
    }

    public ClientTypeHandler getClientDeliveryService(ClientType clientType) {
        return handlers.get(clientType);
    }

}
