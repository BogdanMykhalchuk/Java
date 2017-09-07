package com.models;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class SpringSecurityCustomUser extends org.springframework.security.core.userdetails.User {

    private Integer id;

    public SpringSecurityCustomUser(Integer id, String username, String password, boolean enabled,
                                    boolean accountNonExpired, boolean credentialsNonExpired,
                                    boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
