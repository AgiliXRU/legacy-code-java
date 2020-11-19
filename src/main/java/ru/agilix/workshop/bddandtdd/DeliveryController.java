package ru.agilix.workshop.bddandtdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class DeliveryController {

    @GetMapping("/delivery/{clientType}/{cartAmount}/")
    public Integer calculate(@PathVariable("clientType") String t,
                             @PathVariable("cartAmount") Integer am) {

        String sql = "";

        if (t.equals("VIP")) {
            /**
             * TODO
             * Перенести в общую таблицу
             * @see TM-311
             */
            sql = "SELECT c.discount_amount, c.discount_percent FROM config_table c, client_type t " +
                    "where t.id = c.type and t.type_name = ?";

            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                DataSource d = OracleDataSource.create("admin", "p1ssword", "ORCL_PROD_DB1");
                conn = d.getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, t);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int b = rs.getInt(0);
                    int p = rs.getInt(1);
                    if (am >= b) {
                        return Double.valueOf(am * (1 - p / 100.0)).intValue();
                    } else {
                        return am;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ignore) {
                    //ignore.printStackTrace();
                }
            }

        } else if (t.equals("Обычный")) {
            if (am >= 1000) {
                return am;
            } else {
                return am + 250;
            }
        } else {
            try {
                throw new Exception("Client is not found" + t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
