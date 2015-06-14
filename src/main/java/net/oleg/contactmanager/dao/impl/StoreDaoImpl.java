package net.oleg.contactmanager.dao.impl;

import net.alexandr.youtop.dao.StoreDao;
import net.alexandr.youtop.entity.Store;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * class {@code StoreDaoImpl} is implementation of StoreDao
 *
 * @author Alexandr
 */
@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Gets all store with all products
     *
     * @return List with stores
     */
    @Override
    public List<Store> getAll() {
        List<Store> stores = getSession().createQuery("from Store").list();
        for (Store store : stores) {
            Hibernate.initialize(store);
        }
        return stores;
    }

    /**
     * Saves store
     *
     * @param store Store with product
     */
    @Override
    public void save(Store store) {
        getSession().save(store);
    }

    /**
     * Gets store by id
     *
     * @param id Store id
     * @return Store
     */
    @Override
    public Store getById(int id) {
        Store store = (Store) getSession().createQuery("from Store where id = :id")
                .setParameter("id", id)
                .uniqueResult();
        Hibernate.initialize(store);
        return store;
    }

    /**
     * Deletes store
     *
     * @param store Store to delete
     */
    @Override
    public void delete(Store store) {
        Object persistentInstance = getSession().load(Store.class, store.getId());
        if (persistentInstance != null) {
            getSession().delete(persistentInstance);
        }

    }

    /**
     * Update store
     *
     * @param store Store to update
     */
    @Override
    public void update(Store store) {
        getSession().update(store);
    }

    /**
     * Gets store by name
     *
     * @param name Name of product at store
     * @return Store with product
     */
    @Override
    public Store getByName(String name) {
        Store store = (Store) getSession().createQuery("from Store where product.name = :name")
                .setParameter("name", name)
                .uniqueResult();
        Hibernate.initialize(store);
        return store;
    }

    /**
     * Set stores by country
     *
     * @param country country
     * @return List with store
     */
    @Override
    public List<Store> getByCountry(String country) {
        List<Store> stores = getSession().createQuery("from Store where product.country = :country")
                .setParameter("country", country).list();
        for (Store store : stores) {
            Hibernate.initialize(store);
        }
        return stores;
    }

    /**
     * Get store by category
     *
     * @param category Category
     * @return List with store
     */
    @Override
    public List<Store> getByCategory(String category) {
        List<Store> stores = getSession().createQuery("from Store where product.category = :category")
                .setParameter("category", category).list();
        for (Store store : stores) {
            Hibernate.initialize(store);
        }
        return stores;
    }

    /**
     * Get product by price range
     *
     * @param from price lower range
     * @param to   price upper range
     * @return List with stores
     */
    @Override
    public List<Store> getByPrice(BigDecimal from, BigDecimal to) {
        List<Store> stores = (List<Store>) getSession().createQuery("from Store where product.price>= :from and product.price<=:to")
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
        for (Store store : stores) {
            Hibernate.initialize(stores);
        }
        return stores;
    }

    /**
     * Gets store by amount
     *
     * @param from Amount lower range
     * @param to   Amount upper range
     * @return List with stores
     */
    @Override
    public List<Store> getByAmount(int from, int to) {
        List<Store> stores = (List<Store>) getSession().createQuery("from Store where amount>= :from and amount<=:to")
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
        for (Store store : stores) {
            Hibernate.initialize(stores);
        }
        return stores;
    }
}
