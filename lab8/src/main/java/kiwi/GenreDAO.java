package kiwi;


import kiwi.model.Genre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GenreDAO {

    public Genre findById(Integer id) throws SQLException {
        Genre genre = new Genre();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM genres WHERE id = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()) {
            genre.id = resultSet.getInt("id");
            genre.name = resultSet.getString("name");
        }

        //System.out.println(genre.toString());
        return genre;
    }

    public ArrayList<Genre> findByName(String name) throws SQLException {
        ArrayList<Genre> genres = new ArrayList<Genre>();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM genres WHERE name = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Genre genre = new Genre();
            genre.id = resultSet.getInt("id");
            genre.name = resultSet.getString("name");
            genres.add(genre);
        }

        //System.out.println(genres.toString());
        return genres;
    }

    public void createGenre(Genre genre) throws SQLException {
        Singleton singleton = new Singleton();

        singleton.con.setAutoCommit(false);
        PreparedStatement selectStatement = singleton.con.prepareStatement("INSERT INTO genres VALUES( " + " ?, ?)");
        selectStatement.setInt(1, genre.id);
        selectStatement.setString(2, genre.name);
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        singleton.con.commit();
        singleton.con.setAutoCommit(true);
        System.out.println("Genre " + genre.name + " successfully created!");
    }
}
