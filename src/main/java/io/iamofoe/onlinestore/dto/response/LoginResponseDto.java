package io.iamofoe.onlinestore.dto.response;

import io.iamofoe.onlinestore.domain.model.Role;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginResponseDto {
    String firstName;
    String lastName;
    String email;
    String pictureUrl;
    String token;
    Role role;
}
