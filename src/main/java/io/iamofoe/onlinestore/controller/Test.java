package io.iamofoe.onlinestore.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/")
    public String hello() {
        System.err.println(SecurityContextHolder.getContext());
        return "Hello, !";
    }
}
