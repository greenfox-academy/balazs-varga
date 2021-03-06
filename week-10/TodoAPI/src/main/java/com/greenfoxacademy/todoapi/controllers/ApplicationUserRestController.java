package com.greenfoxacademy.todoapi.controllers;

import com.greenfoxacademy.todoapi.models.ApplicationUser;
import com.greenfoxacademy.todoapi.models.JsonResponse;
import com.greenfoxacademy.todoapi.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationUserRestController {

  @Autowired
  ApplicationUserRepository applicationUserRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping(value = {"/sign_up"})
  public ResponseEntity register(@RequestBody(required = true) ApplicationUser newApplicationUser) {
    if (newApplicationUser != null) {
      newApplicationUser.setPassword(passwordEncoder.encode(newApplicationUser.getPassword()));
      applicationUserRepository.save(newApplicationUser);
      return new ResponseEntity(new JsonResponse("User is registered"), HttpStatus.OK);
    }
    else {
      return new ResponseEntity(new JsonResponse("Error"), HttpStatus.UNAUTHORIZED);
    }
  }

  @PostMapping(value = {"/login"})
  public ResponseEntity login(@RequestBody(required = true) ApplicationUser applicationUser) {
    if (applicationUser != null) {
      return new ResponseEntity(new JsonResponse("Successfully logged in"), HttpStatus.OK);
    }
    else {
      return new ResponseEntity(new JsonResponse("Error"), HttpStatus.UNAUTHORIZED);
    }
  }
}
