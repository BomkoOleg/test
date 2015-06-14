package net.oleg.contactmanager.dao.impl;

import net.alexandr.youtop.dao.UserDao;
import net.alexandr.youtop.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * class {@code UserDaoImpl} is implementation of UserDao
 *
 * @author Alexandr
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Gets all users
     *
     * @return List with all users
     */
    @Override
    public List<User> getAll() {
        List<User> users = getSession().createQuery("from User").list();
        for (User user : users) {
            Hibernate.initialize(user);
        }
        return users;
    }

    /**
     * Saves user to database
     *
     * @param user User to save
     */
    @Override
    public void save(User user) {
        getSession().save(user);
    }

    /**
     * Deletes user from database
     *
     * @param user User to delete
     */
    @Override
    public void delete(User user) {
        Object persistentInstance = getSession().load(User.class, user.getId());
        if (persistentInstance != null) {
            getSession().delete(persistentInstance);
        }
    }

    /**
     * Update user at database
     *
     * @param user User to update
     */
    @Override
    public void update(User user) {
        getSession().update(user);
    }

    /**
     * Gets user by id
     *
     * @param id User is
     * @return User
     */
    @Override
    public User getById(int id) {
        User user = (User) getSession().load(User.class, id);
        Hibernate.initialize(user);
        return user;
    }

    /**
     * Gets user by phone number
     *
     * @param phoneNumber User phone number
     * @return List with users
     */
    @Override
    public List<User> getByPhoneNumber(String phoneNumber) {
        List<User> users = (List<User>) getSession().createQuery("from User where phoneNumber = :phoneNumber")
                .setParameter("phoneNumber", phoneNumber)
                .list();
        for (User user : users) {
            Hibernate.initialize(user);
        }
        return users;
    }

    /**
     * Gets user by username
     *
     * @param userName User username
     * @return User
     */
    @Override
    public User getByUserName(String userName) {
        User user = (User) getSession().createQuery("from User where username = :userName")
                .setParameter("userName", userName)
                .uniqueResult();
        Hibernate.initialize(user);
        return user;
    }
}
