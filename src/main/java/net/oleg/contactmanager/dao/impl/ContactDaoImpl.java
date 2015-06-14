package net.oleg.contactmanager.dao.impl;

import net.alexandr.youtop.dao.ContactDao;
import net.alexandr.youtop.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * class {@code ContactDaoImpl} is implementation of ContactDao
 *
 * @author Oleg
 */
@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Gets all contacts
     *
     * @return List with contacts
     */
    @Override
    public List<Contact> getContact() {
       List<Contact> contacts = (List<Contact>) getSession().createQuery("from Contact").list();
        return contacts;
    }

    @Override
    public Contact getContact(int id) {
        return null;
    }

    @Override
    public void saveContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(Contact contact) {

    }
}
