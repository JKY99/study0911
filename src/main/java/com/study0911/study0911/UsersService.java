package com.study0911.study0911;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
  private final UsersRepository usersRepository;

  public String getUser(){
    return "user";
  }

}
