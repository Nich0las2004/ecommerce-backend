package com.ecommerce.application.ecommerce_backend.category.controller;

import com.ecommerce.application.ecommerce_backend.category.Category;
import com.ecommerce.application.ecommerce_backend.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Category createCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }
}
