package net.oleg.contactmanager.dao;


import net.oleg.contactmanager.entity.Contact;

import java.util.List;

/**
 * interface {@code ContactDao} represents operation with contact at database.
 *
 * @author Oleg
 */
public interface ContactDao {

    /**
     * Gets all contact with contact manager
     *
     * @return List with contacts
     */
    public List<Contact> getContact();

    /**
     * Gets contact by id
     *
     * @param id Contact id
     * @return contact
     */
    public Contact getContact(int id);

    /**
     * Saves contact
     *
     * @param contact
     */
    public void saveContact(Contact contact);

    /**
     * Updates contact at database
     *
     * @param contact Contact from database
     */

    public void updateContact(Contact contact);
    /**
     * Deletes contact
     *
     * @param contact Contact to delete
     */
    public void deleteContact(Contact contact);

}
