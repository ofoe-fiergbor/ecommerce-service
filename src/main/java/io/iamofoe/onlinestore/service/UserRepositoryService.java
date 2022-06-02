package io.iamofoe.onlinestore.service;

import io.iamofoe.onlinestore.converter.UserToLoginResponseDto;
import io.iamofoe.onlinestore.domain.model.Role;
import io.iamofoe.onlinestore.domain.model.User;
import io.iamofoe.onlinestore.domain.repository.UserRepository;
import io.iamofoe.onlinestore.dto.request.UserSignInDto;
import io.iamofoe.onlinestore.dto.request.UserSignUpDto;
import io.iamofoe.onlinestore.dto.response.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserRepositoryService implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserToLoginResponseDto userToLoginResponseDtoConverter;


    @Override
    public void signUp(UserSignUpDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with email already exists");
        }
        userRepository.save(new User()
                .setEmail(dto.getEmail())
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setRole(Role.USER)
                .setPassword(passwordEncoder.encode(dto.getPassword())));
    }

    @Override
    public LoginResponseDto signIn(UserSignInDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with email: " + dto.getEmail() + " does not exist."));
        authenticateUser(dto);
        return userToLoginResponseDtoConverter.convert(user);
    }

    private void authenticateUser(UserSignInDto dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        authenticationManager.authenticate(authenticationToken);
    }


}
