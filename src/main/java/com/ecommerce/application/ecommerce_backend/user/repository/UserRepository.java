package com.ecommerce.application.ecommerce_backend.user.repository;

import com.ecommerce.application.ecommerce_backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
