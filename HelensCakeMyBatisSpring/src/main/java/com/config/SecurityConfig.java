package com.config;

import com.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Dreawalker on 29.08.2017.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/jsp/public/**").permitAll()
                .antMatchers("/jsp/user/**").hasRole("CLIENT")
                .and()
                .formLogin()
                .loginPage("/login").failureForwardUrl("/jsp/public/login.jsp?error=true").successForwardUrl("/")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/jsp/public/login.jsp?logout=true")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }
}
