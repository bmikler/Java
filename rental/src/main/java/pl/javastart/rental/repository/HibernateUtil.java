package pl.javastart.rental.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("myDatabase");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void shutDown() {

        factory.close();

    }

}

