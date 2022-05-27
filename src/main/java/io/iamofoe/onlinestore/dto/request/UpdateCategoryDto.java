package io.iamofoe.onlinestore.dto.request;

import io.iamofoe.onlinestore.domain.model.Status;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class UpdateCategoryDto {
    UUID id;
    String name;
    Status status;
}
