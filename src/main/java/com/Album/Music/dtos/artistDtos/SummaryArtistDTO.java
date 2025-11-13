package com.Album.Music.dtos.artistDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryArtistDTO {

    private Long artistId;
    private String artistName;

}
