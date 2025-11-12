package com.Album.Music.services;

import com.Album.Music.dtos.LoginDto;
import com.Album.Music.dtos.SignUpDto;
import com.Album.Music.dtos.UserDto;
import com.Album.Music.entities.UserEntity;
import com.Album.Music.modelMappers.UserModelMapper;
import com.Album.Music.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserModelMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public UserDto signUp(SignUpDto signUp) {
        Optional<UserEntity> user = userRepository.findByEmail(signUp.getEmail());

        if(user.isPresent()){
            throw new BadCredentialsException("Username is already taken");
        }

        if (signUp.getPassword() == null || signUp.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        UserEntity toCreate = userMapper.toEntity(signUp);
        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));

        userRepository.save(toCreate);
        return userMapper.toDto(toCreate);
    }

}
