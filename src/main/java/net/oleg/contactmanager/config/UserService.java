package net.oleg.contactmanager.config;

import net.alexandr.youtop.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * class {@code UserService} configures current user loading from application.
 */
@Component
public class UserService implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService() {

    }

    /**
     * Loads current user by username from database
     *
     * @param username User name
     * @return Current User
     * @throws UsernameNotFoundException if user is not found
     */
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Query query = sessionFactory.getCurrentSession().createQuery("from User where username=:username");
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        if (user == null) {
            throw new UsernameNotFoundException("User is not found");
        }
        logger.info("User " + user.getUsername() + " logged on");
        return user;

    }

}
