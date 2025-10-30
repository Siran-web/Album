package com.Album.Music.services;

import com.Album.Music.dtos.MusicDTO;
import com.Album.Music.entities.MusicEntity;
import com.Album.Music.modelMappers.MusicModelMapper;
import com.Album.Music.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicDTO createMusic(MusicDTO inputMusic){
        MusicEntity music = MusicModelMapper.toEntity(inputMusic);
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

    public void isExist(Long musicId){
        boolean exist = musicRepository.existsById(musicId);
        if (!exist){
            System.out.println("Music not found");
        }
    }

    public MusicDTO getMusicById(Long musicId){
        isExist(musicId);

        MusicEntity musicEntity = musicRepository.findById(musicId).orElse(null);
        assert musicEntity != null;
        return MusicModelMapper.toDTO(musicEntity);
    }

    public Boolean deleteMusicById(Long musicId){
        isExist(musicId);
        musicRepository.deleteById(musicId);
        return true;
    }

}
