package net.oleg.contactmanager.entity;

import javax.persistence.*;

/**
 * class {@code Contact} represents contact at contact manager
 */
@Entity
@Table(name = "contact")
public class Contact {

    /**
     * Contact id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * Contact firstName
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Contact lastName
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Contact phone
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Contact email
     */
    @Column(name = "email")
    private String email;

    /**
     * Gets contact id
     *
     * @return contact id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets contact id
     *
     * @param id contact id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets contact firstName
     *
     * @return contact firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets contact firstName
     *
     * @param firstName contact firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets contact lastName
     *
     * @return contact lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets contact lastName
     *
     * @param lastName contact lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets contact phone
     *
     * @return contact phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets contact phone
     *
     * @param phone contact phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets contact email
     *
     * @return contact email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets contact email
     *
     * @param email contact email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
