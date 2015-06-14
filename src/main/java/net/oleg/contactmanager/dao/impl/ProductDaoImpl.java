package net.oleg.contactmanager.dao.impl;


import net.oleg.contactmanager.dao.ProductDao;
import net.oleg.contactmanager.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/**
 * class {@code ProductDaoImpl} is implementation of ProductDao
 *
 * @author Alexandr
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Gets all products
     *
     * @return List with products
     */
    @Override
    public List<Product> getAll() {
        List<Product> products = (List<Product>) getSession().createQuery("from Product").list();
        for (Product product : products) {
            Hibernate.initialize(product);
        }
        return products;
    }

    /**
     * Saves product to data bse
     *
     * @param product Product to save
     */
    @Override
    public void save(Product product) {
        getSession().save(product);
    }

    /**
     * Deletes product from database
     *
     * @param product Product to delete
     */
    @Override
    public void delete(Product product) {
        Object persistentInstance = getSession().load(Product.class, product.getId());
        if (persistentInstance != null) {
            getSession().delete(persistentInstance);
        }
    }

    /**
     * Updates product at database
     *
     * @param product Product from database
     */
    @Override
    public void update(Product product) {
        getSession().update(product);
    }

    /**
     * Gets product by name
     *
     * @param name Product name
     * @return Product
     */
    @Override
    public Product getByName(String name) {
        Product product = (Product) getSession().createQuery("from Product where name = :name")
                .setParameter("name", name)
                .uniqueResult();
        Hibernate.initialize(product);
        return product;
    }

    /**
     * Gets products by country
     *
     * @param country Country
     * @return List with product from country
     */
    @Override
    public List<Product> getByCountry(String country) {
        List<Product> products = (List<Product>) getSession().createQuery("from Product where country = :country")
                .setParameter("country", country).list();
        for (Product product : products) {
            Hibernate.initialize(product);
        }
        return products;
    }

    /**
     * Gets products by category
     *
     * @param category Category
     * @return List with product from category
     */
    @Override
    public List<Product> getByCategory(String category) {
        List<Product> products = (List<Product>) getSession().createQuery("from Product where category  = :category")
                .setParameter("category", category).list();
        for (Product product : products) {
            Hibernate.initialize(product);
        }
        return products;
    }

    /**
     * Gets products by price range
     *
     * @param from Price lower range
     * @param to   Price upper range
     * @return List with products
     */
    @Override
    public List<Product> getByPrice(BigDecimal from, BigDecimal to) {
        List<Product> products = (List<Product>) getSession().createQuery("from Product where price>= :from and price<=:to")
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
        for (Product product : products) {
            Hibernate.initialize(product);
        }
        return products;
    }

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
    @Override
    public List<Product> getByCriteria(String name, String category, String country, BigDecimal priceFrom, BigDecimal priceTo) {
        Criteria criteria = getSession().createCriteria(Product.class);

        if (name != null) {
            criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        }
        if (category != null) {
            criteria.add(Restrictions.like("category", category, MatchMode.ANYWHERE));
        }

        if (country != null) {
            criteria.add(Restrictions.eq("country", country));
        }

        if (priceFrom != null && priceTo != null) {
            criteria.add(Restrictions.between("price", priceFrom, priceTo));
        } else {

            if (priceFrom != null) {
                BigDecimal maxPrice;
                Criteria maxCriteria = getSession().createCriteria(Product.class);
                maxCriteria.addOrder(Order.desc("price"));
                maxCriteria.setMaxResults(1);
                Product product = (Product) maxCriteria.uniqueResult();
                maxPrice = product.getPrice();
                criteria.add(Restrictions.between("price", priceFrom, maxPrice));
            }
            if (priceTo != null) {
                criteria.add(Restrictions.between("price", new BigDecimal("0.0"), priceTo));
            }
        }

        List<Product> products = criteria.list();
        return products;
    }
}
