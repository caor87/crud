package com.crud.crud.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * clase encargada de generar la seguridad
 */
public class PrincipalUser implements UserDetails {
    private String name;
    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String name, String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * Metodo estatico que asigna los privilegios a cada usuario, si es un admin o es otro usuario
     */

    public static PrincipalUser build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name()
        )).collect(Collectors.toList());

        return new PrincipalUser(user.getName(),user.getUserName(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
