package kiwi;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {

    public Movie findById(Integer id) throws SQLException {
        Movie movie = new Movie();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM movies WHERE id = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            movie.id = resultSet.getInt("id");
            movie.title = resultSet.getString("title");
            movie.duration = resultSet.getDouble("duration");
            movie.release_date = resultSet.getDate("release_date");
            movie.score = resultSet.getDouble("score");}

        //System.out.println(movie.toString());
        return movie;
    }

    public ArrayList<Movie> findByName(String name) throws SQLException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM movies WHERE title = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Movie movie = new Movie();
            movie.id = resultSet.getInt("id");
            movie.title = resultSet.getString("title");
            movie.duration = resultSet.getDouble("duration");
            movie.release_date = resultSet.getDate("release_date");
            movie.score = resultSet.getDouble("score");
            movies.add(movie);
        }

        //System.out.println(movies.toString());
        return movies;
    }

    public void createMovie(Movie movie) throws SQLException {
        Singleton singleton = new Singleton();

        singleton.con.setAutoCommit(false);
        PreparedStatement selectStatement = singleton.con.prepareStatement("INSERT INTO movies VALUES( " + " ?, ?, ?, ?, ?)");
        selectStatement.setInt(1, movie.id);
        selectStatement.setString(2, movie.title);
        selectStatement.setDate(3, (Date) movie.release_date);
        selectStatement.setDouble(4, movie.duration);
        selectStatement.setDouble(5,  movie.score);
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        singleton.con.commit();
        singleton.con.setAutoCommit(true);
        System.out.println("Movie " + movie.title + " successfully created!");
    }
}
