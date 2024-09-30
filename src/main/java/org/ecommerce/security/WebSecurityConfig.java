package org.ecommerce.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Autowired
  AuthenticationProviderService authenticationProvider;

  @Bean
  SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(c-> {
      c.disable();
    })
        .cors(cors -> cors.configurationSource(corsConfigurationSource()))
        .authorizeHttpRequests(r -> {r
          .requestMatchers("/order/**", "/product/**", "/admin/login").permitAll()
          //.requestMatchers("/admin/**").hasRole("ADMIN")
          .requestMatchers("/order/list", "/product/update-status").permitAll()
          .anyRequest().authenticated();
        })
        .authenticationProvider(authenticationProvider);
        

    return http.build();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("http://localhost:3000/"));
    configuration.setAllowedMethods(Arrays.asList("*"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
  }


  @Bean
  UserDetailsService UserDetailsService() {
    return new CustomUserDetailsService();
  }
}