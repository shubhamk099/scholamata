package com.codeplay.scholamate.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.codeplay.scholamate.domain.entity.Person;

public class AppUserDetails implements UserDetails {

    private final Person savedPerson;

    public AppUserDetails(Person savedPerson) {
        this.savedPerson = savedPerson;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + savedPerson.getRole().getName()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return savedPerson.getPassword();
    }

    @Override
    public String getUsername() {
        return savedPerson.getEmail();
    }
}
