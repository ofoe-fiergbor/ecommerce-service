package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.dto.request.AddCategoryDto;
import io.iamofoe.onlinestore.dto.request.UpdateCategoryDto;
import io.iamofoe.onlinestore.dto.response.CategoryResponse;

public interface CategoryService {
    CategoryResponse addCategory(AddCategoryDto dto);
    CategoryResponse updateCategory(UpdateCategoryDto dto);
}
