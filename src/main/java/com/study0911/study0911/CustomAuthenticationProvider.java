package com.study0911.study0911;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

  private final CustomUserDetailService customUserDetailService;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    CustomUserDetail customUserDetail = (CustomUserDetail) customUserDetailService.loadUserByUsername(username);
    if(passwordEncoder.matches(password, customUserDetail.getPassword())){
      return new UsernamePasswordAuthenticationToken(username, password, customUserDetail.getAuthorities());
    }
    throw new BadCredentialsException("BadCredentialsException");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);p-[0;]
  }

}
