package net.oleg.contactmanager.dao;


import net.oleg.contactmanager.entity.Purchase;
import net.oleg.contactmanager.entity.User;

import java.math.BigDecimal;
import java.util.List;


/**
 * interface {@code PurchaseDao} represents operation with purchases at database.
 *
 * @author Alexandr
 */
public interface PurchaseDao {
    /**
     * Gets all purchases
     *
     * @return List with purchases
     */
    List<Purchase> getAll();

    /**
     * Saver purchase to database
     *
     * @param purchase Purchase to save
     */
    void save(Purchase purchase);

    /**
     * Deletes purchase from database
     *
     * @param purchase Purchase to delete
     */
    void delete(Purchase purchase);

    /**
     * Updates purchase from database
     *
     * @param purchase Purchase to update
     */
    void update(Purchase purchase);

    /**
     * Get purchase by product name
     *
     * @param productName Product name
     * @return List with purchases
     */
    List<Purchase> getByProductName(String productName);

    /**
     * Get purchases by cost
     *
     * @param from Cost lower range
     * @param to   Cost upper range
     * @return List with purchases
     */
    List<Purchase> getByCost(BigDecimal from, BigDecimal to);

    /**
     * Gets purchases by user that buy
     *
     * @param user User that buy
     * @return List with purchases
     */
    List<Purchase> getByUser(User user);

}
