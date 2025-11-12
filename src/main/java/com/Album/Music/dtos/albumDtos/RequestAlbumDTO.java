package com.Album.Music.dtos.albumDtos;

import com.Album.Music.types.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestAlbumDTO {

    private String title;
    private Genre genre;
    private LocalDate releaseDate;

    private Long artistId;
    private List<Long> musicIds;
}
