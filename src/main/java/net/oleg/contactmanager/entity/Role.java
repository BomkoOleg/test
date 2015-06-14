package net.oleg.contactmanager.entity;


import javax.persistence.*;

/**
 * class {@code Role} represents user role
 */
@Entity
@Table(name = "roles")
public class Role {
    /**
     * Role id
     */
    @Id
    @Column(name = "role", unique = true)
    private String role;
    /**
     * User to set role
     */
    @OneToOne(mappedBy = "role", orphanRemoval = true)
    private User user;

    /**
     * Creates role object
     */
    public Role() {

    }

    /**
     * Initializes newly created role
     *
     * @param role User role
     */
    public Role(String role) {
        this.role = role;
    }

    /**
     * Gets role
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

}
