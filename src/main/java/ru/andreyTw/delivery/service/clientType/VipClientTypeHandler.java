package ru.andreyTw.delivery.service.clientType;

import org.springframework.stereotype.Service;
import ru.andreyTw.delivery.ClientType;
import ru.andreyTw.delivery.DataSourceConnector;
import ru.andreyTw.delivery.OracleDataSourceConnector;

@Service
public class VipClientTypeHandler implements ClientTypeHandler {

    public Integer calculate(Integer cartAmount) {

        DataSourceConnector dataSourceConnector = new OracleDataSourceConnector();

        dataSourceConnector.openConnection();
        dataSourceConnector.prepareResultSet("VIP");
        int b = dataSourceConnector.getDataByIndex(0);
        int p = dataSourceConnector.getDataByIndex(1);
        dataSourceConnector.closeConnection();

        return cartAmount >= b ? Double.valueOf(cartAmount * (1 - p / 100.0)).intValue() : cartAmount;
    }

    @Override
    public ClientType getType() {
        return ClientType.VIP;
    }

}
