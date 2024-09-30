package org.ecommerce.security;

import org.ecommerce.admin.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
  private final Admin admin;

  public CustomUserDetails(Admin admin) {
    this.admin = admin;
  }

  public Admin getUser() {
    return admin;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority roleAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");

    return List.of(roleAuthority);
  }

  @Override
  public String getPassword() {
    return admin.getPassword();
  }

  @Override
  public String getUsername() {
    return admin.getUsername();
  }
}