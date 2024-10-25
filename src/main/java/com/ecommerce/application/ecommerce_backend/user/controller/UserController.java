package com.ecommerce.application.ecommerce_backend.user.controller;

import com.ecommerce.application.ecommerce_backend.user.User;
import com.ecommerce.application.ecommerce_backend.user.dto.UserLoginDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserRegistrationDTO;
import com.ecommerce.application.ecommerce_backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
        User registeredUser = userService.registerNewUser(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        User loggedInUser = userService.loginUser(userLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);
    }
}
