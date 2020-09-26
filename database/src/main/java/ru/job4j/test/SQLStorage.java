package ru.job4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class SQLStorage {
    private static final Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_course";
        String username = "postgres";
        String password = "kjtm4442";
        Connection conn = null;
        try {
           conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("SELECT * FROM car as c where c.id in (?, ?, ?)");
                st.setInt(1,1);
                st.setInt(2, 4);
                st.setInt(3, 6);
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                System.out.printf("%s, %s, %s, %s%n", rs.getString("name"),
                        rs.getInt("body_id"),
                        rs.getInt("engine_id"),
                        rs.getInt("transmission_id"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
