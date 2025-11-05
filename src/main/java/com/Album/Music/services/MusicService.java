package com.Album.Music.services;

import com.Album.Music.advice.GlobalExceptionHandler;
import com.Album.Music.dtos.MusicDTO;
import com.Album.Music.entities.ArtistEntity;
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

    public MusicDTO createMusic(MusicDTO inputMusic){
        MusicEntity music = mapper.toEntity(inputMusic);
        MusicEntity savedMusic = musicRepository.save(music);
        return MusicModelMapper.toDTO(savedMusic);
    }

    public List<MusicDTO> getAllMusic(){
        List<MusicEntity> musicEntities = musicRepository.findAll();
        List<MusicDTO> musicDTOs = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities) {
            MusicDTO musicDTO = MusicModelMapper.toDTO(musicEntity);
            musicDTOs.add(musicDTO);
        }
        return musicDTOs;
    }

    public List<MusicDTO> getMusicByArtistId(Long artistId){
        List<MusicEntity> musicEntities = artistRepository.findByArtistId(artistId);
        List<MusicDTO> musicDTOs = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities) {
            MusicDTO musicDTO = MusicModelMapper.toDTO(musicEntity);
            musicDTOs.add(musicDTO);
        }
        return musicDTOs;
    }

    public void isExist(Long musicId){
        boolean exist = musicRepository.existsById(musicId);
        if (!exist){
            throw new ResourceNotFoundException("Music not found with id: " + musicId);
        }
    }

    public MusicDTO getMusicById(Long musicId){
        isExist(musicId);

        MusicEntity musicEntity = musicRepository.findById(musicId).orElse(null);
        assert musicEntity != null;
        return MusicModelMapper.toDTO(musicEntity);
    }

    public void deleteMusicById(Long musicId){
        isExist(musicId);
        musicRepository.deleteById(musicId);
    }

    public List<MusicDTO> getMusicByGenre(Genre genre){
        List<MusicEntity> musicEntities = musicRepository.findByGenre(genre);
        List<MusicDTO> musicDTOs = new ArrayList<>();
        for (MusicEntity musicEntity : musicEntities){
            MusicDTO musicDTO = MusicModelMapper.toDTO(musicEntity);
            musicDTOs.add(musicDTO);
        }
        return musicDTOs;
    }

}
