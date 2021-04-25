package app;

import factory.GenreFactory;
import jdbc.*;
import jpa.entity.GenresEntity;
import jpa.entity.MoviesEntity;
import jpa.repo.AbstractRepository;
import jpa.repo.GenreRepository;
import jpa.repo.MovieRepository;
import jpa.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static Singleton singleton;

    private static void init(String type) throws SQLException, ClassNotFoundException {
        if (type.equals("jdbc"))
            singleton = Singleton.getInstance();
    }

    public static Singleton getDatabase() {
        return singleton;
    }

    private static String getType() {
        String type = "";
        try {
            FileReader fileReader = new FileReader("file.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            type = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return type;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EntityManagerFactory entityManagerFactory = PersistenceUtil.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        MovieRepository movieRepository = new MovieRepository();
        GenreRepository genreRepository = new GenreRepository();

        // adding a movie to the database - jpa
        MoviesEntity movie = new MoviesEntity();
        movie.setId(3L);
        movie.setTitle("Tom Jerry");
        movie.setReleaseDate(null);
        movie.setDuration(1120L);
        movie.setScore((long) 9);
        movieRepository.create(movie);

        // adding a genre to database - jdbc
        String type=getType();
        init(type);

        GenreFactory genreFactory = new GenreFactory();
        AbstractRepository<GenresEntity> abstractRepository = genreFactory.createRepository(type);

        GenresEntity genresEntity = new GenresEntity();
        genresEntity.setId(1L);
        genresEntity.setName("Animation");

        abstractRepository.create(genresEntity);

        // finding a movie by id
        MoviesEntity moviesEntity = MovieRepository.findById(1);
        System.out.println(moviesEntity.toString());


        // finding genre by their titles
        List<MoviesEntity> moviesEntityList = MovieRepository.findByTitle("Tom Jerry");
        System.out.println(moviesEntityList.toString());

        //// finding a genre by id
        GenresEntity genresEntity1 = GenreRepository.findById(1);
        System.out.println(genresEntity1.toString());


        //// finding genres by their names
        List<GenresEntity> genresEntityList = GenreRepository.findByName("Animation");
        System.out.println(genresEntityList.toString());

        entityManager.close();
        entityManagerFactory.close();

    }
}
