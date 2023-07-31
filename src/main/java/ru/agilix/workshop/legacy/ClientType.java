package ru.agilix.workshop.legacy;

public enum ClientType {

    ОБЫЧНЫЙ("Обычный"),
    VIP("VIP"),
    FnF("Friends&Family");

    private String title;

    private ClientType(String title) {
        this.title = title;
    }


}
