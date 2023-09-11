package com.study0911.study0911;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

  /**
   * @return
   */
  public SecurityFilterChain filterChain(HttpSecurity http, final AuthenticationConfiguration authenticationConfiguration) throws Exception{
    http
      .csrf(c->c.disable())
      .cors(c->c.disable())
      ;
    return http.build();
  }

}
