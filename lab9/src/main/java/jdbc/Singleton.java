package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Singleton
{
    private static Singleton connection = null;

    Connection con;

    private Singleton() throws SQLException {
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "STUDENT");
    }

    public static Singleton getInstance() throws SQLException {
        if (connection == null)
            connection = new Singleton();

        return connection;
    }
}