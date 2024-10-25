package com.ecommerce.application.ecommerce_backend.user.service;

import com.ecommerce.application.ecommerce_backend.user.User;
import com.ecommerce.application.ecommerce_backend.user.dto.UserLoginDTO;
import com.ecommerce.application.ecommerce_backend.user.dto.UserRegistrationDTO;

public interface UserService {
    User registerNewUser(UserRegistrationDTO userDTO);
    User loginUser(UserLoginDTO userLoginDTO);
//    User getUserProfile();
}
