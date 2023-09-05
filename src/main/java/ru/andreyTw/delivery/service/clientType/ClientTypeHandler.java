package ru.andreyTw.delivery.service.clientType;

import ru.andreyTw.delivery.ClientType;

public interface ClientTypeHandler {
    Integer calculate(Integer cartAmount);

    ClientType getType();
}
