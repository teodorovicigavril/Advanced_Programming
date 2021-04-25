package factory;

import jdbc.GenreDAO;
import jpa.repo.AbstractRepository;
import jpa.repo.MovieRepository;

public class GenreFactory implements AbstractFactory {

    public AbstractRepository createRepository(String type) {
        if (type.equals("jdbc")) {
            return new GenreDAO();
        }
        else if (type.equals("jpa"))
            return new MovieRepository();
        else return null;
    }
}
