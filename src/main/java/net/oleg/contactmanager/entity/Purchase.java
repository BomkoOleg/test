package net.oleg.contactmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * class {@code Purchase} represents purchase that contains information about product and user
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    /**
     * Product id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * User that buy product
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;
    /**
     * Product that purchases
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Product product;

    /**
     * Cost of purchase
     */
    @Column(name = "cost")
    private BigDecimal cost;

    /**
     * Creates Product object
     */
    public Purchase() {
    }

    /**
     * Initializes newly created object
     *
     * @param product Product
     * @param cost    Purchase cost
     * @param user    User that buy
     */
    public Purchase(Product product, BigDecimal cost, User user) {
        this.product = product;
        this.cost = cost;
        this.user = user;
    }

    /**
     * Gets purchase id
     *
     * @return purchase id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets purchase id
     *
     * @param id purchase id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user that buys
     *
     * @return User that buys
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user that buys
     *
     * @param user User that buys
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets product that in purchase
     *
     * @return Product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product to purchase
     *
     * @param product Product to purchase
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Sets cost of purchase
     */
    public void setCost() {
        this.cost = product.getPrice();
    }

    /**
     * Gets cost of purchase
     * @return Cost of purchase
     */
    public BigDecimal getCost() {
        return cost;
    }
}
