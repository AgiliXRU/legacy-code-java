package ru.andreyTw.delivery;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDataSourceConnector implements DataSourceConnector{

    String sqlQuery = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
            "where t.id = c.type and t.type_name = ?";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void openConnection() {
        try {
            DataSource d = OracleDataSource.create("admin", "p1ssword", "ORCL_PROD_DB1");
            connection = d.getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareResultSet(String clientType) {
        try {
            preparedStatement.setString(1, clientType);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDataByIndex(int index) {
        try {
            if (resultSet.next()) {
                return resultSet.getInt(index);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public void closeConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
