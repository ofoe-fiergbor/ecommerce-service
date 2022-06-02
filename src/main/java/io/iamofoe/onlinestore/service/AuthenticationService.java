package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.dto.request.UserSignInDto;
import io.iamofoe.onlinestore.dto.request.UserSignUpDto;
import io.iamofoe.onlinestore.dto.response.LoginResponseDto;

public interface AuthenticationService {
    void signUp(UserSignUpDto dto);
    LoginResponseDto signIn(UserSignInDto dto);
}
