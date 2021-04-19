package kiwi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Singleton
{
    private static Singleton connection = null;

    Connection con;

    private Singleton() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
    }

    public static Singleton getInstance() throws SQLException {
        if (connection == null)
            connection = new Singleton();

        return connection;
    }
}