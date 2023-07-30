package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryCostCalculationService implements CostCalculationService {

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
}
