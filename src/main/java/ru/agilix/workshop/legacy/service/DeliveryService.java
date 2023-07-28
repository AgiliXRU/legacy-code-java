package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    public Integer calculate(String clientType, Integer cartAmount) throws Exception {

        switch (clientType) {
            case "Обычный":
                return new CommonDeliveryService().calculate(cartAmount);
            case "VIP":
                return new VipDeliveryService().calculate(cartAmount);
            case "Friends&Family":
                return new FnFDeliveryService().calculate(clientType, cartAmount);
            default:
                throw new Exception("Client type is not found: " + clientType);
        }
    }
}
