package com.Album.Music.dtos.musicDtos;

import com.Album.Music.types.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMusicDTO {

    private String title;
    private Genre genre;
    private LocalDate releaseDate;

    private Long artistId;

}
