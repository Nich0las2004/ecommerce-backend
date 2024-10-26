package com.ecommerce.application.ecommerce_backend.product.repository;

import com.ecommerce.application.ecommerce_backend.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
