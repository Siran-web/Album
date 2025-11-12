package com.Album.Music.controllers;

import com.Album.Music.dtos.LoginDto;
import com.Album.Music.dtos.SignUpDto;
import com.Album.Music.dtos.UserDto;
import com.Album.Music.services.LoginService;
import com.Album.Music.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> signup(@RequestBody SignUpDto signUp) {
        UserDto userDto = userService.signUp(signUp);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String token = loginService.login(loginDto);
        return ResponseEntity.ok(token);
    }
}