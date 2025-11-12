package com.Album.Music.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignUpDto {

    private String username;
    private String email;
    private String password;

}
