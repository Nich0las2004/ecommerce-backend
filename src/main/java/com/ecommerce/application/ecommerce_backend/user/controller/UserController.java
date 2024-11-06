package com.ecommerce.application.ecommerce_backend.user.controller;

import com.ecommerce.application.ecommerce_backend.user.User;
import com.ecommerce.application.ecommerce_backend.user.dto.UserLoginDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserProfileDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserRegistrationDTO;
import com.ecommerce.application.ecommerce_backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerNewUser(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
        userRegistrationDTO.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        User registeredUser = userService.registerNewUser(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody @Valid UserLoginDTO userLoginDTO) {
        User loggedInUser = userService.loginUser(userLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(loggedInUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable String username) {
        UserProfileDTO userProfile = userService.getUserProfile(username);
        return ResponseEntity.status(HttpStatus.OK).body(userProfile);
    }
}
