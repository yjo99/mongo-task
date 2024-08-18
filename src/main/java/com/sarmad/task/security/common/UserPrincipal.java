package com.sarmad.task.security.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sarmad.task.persistence.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private String id;
    private String loginID;
    @JsonIgnore
    private String password;


    public UserPrincipal(String id, String loginID, String password) {
        this.id = id;
        this.loginID = loginID;
        this.password = password;
    }

    public static UserPrincipal build(User user) {
        return new UserPrincipal(
                user.getUser_id(),
                user.getLoginID(),
                user.getPassword()
        );
    }

    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return loginID;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // You can change this based on your activation logic
    }
}
