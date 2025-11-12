package com.Album.Music.services;

import com.Album.Music.dtos.authenticationDtos.LoginDto;
import com.Album.Music.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );
        UserEntity user = (UserEntity) authentication.getPrincipal();
        return jwtService.generateJwtToken(user);
    }

}
