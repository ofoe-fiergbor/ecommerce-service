package io.iamofoe.onlinestore.converter;

import io.iamofoe.onlinestore.domain.model.User;
import io.iamofoe.onlinestore.dto.response.LoginResponseDto;
import io.iamofoe.onlinestore.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserToLoginResponseDto implements Converter<User, LoginResponseDto> {
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponseDto convert(User user) {
        return LoginResponseDto.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .token(jwtUtil.createAccessToken(user.getEmail()))
                .pictureUrl(user.getPictureUrl())
                .build();
    }
}
