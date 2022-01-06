package pl.javastart.rental.repository;

import pl.javastart.rental.entity.Customer;
import pl.javastart.rental.entity.Item;

import javax.persistence.EntityManager;

public class CustomerDaoRepository extends DaoRepository{

    public void borrowItem(Customer customer, Item item) {


        if (item.getStockLevel() < 1)
            throw new IllegalStateException();

        EntityManager entityManager = startTransaction();

        item.setStockLevel(item.getStockLevel() - 1);
        item.borrowToCustomer(customer);

        customer.borrowItem(item);

        entityManager.merge(item);
        entityManager.merge(customer);

        commitTransaction(entityManager);


    }

}
