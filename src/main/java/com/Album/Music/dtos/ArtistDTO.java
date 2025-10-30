package com.Album.Music.dtos;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
public class ArtistDTO {

    private Long artistId;
    private String artistName;
    private String nationality;

    private List<MusicDTO> musicList;
}
