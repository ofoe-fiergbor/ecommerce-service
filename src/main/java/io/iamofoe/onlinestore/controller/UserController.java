package io.iamofoe.onlinestore.controller;

import io.iamofoe.onlinestore.dto.request.UserSignInDto;
import io.iamofoe.onlinestore.dto.request.UserSignUpDto;
import io.iamofoe.onlinestore.dto.response.LoginResponseDto;
import io.iamofoe.onlinestore.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> registerNewUser(@RequestBody UserSignUpDto dto) {
        authenticationService.signUp(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody UserSignInDto dto) {
        return new ResponseEntity<>(authenticationService.signIn(dto), HttpStatus.OK);
    }
}
