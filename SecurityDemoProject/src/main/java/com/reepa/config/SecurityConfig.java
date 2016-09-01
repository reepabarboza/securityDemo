package com.reepa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by reepa on 14-06-2016.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/posts/list").permitAll()
                .antMatchers("/admin*//**").hasRole("ADMIN")
                .anyRequest().authenticated()
        .and()
        .formLogin()
        .and()
        .logout();
    }*/


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/posts/list").permitAll()
                .antMatchers("/admin*/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("reepa")
                .password("password")
                .roles("USER")
                .and()
                .withUser("dan")
                .password("dan")
                .roles("ADMIN");

    }
}
