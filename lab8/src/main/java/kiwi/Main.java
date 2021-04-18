package kiwi;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.sql.Types.NULL;

public class Main {

    public static void main(String[] args) throws SQLException {


        Singleton singleton = Singleton.getInstance();

        try {
            MovieDAO movieDAO = new MovieDAO();
            //movieDAO.findByName("friday13");
            GenreDAO genreDAO = new GenreDAO();
            //genreDAO.findById(1);
            //genreDAO.findByName("test=rock");

            Movie test = new Movie(NULL,"Deadpool 2", Date.valueOf("2015-03-31"), 134.0,7.7);
            movieDAO.createMovie(test);
           // Genre genre = new Genre(NULL,"SF");
           // genreDAO.createGenre(genre);

        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (singleton.con != null) singleton.con.close() ;
        }



    }
}
