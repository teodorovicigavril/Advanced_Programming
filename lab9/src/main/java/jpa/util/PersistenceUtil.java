package jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory singleInstance;

    private PersistenceUtil() {
        singleInstance= Persistence.createEntityManagerFactory("database");
    }

    public static EntityManagerFactory getInstance() {
        if (singleInstance == null)
            new PersistenceUtil();
        return singleInstance;
    }
}