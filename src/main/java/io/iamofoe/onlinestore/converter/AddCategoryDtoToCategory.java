package io.iamofoe.onlinestore.converter;

import io.iamofoe.onlinestore.domain.model.Category;
import io.iamofoe.onlinestore.dto.request.AddCategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddCategoryDtoToCategory implements Converter<AddCategoryDto, Category> {
    @Override
    public Category convert(AddCategoryDto source) {
        return new Category()
                .setName(source.getName())
                .setStatus(source.getStatus());
    }
}
