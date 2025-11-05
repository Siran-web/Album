package com.Album.Music.modelMappers;

import com.Album.Music.dtos.ArtistDTO;
import com.Album.Music.dtos.MusicDTO;
import com.Album.Music.entities.ArtistEntity;
import com.Album.Music.entities.MusicEntity;

public class ArtistModelMapper {

    public static ArtistEntity toEntity(ArtistDTO dto){
        ArtistEntity entity = ArtistEntity.builder().build();

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

        if(entity.getMusicEntities() != null){
            for (MusicEntity musicEntity : entity.getMusicEntities()) {
                MusicDTO musicDTO = new MusicDTO();
                musicDTO.setMusicId(musicEntity.getMusicId());
            }
        }

        return dto;
    }
}
