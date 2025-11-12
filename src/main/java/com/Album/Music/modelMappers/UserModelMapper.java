package com.Album.Music.modelMappers;

import com.Album.Music.dtos.authenticationDtos.SignUpDto;
import com.Album.Music.dtos.authenticationDtos.UserDto;
import com.Album.Music.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {

    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();

        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setPassword(entity.getPassword());

        return dto;

    }

    public UserEntity toEntity(SignUpDto dto) {
        UserEntity entity = new UserEntity();

        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setId(entity.getId());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
