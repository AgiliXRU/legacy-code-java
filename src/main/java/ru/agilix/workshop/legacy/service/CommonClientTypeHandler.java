package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.ClientType;

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
