package io.iamofoe.onlinestore.dto.response;

import io.iamofoe.onlinestore.domain.model.Status;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CategoryResponse {
    UUID id;
    String name;
    Status status;
}
