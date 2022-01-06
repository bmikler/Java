package pl.javastart.rental;

import pl.javastart.rental.entity.Customer;
import pl.javastart.rental.entity.Item;
import pl.javastart.rental.repository.*;

import javax.persistence.EntityManager;
import java.util.List;


public class Main {
    public static void main(String[] args) {

//        CustomerDaoRepository repository = new CustomerDaoRepository();
//
//        Customer customer = repository.findById(Customer.class, 1L);
//        Item item = repository.findById(Item.class, 1L);
//
//        repository.borrowItem(customer, item);

        ItemDaoRepository repository = new ItemDaoRepository();

        for (Item item : repository.getAllItemsAvailable()) {
            System.out.println(item);
        }


    }



}
