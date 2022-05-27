package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.converter.AddCategoryDtoToCategory;
import io.iamofoe.onlinestore.converter.CategoryToCategoryResponse;
import io.iamofoe.onlinestore.converter.UpdateCategoryDtoToCategory;
import io.iamofoe.onlinestore.domain.model.Category;
import io.iamofoe.onlinestore.domain.repository.CategoryRepository;
import io.iamofoe.onlinestore.dto.request.AddCategoryDto;
import io.iamofoe.onlinestore.dto.request.UpdateCategoryDto;
import io.iamofoe.onlinestore.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryOperation implements CategoryService{
    private final CategoryRepository repository;
    private final AddCategoryDtoToCategory addCategoryDtoConverter;
    private final UpdateCategoryDtoToCategory updateCategoryConverter;
    private final CategoryToCategoryResponse categoryConverter;

    @Override
    public CategoryResponse addCategory(AddCategoryDto dto) {
        Category newCategory =  repository.save(Objects.requireNonNull(addCategoryDtoConverter.convert(dto)));
        return categoryConverter.convert(newCategory);
    }

    @Override
    public CategoryResponse updateCategory(UpdateCategoryDto dto) {
        Category category = repository.save(Objects.requireNonNull(updateCategoryConverter.convert(dto)));
        return categoryConverter.convert(category);
    }
}
