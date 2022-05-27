package io.iamofoe.onlinestore.controller;

import io.iamofoe.onlinestore.dto.request.AddCategoryDto;
import io.iamofoe.onlinestore.dto.request.UpdateCategoryDto;
import io.iamofoe.onlinestore.dto.response.CategoryResponse;
import io.iamofoe.onlinestore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class CategoryController {
    private final CategoryService categoryService;

    @Secured("ADMIN")
    @PostMapping
    public ResponseEntity<CategoryResponse> addNewCategory(AddCategoryDto route) {
        return new ResponseEntity<>(categoryService.addCategory(route), HttpStatus.CREATED);
    }
    @Secured("ADMIN")
    @PutMapping
    public ResponseEntity<CategoryResponse> updateExistingCategory(UpdateCategoryDto route) {
        return new ResponseEntity<>(categoryService.updateCategory(route), HttpStatus.CREATED);
    }


}
