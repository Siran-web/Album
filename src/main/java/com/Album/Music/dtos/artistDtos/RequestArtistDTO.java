package com.Album.Music.dtos.artistDtos;

import com.Album.Music.dtos.musicDtos.SummaryMusicDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestArtistDTO {

    private String artistName;
    private String nationality;

    private List<Long> musicIds;

}
