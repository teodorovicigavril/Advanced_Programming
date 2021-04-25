package jpa.repo;

import jpa.entity.GenresEntity;

import java.util.List;

public class GenreRepository extends AbstractRepository<GenresEntity> {
    public GenreRepository() {
        super();
    }

    public static GenresEntity findById(long id) {
        GenresEntity genresEntity = entityManager.find(GenresEntity.class, id);
        return genresEntity;
    }

    public static List<GenresEntity> findByName(String name) {
        List<GenresEntity> genres = (List<GenresEntity>) entityManager.createNamedQuery("genres.findByName").setParameter("inputname", name).getResultList();
        return genres;
    }
}
