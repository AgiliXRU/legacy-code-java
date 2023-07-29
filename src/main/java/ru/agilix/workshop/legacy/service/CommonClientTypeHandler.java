package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;

@Service
public class CommonClientTypeHandler {

    public Integer calculate(Integer cartAmount) {

        return cartAmount >= 1000 ? cartAmount : cartAmount + 250;
    }
}
