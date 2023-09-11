package com.study0911.study0911;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

  private final UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = usersRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다."));

    CustomUserDetail customUserDetail = new CustomUserDetail(user.getId(),user.getPassword(), usersRepository);

    return customUserDetail;
  }

}
