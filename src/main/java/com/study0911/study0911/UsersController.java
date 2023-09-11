package com.study0911.study0911;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/user","/user"})
public class UsersController {

  private final UsersService usersService;

  @GetMapping
  public ResponseEntity<String> getUsers(){
    String user = usersService.getUser();

    return ResponseEntity.status(HttpStatus.OK).body("hello" + user);
  }

}
