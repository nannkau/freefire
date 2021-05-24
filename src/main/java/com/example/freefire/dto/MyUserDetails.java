package com.example.freefire.dto;

import com.example.freefire.entity.Role;
import com.example.freefire.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private Boolean active;
    private List<GrantedAuthority> grantedAuthorities;
    public MyUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isFlagDelete()?false:true;
        List<GrantedAuthority> list= new ArrayList<>();
        for (Role r :user.getRoles()){
            SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(r.getName());
            list.add(simpleGrantedAuthority);
        }
        this.grantedAuthorities=list;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
