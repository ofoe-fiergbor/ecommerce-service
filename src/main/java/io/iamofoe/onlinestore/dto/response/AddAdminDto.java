package io.iamofoe.onlinestore.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class AddAdminDto {
    UUID id;
    String email;
    Date lastUpdated;
}
