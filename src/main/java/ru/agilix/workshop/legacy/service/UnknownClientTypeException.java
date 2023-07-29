package ru.agilix.workshop.legacy.service;

public class UnknownClientTypeException extends Throwable {
    public UnknownClientTypeException(String clientType) {
        super("Client type is not found: " + clientType);
    }
}