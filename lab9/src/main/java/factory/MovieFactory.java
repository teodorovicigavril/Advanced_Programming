package factory;

import jdbc.MovieDAO;
import jpa.repo.AbstractRepository;
import jpa.repo.MovieRepository;

public class MovieFactory implements AbstractFactory{

    public AbstractRepository createRepository(String type) {
        if (type.equals("jdbc")) {
            return new MovieDAO();
        }
        else if (type.equals("jpa"))
            return new MovieRepository();
        else return null;
    }

}
