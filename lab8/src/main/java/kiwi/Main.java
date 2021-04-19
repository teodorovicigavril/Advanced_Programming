package kiwi;

import com.opencsv.CSVReader;
import kiwi.model.Actor;
import kiwi.model.Director;
import kiwi.model.Genre;
import kiwi.model.Movie;

import java.io.*;
import java.sql.*;



import static java.sql.Types.NULL;

public class Main {

    public static void main(String[] args) throws SQLException, FileNotFoundException {


        Singleton singleton = Singleton.getInstance();

        try {
            DirectorDAO directorDAO = new DirectorDAO();
            ActorDAO actorDAO = new ActorDAO();
            MovieDAO movieDAO = new MovieDAO();
            //movieDAO.findByName("friday13");
            GenreDAO genreDAO = new GenreDAO();
            //genreDAO.findById(1);
            //genreDAO.findByName("test=rock");

            Movie test = new Movie(NULL,"Deadpool 2", Date.valueOf("2015-03-31"), 134.0,7.7);
            movieDAO.createMovie(test);
           // Genre genre = new Genre(NULL,"SF");
           // genreDAO.createGenre(genre);

            try {

                // Create an object of filereader
                // class with CSV file as a parameter.
                FileReader filereader = new FileReader("C:\\Users\\40756\\Desktop\\gabii\\iasi\\ANUL 2\\sem 2\\ap\\lab8\\IMDb movies.csv");

                // create csvReader object passing
                // file reader as a parameter
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;

                int size=30;
                int index;
                // we are going to read data line by line
                while ((nextRecord = csvReader.readNext()) != null && size>0) {
                    index=0;
                    size--;
                    if(size != 29){
                        Movie movie = new Movie();
                        Genre genre = new Genre();
                        Actor actor = new Actor();
                        Director director = new Director();
                        for (String cell : nextRecord) {

                            if(index == 1) {
                                movie.setId(NULL);
                                movie.setTitle(cell);
                            }
                            if(index == 4)
                                movie.setRelease_date(Date.valueOf(cell));
                            if(index == 5) {
                                genre.setId(NULL);
                                genre.setName(cell);
                            }
                            if(index == 6){
                                movie.setDuration(Double.valueOf(cell));
                            }
                            if(index == 9){
                                director.setNume(cell);
                                director.setId_movie(movie.getId());
                            }
                            if(index == 12){
                                actor.setId_movie(movie.getId());
                                actor.setNume(cell);
                            }
                            if(index == 14){
                                movie.setScore(Double.valueOf(cell));
                            }

                            index++;

                        }

                        movieDAO.createMovie(movie);
                        genreDAO.createGenre(genre);
                        actor.setId_movie(movieDAO.findByName(movie.getTitle()).get(0).getId());
                        actorDAO.createActor(actor);
                        director.setId_movie(movieDAO.findByName(movie.getTitle()).get(0).getId());
                        directorDAO.createDirector(director);

                        System.out.println();
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }


    } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (singleton.con != null) singleton.con.close() ;
        }



    }
}
