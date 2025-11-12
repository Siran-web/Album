package com.Album.Music.modelMappers;

import com.Album.Music.dtos.musicDtos.ResponseMusicDTO;
import com.Album.Music.entities.ArtistEntity;
import com.Album.Music.entities.MusicEntity;
import com.Album.Music.repositories.ArtistRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MusicModelMapper {

    private final ArtistRepository repository;

    public MusicModelMapper(ArtistRepository repository) {
        this.repository = repository;
    }

    public MusicEntity toEntity(ResponseMusicDTO dto){
        MusicEntity entity = new MusicEntity();

        Optional<ArtistEntity> artist = repository.findById(dto.getArtistId());

        entity.setMusicId(dto.getMusicId());
        entity.setTitle(dto.getTitle());
        entity.setGenre(dto.getGenre());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setArtist(artist.get());

        return entity;
    }

    public static ResponseMusicDTO toDTO(MusicEntity entity){
        ResponseMusicDTO dto = new ResponseMusicDTO();

        dto.setMusicId(entity.getMusicId());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setReleaseDate(entity.getReleaseDate());

        if(entity.getArtist() != null){
            dto.setArtistId(entity.getArtist().getArtistId());
        }

        return dto;
    }
}
