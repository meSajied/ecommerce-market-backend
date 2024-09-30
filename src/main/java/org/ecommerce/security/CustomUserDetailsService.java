package org.ecommerce.security;

import org.ecommerce.admin.Admin;
import org.ecommerce.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired(required = false)
  private AdminRepository adminRepository;
  @Override
  public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Supplier<UsernameNotFoundException> supplier = () ->
        new UsernameNotFoundException("username not found");

    Admin u = adminRepository.findByUsername(username).orElseThrow(supplier);

    return new CustomUserDetails(u);
  }
}