package net.oleg.contactmanager.dao;


import net.oleg.contactmanager.entity.User;

import java.util.List;

/**
 * interface {@code UserDao} represents operation with users at database.
 *
 * @author Alexandr
 */
public interface UserDao {
    /**
     * Gets all users
     *
     * @return List with all users
     */
    List<User> getAll();

    /**
     * Saves user to database
     *
     * @param user User to save
     */
    void save(User user);

    /**
     * Deletes user from database
     *
     * @param user User to delete
     */
    void delete(User user);

    /**
     * Update user at database
     *
     * @param user User to update
     */
    void update(User user);

    /**
     * Gets user by id
     *
     * @param id User is
     * @return User
     */
    User getById(int id);

    /**
     * Gets user by phone number
     *
     * @param phoneNumber User phone number
     * @return List with users
     */
    List<User> getByPhoneNumber(String phoneNumber);

    /**
     * Gets user by username
     *
     * @param userName User username
     * @return User
     */
    User getByUserName(String userName);

}
