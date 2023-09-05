package ru.andreyTw.delivery;

import org.junit.jupiter.api.Test;
import ru.andreyTw.delivery.service.clientType.UnknownClientTypeException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientTypeShould {

    @Test
    public void parseCorrectType() throws UnknownClientTypeException {
        assertNotNull(ClientType.titleOf("Обычный"));
    }

    @Test
    public void parseIncorrectType() {
        assertThrows(UnknownClientTypeException.class, () -> ClientType.titleOf("Неизвестный"));
    }
}