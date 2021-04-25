package factory;

import jpa.repo.AbstractRepository;

public interface AbstractFactory {
    public AbstractRepository createRepository(String type);
}
