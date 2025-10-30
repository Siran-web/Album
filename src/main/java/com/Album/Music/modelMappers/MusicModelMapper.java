package com.Album.Music.modelMappers;

import com.Album.Music.dtos.MusicDTO;
import com.Album.Music.entities.MusicEntity;

public class MusicModelMapper {

    public static MusicEntity toEntity(MusicDTO dto){
        MusicEntity entity = new MusicEntity();

        entity.setMusicId(dto.getMusicId());
        entity.setTitle(dto.getTitle());
        entity.setReleaseDate(dto.getReleaseDate());

        return entity;
    }

    public static MusicDTO toDTO(MusicEntity entity){
        MusicDTO dto = new MusicDTO();

        dto.setMusicId(entity.getMusicId());
        dto.setTitle(entity.getTitle());
        dto.setReleaseDate(entity.getReleaseDate());

        return dto;
    }
}
