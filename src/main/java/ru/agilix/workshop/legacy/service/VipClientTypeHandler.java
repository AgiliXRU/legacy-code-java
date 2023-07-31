package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.DataSourceConnector;
import ru.agilix.workshop.legacy.OracleDataSourceConnector;

@Service
public class VipClientTypeHandler implements ClientTypeHandler{

    public Integer calculate(Integer cartAmount) {

        DataSourceConnector dataSourceConnector = new OracleDataSourceConnector();

        dataSourceConnector.openConnection();
        dataSourceConnector.prepareResultSet("VIP");
        int b = dataSourceConnector.getDataByIndex(0);
        int p = dataSourceConnector.getDataByIndex(1);
        dataSourceConnector.closeConnection();

        return cartAmount >= b ? Double.valueOf(cartAmount * (1 - p / 100.0)).intValue() : cartAmount;
    }

}
