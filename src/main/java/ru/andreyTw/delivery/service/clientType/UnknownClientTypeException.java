package ru.andreyTw.delivery.service.clientType;

public class UnknownClientTypeException extends Throwable {
    public UnknownClientTypeException(String clientType) {
        super("Client type is not found: " + clientType);
    }
}