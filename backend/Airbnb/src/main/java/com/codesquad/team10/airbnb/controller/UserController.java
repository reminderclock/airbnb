package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.request.LogInDto;
import com.codesquad.team10.airbnb.dto.request.SignInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody SignInDto signInDto) {
        logger.debug(signInDto.toString());
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody LogInDto logInDto){
        logger.debug(logInDto.toString());
    }
}
