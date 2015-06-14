package net.oleg.contactmanager.entity;


import javax.persistence.*;
import java.math.BigDecimal;

/**
 * class {@code Product} represents product at shop
 */
@Entity
@Table(name = "products")
public class Product {

    /**
     * Product id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Product name
     */
    @Column(name = "name", unique = true)
    private String name;

    /**
     * Product description
     */
    @Column(name = "description")
    private String description;

    /**
     * Product country
     */
    @Column(name = "country")
    private String country;
    /**
     * Product category
     */
    @Column(name = "category")
    private String category;
    /**
     * Product price
     */
    @Column(name = "price")
    private BigDecimal price;

    /**
     * Product at store
     */
    @OneToOne(mappedBy = "product")
    private Store store;

    /**
     * Product image
     */
    @Column(name = "image")
    private String image;

    /**
     * Creates product object
     */
    public Product() {

    }

    /**
     * Gets product id
     *
     * @return product id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets product name
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets product description
     *
     * @return product description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets product country
     *
     * @return product country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets product price
     *
     * @return product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets product id
     *
     * @param id product id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets product name
     *
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets product description
     *
     * @param description product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets product country
     *
     * @param country product country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets product price
     *
     * @param price product price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets product category
     *
     * @return product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets product category
     *
     * @param category product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets product at store
     *
     * @return
     */
    public Store getStore() {
        return store;
    }

    /**
     * Sets product store
     *
     * @param store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets product image
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets product image
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Calculates and return product hash code based at id
     *
     * @return product hash code
     */
    @Override
    public int hashCode() {
        return this.getId();
    }

    /**
     * Equals products by hash code
     *
     * @param product Product object
     * @return result of equals
     */
    @Override
    public boolean equals(Object product) {
        Product productCheck = (Product) product;
        if (this.hashCode() == productCheck.hashCode()) {
            return true;
        }
        return false;
    }

}
