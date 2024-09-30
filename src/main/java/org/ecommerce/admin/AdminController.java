package org.ecommerce.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
  private final AdminRepository adminRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  AdminController(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest admin) {
    try {
      Authentication authentication = new UsernamePasswordAuthenticationToken(
          admin.getUsername(), admin.getPassword()
      );

      Authentication result = authenticationManager.authenticate(authentication);

      return ResponseEntity.ok(new AuthResponse(result));
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Login failed: " + e.getMessage()));
    }
  }
  
}
