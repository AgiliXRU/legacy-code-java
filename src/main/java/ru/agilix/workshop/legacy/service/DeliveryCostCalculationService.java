package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.ClientType;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeliveryCostCalculationService implements CostCalculationService {

    private final Map<ClientType, ClientTypeHandler> MAP = new HashMap<>();

    DeliveryCostCalculationService() {
        MAP.put(ClientType.ОБЫЧНЫЙ, new CommonClientTypeHandler());
        MAP.put(ClientType.VIP, new VipClientTypeHandler());
        MAP.put(ClientType.FnF, new FnFClientTypeHandler());
    }

    @Override
    public Integer calculate(String clientType, Integer cartAmount) throws UnknownClientTypeException {

        switch (clientType) {
            case "Обычный":
                return new CommonClientTypeHandler().calculate(cartAmount);
            case "VIP":
                return new VipClientTypeHandler().calculate(cartAmount);
            case "Friends&Family":
                return new FnFClientTypeHandler().calculate(cartAmount);
            default:
                throw new UnknownClientTypeException(clientType);
        }
    }


    public ClientTypeHandler getClientDeliveryService(ClientType clientType) {
        return MAP.get(clientType);
    }
}
