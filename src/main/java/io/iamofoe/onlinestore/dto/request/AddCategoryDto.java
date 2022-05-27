package io.iamofoe.onlinestore.dto.request;

import io.iamofoe.onlinestore.domain.model.Status;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddCategoryDto {
    String name;
    Status status;
}
