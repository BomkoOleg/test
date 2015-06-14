package net.oleg.contactmanager.dao;


import net.oleg.contactmanager.entity.Product;

import java.math.BigDecimal;
import java.util.List;


/**
 * interface {@code ProductDao} represents operation with product at database.
 *
 * @author Alexandr
 */
public interface ProductDao {
    /**
     * Gets all products
     *
     * @return List with products
     */
    List<Product> getAll();

    /**
     * Saves product to data bse
     *
     * @param product Product to save
     */
    void save(Product product);

    /**
     * Deletes product from database
     *
     * @param product Product to delete
     */
    void delete(Product product);

    /**
     * Updates product at database
     *
     * @param product Product from database
     */
    void update(Product product);

    /**
     * Gets product by name
     *
     * @param name Product name
     * @return Product
     */
    Product getByName(String name);

    /**
     * Gets products by country
     *
     * @param country Country
     * @return List with product from country
     */
    List<Product> getByCountry(String country);

    /**
     * Gets products by category
     *
     * @param category Category
     * @return List with product from category
     */
    List<Product> getByCategory(String category);

    /**
     * Gets products by price range
     *
     * @param from Price lower range
     * @param to   Price upper range
     * @return List with products
     */
    List<Product> getByPrice(BigDecimal from, BigDecimal to);

    /**
     * Gets products by criteria
     *
     * @param name      Product name
     * @param category  Product category
     * @param country   Product country
     * @param priceFrom Price lower range
     * @param priceTo   price upper range
     * @return List with products
     */
    List<Product> getByCriteria(String name, String category, String country, BigDecimal priceFrom, BigDecimal priceTo);

}
