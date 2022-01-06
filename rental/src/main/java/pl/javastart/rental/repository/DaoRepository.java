package pl.javastart.rental.repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoRepository {

    public void save(Object object) {

        EntityManager entityManager = startTransaction();

        entityManager.persist(object);
        
        commitTransaction(entityManager);

    }

    public <T> List<T> getAll(Class<T> type) {

        EntityManager entityManager = startTransaction();

        String query = "SELECT entity from " + type.getSimpleName() + " entity";
        TypedQuery<T> entity = entityManager.createQuery(query, type);
        List<T> list = entity.getResultList();

        commitTransaction(entityManager);

        return list;


    }

    public <T> T findById(Class<T> type, long id){

        EntityManager entityManager = startTransaction();

        T entity = entityManager.find(type, id);

        entityManager.close();

        return entity;

    }

    public< T> void delete(Class<T> type, long id) {

        EntityManager entityManager = startTransaction();

        T entity = entityManager.find(type, id);

        entityManager.remove(entity);

        commitTransaction(entityManager);
        
        
    }

    
    protected EntityManager startTransaction() {

        EntityManager entityManager = HibernateUtil.getEntityManager();

        entityManager.getTransaction().begin();
        
        return entityManager;
        
    }
    
    protected void commitTransaction(EntityManager entityManager) {
        entityManager.getTransaction().commit();
        entityManager.close();
        
    }

}
