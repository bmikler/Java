package pl.javastart.rental.repository;

import pl.javastart.rental.entity.Customer;

import javax.persistence.EntityManager;

public class HibernateRepository {

    public void save(Customer customer) {

        EntityManager manager = HibernateUtil.getEntityManager();

        manager.getTransaction().begin();
        manager.persist(customer);
        manager.getTransaction().commit();

        manager.close();
        HibernateUtil.shutDown();

    }


}


