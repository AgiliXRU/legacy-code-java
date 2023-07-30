package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.DataSourceConnector;
import ru.agilix.workshop.legacy.OracleDataSourceConnector;

@Service
public class FnFClientTypeHandler {

    public Integer calculate(Integer cartAmount) {

        DataSourceConnector dataSourceConnector = new OracleDataSourceConnector();

        dataSourceConnector.openConnection();
        dataSourceConnector.prepareResultSet("Friends&Family");
        int p = dataSourceConnector.getDataByIndex(2);
        dataSourceConnector.closeConnection();

        return Double.valueOf(cartAmount * (1 - p / 100.0)).intValue();
    }
}
