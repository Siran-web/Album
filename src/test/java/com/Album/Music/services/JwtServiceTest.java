package com.Album.Music.services;

import com.Album.Music.entities.UserEntity;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtServiceTest {

    @Autowired
    private final JwtService jwtService = new JwtService();

    @Test
    public void testJwtTokenGeneration(){

        UserEntity userEntity = new UserEntity(4L , "siran@gmail.com" , "1234");

        String token = jwtService.generateJwtToken(userEntity);

        System.out.println(token);

        Long id = jwtService.getUserFromToken(token);

        System.out.println(id);

    }

}