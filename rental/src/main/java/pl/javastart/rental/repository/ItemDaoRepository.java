package pl.javastart.rental.repository;

import pl.javastart.rental.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class ItemDaoRepository extends DaoRepository{

    public List<Item> getAllItemsAvailable () {

        EntityManager entityManager = startTransaction();

        TypedQuery<Item> item = entityManager.createQuery("SELECT item FROM Item item", Item.class);
        List<Item> list = item.getResultList();

        commitTransaction(entityManager);

        return list;



    }

}
