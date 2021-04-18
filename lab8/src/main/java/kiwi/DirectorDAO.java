package kiwi;

import kiwi.model.Director;
import kiwi.model.Movie;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectorDAO {

    public Director findByMovieId(Integer id) throws SQLException {
        Director director = new Director();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM directors WHERE id = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            director.nume = resultSet.getString("title");
            director.id_movie = resultSet.getInt("id");
        }

        return director;
    }

    public ArrayList<Director> findByName(String name) throws SQLException {
        ArrayList<Director> directors = new ArrayList<Director>();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM directors WHERE nume = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Director director = new Director();
            director.nume = resultSet.getString("nume");
            director.id_movie = resultSet.getInt("id_movie");

            directors.add(director);
        }
        return directors;
    }

    public void createDirector(Director director) throws SQLException {
        Singleton singleton = new Singleton();

        singleton.con.setAutoCommit(false);
        PreparedStatement selectStatement = singleton.con.prepareStatement("INSERT INTO directors VALUES( " + " ?, ?)");
        selectStatement.setString(1, director.nume);
        selectStatement.setInt(2, director.id_movie);
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        singleton.con.commit();
        singleton.con.setAutoCommit(true);
        System.out.println("Director " + director.nume + " successfully created!");
    }
}
