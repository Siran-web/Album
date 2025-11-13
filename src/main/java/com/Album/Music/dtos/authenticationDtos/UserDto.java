package com.Album.Music.dtos.authenticationDtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private String password;

}
