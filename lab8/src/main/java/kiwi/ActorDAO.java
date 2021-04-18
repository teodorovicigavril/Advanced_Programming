package kiwi;


import kiwi.model.Actor;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActorDAO {

    public Actor findByMovieId(Integer id) throws SQLException {
        Actor actor = new Actor();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM actors WHERE id_movie = ?");
        selectStatement.setInt(1,id);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()) {
            actor.id_movie = resultSet.getInt("id_movie");
            actor.nume = resultSet.getString("nume");
        }

        return actor;
    }

    public ArrayList<Actor> findByName(String name) throws SQLException {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Singleton singleton = new Singleton();

        PreparedStatement selectStatement = singleton.con.prepareStatement("SELECT * FROM actors WHERE nume = ?");
        selectStatement.setString(1,name);
        ResultSet resultSet = selectStatement.executeQuery();

        while(resultSet.next()){
            Actor actor = new Actor();
            actor.id_movie = resultSet.getInt("id");
            actor.nume = resultSet.getString("nume");
            actors.add(actor);
        }

        return actors;
    }

    public void createActor(Actor actor) throws SQLException {
        Singleton singleton = new Singleton();

        singleton.con.setAutoCommit(false);
        PreparedStatement selectStatement = singleton.con.prepareStatement("INSERT INTO actors VALUES( " + " ?, ?)");
        selectStatement.setString(1, actor.nume);
        selectStatement.setInt(2, actor.id_movie);
        selectStatement.addBatch();

        int[] updateCounts = selectStatement.executeBatch();
        singleton.con.commit();
        singleton.con.setAutoCommit(true);
        System.out.println("Actor " + actor.nume + " successfully created!");
    }
}
