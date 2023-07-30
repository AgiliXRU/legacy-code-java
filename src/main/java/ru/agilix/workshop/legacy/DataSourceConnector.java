package ru.agilix.workshop.legacy;

public interface DataSourceConnector {

    void openConnection();

    void prepareResultSet(String clientType);

    int getDataByIndex(int index);

    void closeConnection();
}
