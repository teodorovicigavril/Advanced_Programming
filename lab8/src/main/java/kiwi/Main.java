package kiwi;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        System.out.println("heii");
        String url = "jdbc:mysql://localhost/test" ;
        Connection con = null;
        try {
             con = DriverManager.getConnection(
                    url, "myUserName", "mySecretPassword");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (con != null) con.close() ;
        }
    }
}
