package jpa.repo;

import jpa.entity.MoviesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository extends AbstractRepository<MoviesEntity> {
    public MovieRepository() {
        super();
    }

    public static MoviesEntity findById(long id) {
        MoviesEntity moviesEntity = entityManager.find(MoviesEntity.class, id);
        return moviesEntity;
    }

    public static List<MoviesEntity> findByTitle(String title) {
        List<MoviesEntity> movies = (List<MoviesEntity>) entityManager.createNamedQuery("movies.findByName").setParameter("inputtitle", title).getResultList();
        return movies;
    }

}