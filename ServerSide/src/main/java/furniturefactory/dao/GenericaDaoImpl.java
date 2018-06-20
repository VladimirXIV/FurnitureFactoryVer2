package furniturefactory.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public abstract class GenericaDaoImpl<T>  implements GenericDao<T> {

    private Class<T> clazz;

    @Autowired
    @Qualifier(value = "entityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public void setClazz( Class<T> clazzToSet ) {
        this.clazz = clazzToSet;
    }

    // create
    @Override
    public T create(final T entity) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    // retrieve
    @Override
    public T findOne(long id) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        T result = entityManager.find(clazz, id);
        entityManager.close();
        return result;

    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        List<T> results = entityManager.createQuery("from " + clazz.getName()).getResultList();
        entityManager.close();
        return results;
    }

    // update
    @Override
    public T update(T entity) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        T result = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    // delete
    @Override
    public void deleteById(long entityId) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        T entity = findOne(entityId);
        delete(entity);
        entityManager.close();
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
