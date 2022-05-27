package io.iamofoe.onlinestore.converter;
import io.iamofoe.onlinestore.domain.model.Category;
import io.iamofoe.onlinestore.dto.response.CategoryResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryResponse implements Converter<Category, CategoryResponse> {
    @Override
    public CategoryResponse convert(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .status(category.getStatus())
                .build();
    }
}
