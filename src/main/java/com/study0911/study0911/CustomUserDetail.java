package com.study0911.study0911;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetail implements UserDetails{

  private final String username;
  private final String password;
  private final UsersRepository usersRepository;

  public CustomUserDetail(String username, String password, UsersRepository usersRepository) {
    this.username = username;
    this.password = password;
    this.usersRepository = usersRepository;

  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Users user = usersRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다."));


    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
  }

}
