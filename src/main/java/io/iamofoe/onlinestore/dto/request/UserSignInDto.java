package io.iamofoe.onlinestore.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserSignInDto {
    String email;
    String password;
}
