package kiwi;


import kiwi.model.Actor;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorDAO {

    public Actor findByMovieId(Integer id) throws SQLException {
        Actor actor = new Actor();

        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("SELECT * FROM actors WHERE id_movie = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()) {
            actor.setId_movie(resultSet.getInt("id_movie"));
            actor.setNume(resultSet.getString("nume"));
        }

        return actor;
    }

    public ArrayList<Actor> findByName(String name) throws SQLException {
        ArrayList<Actor> actors = new ArrayList<Actor>();

        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("SELECT * FROM actors WHERE nume = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Actor actor = new Actor();
            actor.setId_movie(resultSet.getInt("id_movie"));
            actor.setNume(resultSet.getString("nume"));
            actors.add(actor);
        }

        return actors;
    }

    public void createActor(Actor actor) throws SQLException {

        Singleton.getInstance().con.setAutoCommit(false);
        PreparedStatement selectStatement = Singleton.getInstance().con.prepareStatement("INSERT INTO actors VALUES( " + " ?, ?)");
        selectStatement.setString(1, actor.getNume());
        selectStatement.setInt(2, actor.getId_movie());
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        Singleton.getInstance().con.commit();
        Singleton.getInstance().con.setAutoCommit(true);
        System.out.println("Actor " + actor.getNume() + " successfully created!");
    }
}
