package com.ecommerce.application.ecommerce_backend.category.repository;

import com.ecommerce.application.ecommerce_backend.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
