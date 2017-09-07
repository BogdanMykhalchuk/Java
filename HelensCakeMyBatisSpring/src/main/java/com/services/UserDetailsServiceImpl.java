package com.services;

import com.dao.UserDAO;
import com.models.SpringSecurityCustomUser;
import com.models.User;
import com.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dreawalker on 02.09.2017.
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        System.out.println(userLogin + " The login provided.");
        User user;
        try {
            user = userDAO.selectUserByUserName(userLogin);
            System.out.println(user.getName() + " User has been fetched.");
        } catch (UsernameNotFoundException u) {
            throw new UsernameNotFoundException("No such login registered: " + userLogin);
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new SpringSecurityCustomUser(user.getId(), userLogin, user.getPassword(),
                true, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(userLogin));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String login) {
        List<GrantedAuthority> authList = new ArrayList<>();
        UserRole userRole = userDAO.selectUserByUserName(login).getUserRole();
        SimpleGrantedAuthority sGA = new SimpleGrantedAuthority(userRole.name());
        authList.add(sGA);
        return authList;
    }

    public String getOTPPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        int min = 33;
        int max = 126;
        max -= min;

        for(int i = 0; i < 10; i++) {
            stringBuilder.append((char)((int) (Math.random() * ++max) + min));
        }

        return stringBuilder.toString();
    }
}
