package jdbc;

import jdbc.model.Director;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectorDAO {

    public Director findByMovieId(Integer id) throws SQLException {
        Director director = new Director();

        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("SELECT * FROM directors WHERE id = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            director.setNume(resultSet.getString("title"));
            director.setId_movie(resultSet.getInt("id_movie"));
        }

        return director;
    }

    public ArrayList<Director> findByName(String name) throws SQLException {
        ArrayList<Director> directors = new ArrayList<Director>();

        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("SELECT * FROM directors WHERE nume = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Director director = new Director();
            director.setNume(resultSet.getString("title"));
            director.setId_movie(resultSet.getInt("id_movie"));

            directors.add(director);
        }
        return directors;
    }

    public void createDirector(Director director) throws SQLException {

        Singleton.getInstance().con.setAutoCommit(false);
        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("INSERT INTO directors VALUES( " + " ?, ?)");
        selectStatement.setString(1, director.getNume());
        selectStatement.setInt(2, director.getId_movie());
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        Singleton.getInstance().con.commit();
        Singleton.getInstance().con.setAutoCommit(true);
        System.out.println("Director " + director.getNume() + " successfully created!");
    }
}
