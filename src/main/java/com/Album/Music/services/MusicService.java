package com.Album.Music.services;

import com.Album.Music.dtos.musicDtos.ResponseMusicDTO;
import com.Album.Music.entities.MusicEntity;
import com.Album.Music.exceptions.ResourceNotFoundException;
import com.Album.Music.types.Genre;
import com.Album.Music.modelMappers.MusicModelMapper;
import com.Album.Music.repositories.ArtistRepository;
import com.Album.Music.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    @Autowired
    MusicModelMapper mapper;

    private final MusicRepository musicRepository;
    private final ArtistRepository artistRepository;

    public ResponseMusicDTO createMusic(ResponseMusicDTO inputMusic){
        MusicEntity music = mapper.toEntity(inputMusic);
        MusicEntity savedMusic = musicRepository.save(music);
        return MusicModelMapper.toDTO(savedMusic);
    }

    public List<ResponseMusicDTO> getAllMusic(){
        List<MusicEntity> musicEntities = musicRepository.findAll();
        List<ResponseMusicDTO> responseMusicDTOS = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities) {
            ResponseMusicDTO responseMusicDTO = MusicModelMapper.toDTO(musicEntity);
            responseMusicDTOS.add(responseMusicDTO);
        }
        return responseMusicDTOS;
    }

    public List<ResponseMusicDTO> getMusicByArtistId(Long artistId){
        List<MusicEntity> musicEntities = artistRepository.findByArtistId(artistId);
        List<ResponseMusicDTO> responseMusicDTOS = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities) {
            ResponseMusicDTO responseMusicDTO = MusicModelMapper.toDTO(musicEntity);
            responseMusicDTOS.add(responseMusicDTO);
        }
        return responseMusicDTOS;
    }

    public void isExist(Long musicId){
        boolean exist = musicRepository.existsById(musicId);
        if (!exist){
            throw new ResourceNotFoundException("Music not found with id: " + musicId);
        }
    }

    public ResponseMusicDTO getMusicById(Long musicId){
        isExist(musicId);

        MusicEntity musicEntity = musicRepository.findById(musicId).orElse(null);
        assert musicEntity != null;
        return MusicModelMapper.toDTO(musicEntity);
    }

    public void deleteMusicById(Long musicId){
        isExist(musicId);
        musicRepository.deleteById(musicId);
    }

    public List<ResponseMusicDTO> getMusicByGenre(Genre genre){
        List<MusicEntity> musicEntities = musicRepository.findByGenre(genre);
        List<ResponseMusicDTO> responseMusicDTOS = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities){
            ResponseMusicDTO responseMusicDTO = MusicModelMapper.toDTO(musicEntity);
            responseMusicDTOS.add(responseMusicDTO);
        }
        return responseMusicDTOS;
    }

}
