package net.oleg.contactmanager.dao;


import net.oleg.contactmanager.entity.Store;

import java.math.BigDecimal;
import java.util.List;


/**
 * interface {@code StoreDao} represents operation with store at database.
 *
 * @author Alexandr
 */
public interface StoreDao {
    /**
     * Gets all store with all products
     *
     * @return List with stores
     */
    List<Store> getAll();

    /**
     * Saves store
     *
     * @param store Store with product
     */
    void save(Store store);

    /**
     * Gets store by id
     *
     * @param id Store id
     * @return Store
     */
    Store getById(int id);

    /**
     * Deletes store
     *
     * @param store Store to delete
     */
    void delete(Store store);

    /**
     * Update store
     *
     * @param store Store to update
     */
    void update(Store store);

    /**
     * Gets store by name
     *
     * @param name Name of product at store
     * @return Store with product
     */
    Store getByName(String name);

    /**
     * Set stores by country
     *
     * @param country country
     * @return List with store
     */
    List<Store> getByCountry(String country);

    /**
     * Get store by category
     *
     * @param category Category
     * @return List with store
     */
    List<Store> getByCategory(String category);

    /**
     * Get product by price range
     *
     * @param from price lower range
     * @param to   price upper range
     * @return List with stores
     */
    List<Store> getByPrice(BigDecimal from, BigDecimal to);

    /**
     * Gets store by amount
     *
     * @param from Amount lower range
     * @param to   Amount upper range
     * @return List with stores
     */
    List<Store> getByAmount(int from, int to);
}
