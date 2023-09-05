package ru.andreyTw.delivery.service.clientType;

import org.springframework.stereotype.Service;
import ru.andreyTw.delivery.ClientType;

@Service
public class CommonClientTypeHandler implements ClientTypeHandler {

    @Override
    public Integer calculate(Integer cartAmount) {

        return cartAmount >= 1000 ? cartAmount : cartAmount + 250;
    }

    @Override
    public ClientType getType() {
        return ClientType.COMMON;
    }
}
