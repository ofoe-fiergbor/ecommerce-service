package io.iamofoe.onlinestore.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserSignUpDto {
    String firstName;
    String lastName;
    String email;
    String password;
}
