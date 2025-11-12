package com.Album.Music.dtos.musicDtos;

import com.Album.Music.types.Genre;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseMusicDTO {

    private Long id;
    private String title;
    private Genre genre;
    private LocalDate releaseDate;

    private Long artistId;

}
