package org.ecommerce.admin;

import org.springframework.security.core.Authentication;

class AuthResponse {
  private String username;
  private String authorities;
  private String message;



  public AuthResponse(Authentication authToken) {
    this.username = authToken.getName();
    this.authorities = authToken.getAuthorities().toString();
    this.message = "Login successful";
  }

  public AuthResponse(String msg) {
    this.message = msg;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAuthorities() {
    return authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}