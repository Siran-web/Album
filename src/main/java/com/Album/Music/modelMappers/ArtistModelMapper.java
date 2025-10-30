package com.Album.Music.modelMappers;

import com.Album.Music.dtos.ArtistDTO;
import com.Album.Music.entities.ArtistEntity;

public class ArtistModelMapper {

    public static ArtistEntity toEntity(ArtistDTO dto){
        ArtistEntity entity = new ArtistEntity();

        entity.setArtistId(dto.getArtistId());
        entity.setArtistName(dto.getArtistName());
        entity.setNationality(dto.getNationality());

        return entity;
    }

    public static ArtistDTO toDTO(ArtistEntity entity){
        ArtistDTO dto = new ArtistDTO();

        dto.setArtistId(entity.getArtistId());
        dto.setArtistName(entity.getArtistName());
        dto.setNationality(entity.getNationality());

        return dto;
    }
}
