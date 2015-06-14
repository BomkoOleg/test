package net.oleg.contactmanager.entity;

import javax.persistence.*;

/**
 * class {@code Store} represents store at shop
 */
@Entity
@Table(name = "store")
public class Store {
    /**
     * Store id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    /**
     * Product at store
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Amount of product
     */
    @Column(name = "amount")
    private int amount;

    /**
     * Creates Store object
     */
    public Store() {

    }

    /**
     * Initializes newly created object
     *
     * @param product Product at store
     * @param amount  Amount of products
     */
    public Store(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * Gets product at store
     *
     * @return Product at store
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product to store
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets amount of product at store
     *
     * @return Amount of product
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount of product at store
     *
     * @param amount Amount of products at store
     */
    public void setAmount(int amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = 0;
        }
    }

    /**
     * Gets store id
     *
     * @return Store id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets store id
     *
     * @param id Store id
     */
    public void setId(int id) {
        this.id = id;
    }
}
