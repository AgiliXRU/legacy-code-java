package ru.agilix.workshop.legacy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OracleDataSource {

    public static DataSource create(String user, String password, String instance) throws SQLException {
        final var ds = mock(javax.sql.DataSource.class);
        final var connection = mock(Connection.class);
        final var preparedStatement = mock(PreparedStatement.class);
        final var resultSet = mock(ResultSet.class);

        when(ds.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt(0)).thenReturn(2500);
        when(resultSet.getInt(1)).thenReturn(5);
        when(resultSet.getInt(2)).thenReturn(2);

        return ds;
    }
}
