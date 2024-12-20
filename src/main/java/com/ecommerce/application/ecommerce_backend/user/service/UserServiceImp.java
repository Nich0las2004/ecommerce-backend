package com.ecommerce.application.ecommerce_backend.user.service;

import com.ecommerce.application.ecommerce_backend.user.User;
import com.ecommerce.application.ecommerce_backend.user.dto.UserLoginDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserProfileDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserRegistrationDTO;
import com.ecommerce.application.ecommerce_backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerNewUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        return userRepository.save(user);
    }

    public User loginUser(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByUsername(userLoginDTO.getUsername());
        if(user != null && user.getPassword().equals(userLoginDTO.getPassword())){
            return user;
        }
        return null;
    }

    public UserProfileDTO getUserProfile(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setId(user.getId());
        userProfile.setUsername(user.getUsername());
        userProfile.setEmail(user.getEmail());
        userProfile.setRole(user.getRole());

        return userProfile;
    }

}
