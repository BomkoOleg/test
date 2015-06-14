package net.oleg.contactmanager.entity;



import javax.persistence.*;


/**
 * class {@code User} represents user at shop
 */
@Entity
@Table(name = "users")
public class User{
    /**
     * User id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * User username
     */
    @Column(name = "username", unique = true)
    private String username;

    /**
     * User password
     */
    @Column(name = "password")
    private String password;

    /**
     * User First name
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * User Last name
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * User phone number
     */
    @Column(name = "phoneNumber")
    private String phoneNumber;

    /**
     * User role at shop
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;

    /**
     * Creates User object
     */
    public User() {

    }

    /**
     * Initializes newly created object
     *
     * @param username    User username
     * @param password    User password
     * @param lastName    User Last name
     * @param firstName   User First name
     * @param phoneNumber User phone number
     * @param role        User role
     */
    public User(String username, String password, String lastName, String firstName, String phoneNumber, Role role) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    /**
     * Gets user role
     *
     * @return User role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets user role
     *
     * @param role User role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets User First name
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets user First name
     *
     * @param firstName User First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets user last name
     *
     * @return User last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets user Last name
     *
     * @param lastName User Last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user phone number
     *
     * @return User phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets user phone number
     *
     * @param phoneNumber User phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets user id
     *
     * @return User id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets user id
     *
     * @param id User id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets User username
     *
     * @return User username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets user password
     *
     * @return User password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets user password
     *
     * @param password User password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets user username
     *
     * @param username User username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns account status
     *
     * @return status
     */





}
