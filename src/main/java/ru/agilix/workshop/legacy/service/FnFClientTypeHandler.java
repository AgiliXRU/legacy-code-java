package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;

@Service
public class FnFClientTypeHandler {

    public Integer calculate(Integer cartAmount) {

        return Double.valueOf(cartAmount * (1 - 2 / 100.0)).intValue();
    }
}
