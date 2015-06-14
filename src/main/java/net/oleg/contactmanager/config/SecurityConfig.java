package net.oleg.contactmanager.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * class {@code SecurityConfig} sets configuration of the Spring security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * Sets UserDetailsService to configuration
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Configures access rights to URLs
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.csrf().disable();
        http.formLogin()
                .loginPage("/login#log")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/cart/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN' )")
                .and().formLogin().defaultSuccessUrl("/", false);
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);
        http.authorizeRequests()
                .antMatchers("/my").access("hasRole('ROLE_USER')")
                .and().formLogin().defaultSuccessUrl("/", false);


        http.authorizeRequests()
                .antMatchers("/checkout").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true);


    }
}