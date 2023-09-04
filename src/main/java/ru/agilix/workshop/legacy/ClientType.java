package ru.agilix.workshop.legacy;

import ru.agilix.workshop.legacy.service.clientType.UnknownClientTypeException;

import java.util.Arrays;

public enum ClientType {

    COMMON("Обычный"),
    VIP("VIP"),
    FnF("Friends&Family");

    private String title;

    ClientType(String title) {
        this.title = title;
    }

    public static ClientType titleOf(String title) throws UnknownClientTypeException {
        return Arrays.stream(ClientType.values())
                .filter((ClientType clientType) -> clientType.title.equals(title))
                .findFirst()
                .orElseThrow(() -> new UnknownClientTypeException(title));
    }

    public String getTitle() {
        return title;
    }
}
