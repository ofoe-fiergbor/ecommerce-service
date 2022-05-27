package io.iamofoe.onlinestore.converter;

import io.iamofoe.onlinestore.domain.model.Category;
import io.iamofoe.onlinestore.dto.request.UpdateCategoryDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryDtoToCategory implements Converter<UpdateCategoryDto, Category> {
    @Override
    public Category convert(UpdateCategoryDto source) {
        return new Category()
                .setId(source.getId())
                .setName(source.getName())
                .setStatus(source.getStatus());
    }
}
