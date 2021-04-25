package jdbc.model;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {
    private static Database single_instance = null;
    Connection con = null;

    private Database() throws SQLException, ClassNotFoundException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            this.con = DriverManager.getConnection(
                    url, "STUDENT", "STUDENT");
//            System.out.println("Connected to Database!");
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }

    public static Database getInstance() throws SQLException, ClassNotFoundException {
        if (single_instance == null)
            single_instance = new Database();
        return single_instance;
    }
}
