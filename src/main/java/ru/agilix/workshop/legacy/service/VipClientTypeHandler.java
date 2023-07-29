package ru.agilix.workshop.legacy.service;

import org.springframework.stereotype.Service;
import ru.agilix.workshop.legacy.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class VipClientTypeHandler {

    public Integer calculate(Integer cartAmount) {

        String sqlQuery = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
                "where t.id = c.type and t.type_name = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            DataSource d = OracleDataSource.create("admin", "p1ssword", "ORCL_PROD_DB1");
            connection = d.getConnection();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, "VIP");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int b = resultSet.getInt(0);
                int p = resultSet.getInt(1);

                return cartAmount >= b ? Double.valueOf(cartAmount * (1 - p / 100.0)).intValue() : cartAmount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException ignore) {
                //ignore.printStackTrace();
            }
        }

        return 0;
    }

}
