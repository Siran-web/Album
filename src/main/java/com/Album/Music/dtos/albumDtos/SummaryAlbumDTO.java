package com.Album.Music.dtos.albumDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SummaryAlbumDTO {

    private Long id;
    private String title;

}
