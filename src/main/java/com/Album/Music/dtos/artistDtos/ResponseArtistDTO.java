package com.Album.Music.dtos.artistDtos;

import com.Album.Music.dtos.musicDtos.SummaryMusicDTO;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
public class ResponseArtistDTO {

    private Long id;
    private String artistName;
    private String nationality;

    private List<SummaryMusicDTO> musics;
}
