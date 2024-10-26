package com.ecommerce.application.ecommerce_backend.product.service;

import java.util.List;
import com.ecommerce.application.ecommerce_backend.product.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
