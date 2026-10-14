package com.ramiz.spring_boot_security.Models;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{//implementing UserDetails makes this class provide user information in the format Spring Security expects.

    private Users user;


    public UserPrincipal(Users user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getUserpassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
}
