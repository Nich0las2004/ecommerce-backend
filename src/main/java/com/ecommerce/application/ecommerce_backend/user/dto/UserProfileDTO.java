package com.ecommerce.application.ecommerce_backend.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
}
