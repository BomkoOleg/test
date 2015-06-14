package net.oleg.contactmanager.dao.impl;

import net.alexandr.youtop.dao.PurchaseDao;
import net.alexandr.youtop.entity.Purchase;
import net.alexandr.youtop.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * class {@code PurchaseDaoImpl} is implementation of PurchaseDao
 *
 * @author Alexandr
 */
@Repository
@Transactional
public class PurchaseDaoImpl implements PurchaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Gets all purchases
     *
     * @return List with purchases
     */
    @Override
    public List<Purchase> getAll() {
        List<Purchase> purchases = getSession().createQuery("from Purchase").list();
        for (Purchase purchase : purchases) {
            Hibernate.initialize(purchase);
        }
        return purchases;
    }

    /**
     * Saver purchase to database
     *
     * @param purchase Purchase to save
     */
    @Override
    public void save(Purchase purchase) {
        getSession().save(purchase);
    }

    /**
     * Deletes purchase from database
     *
     * @param purchase Purchase to delete
     */
    @Override
    public void delete(Purchase purchase) {
        Object persistentInstance = getSession().load(Purchase.class, purchase.getId());
        if (persistentInstance != null) {
            getSession().delete(persistentInstance);
        }

    }

    /**
     * Updates purchase from database
     *
     * @param purchase Purchase to update
     */
    @Override
    public void update(Purchase purchase) {
        getSession().update(purchase);
    }

    /**
     * Get purchase by product name
     *
     * @param productName Product name
     * @return List with purchases
     */
    @Override
    public List<Purchase> getByProductName(String productName) {
        List<Purchase> purchases = (List<Purchase>) getSession().createQuery("from Purchase where product.name = :productName")
                .setParameter("productName", productName).list();
        for (Purchase purchase : purchases) {
            Hibernate.initialize(purchase);
        }
        return purchases;
    }

    /**
     * Get purchases by cost
     *
     * @param from Cost lower range
     * @param to   Cost upper range
     * @return List with purchases
     */
    @Override
    public List<Purchase> getByCost(BigDecimal from, BigDecimal to) {
        List<Purchase> purchases = (List<Purchase>) getSession().createQuery("from Purchase where cost >=:from and cost <=:to")
                .setParameter("from", from)
                .setParameter("to", to).list();
        for (Purchase purchase : purchases) {
            Hibernate.initialize(purchase);
        }
        return purchases;
    }

    /**
     * Gets purchases by user that buy
     *
     * @param user User that buy
     * @return List with purchases
     */
    @Override
    public List<Purchase> getByUser(User user) {
        List<Purchase> purchases = (List<Purchase>) getSession().createQuery("from Purchase where user.username = :name")
                .setParameter("name", user.getUsername()).list();
        for (Purchase purchase : purchases) {
            Hibernate.initialize(purchase);
        }
        return purchases;
    }
}
