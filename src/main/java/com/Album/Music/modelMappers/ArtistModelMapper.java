package com.Album.Music.modelMappers;

import com.Album.Music.dtos.artistDtos.ResponseArtistDTO;
import com.Album.Music.dtos.musicDtos.ResponseMusicDTO;
import com.Album.Music.entities.ArtistEntity;
import com.Album.Music.entities.MusicEntity;

public class ArtistModelMapper {

    public static ArtistEntity toEntity(ResponseArtistDTO dto){
        ArtistEntity entity = ArtistEntity.builder().build();

        entity.setArtistId(dto.getArtistId());
        entity.setArtistName(dto.getArtistName());
        entity.setNationality(dto.getNationality());

        return entity;
    }

    public static ResponseArtistDTO toDTO(ArtistEntity entity){
        ResponseArtistDTO dto = new ResponseArtistDTO();

        dto.setArtistId(entity.getArtistId());
        dto.setArtistName(entity.getArtistName());
        dto.setNationality(entity.getNationality());

        if(entity.getMusicEntities() != null){
            for (MusicEntity musicEntity : entity.getMusicEntities()) {
                ResponseMusicDTO responseMusicDTO = new ResponseMusicDTO();
                responseMusicDTO.setMusicId(musicEntity.getMusicId());
            }
        }

        return dto;
    }
}
