package ru.andreyTw.delivery;

public interface DataSourceConnector {

    void openConnection();

    void prepareResultSet(String clientType);

    int getDataByIndex(int index);

    void closeConnection();
}
