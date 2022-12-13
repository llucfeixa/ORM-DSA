package edu.upc.eetac.dsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactorySession {
    public FactorySession() {
    }

    public static Session openSession(String url, String user, String password) {
        Connection conn = getConnection(url, user, password);
        return new SessionImpl(conn);
    }

    private static Connection getConnection(String url, String user, String password) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException var5) {
            System.out.println("SQLException: " + var5.getMessage());
            System.out.println("SQLState: " + var5.getSQLState());
            System.out.println("VendorError: " + var5.getErrorCode());
        }

        return conn;
    }
}
