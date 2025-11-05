package com.Album.Music.dtos;

import com.Album.Music.types.Genre;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class MusicDTO {

    private Long musicId;
    private String title;
    private Genre genre;
    private LocalDate releaseDate;

    private Long artistId;
}
