package com.Album.Music.services;

import com.Album.Music.dtos.ArtistDTO;
import com.Album.Music.entities.ArtistEntity;
import com.Album.Music.modelMappers.ArtistModelMapper;
import com.Album.Music.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistDTO createArtist(ArtistDTO dto) {
        ArtistEntity artist = ArtistModelMapper.toEntity(dto);
        ArtistEntity savedArtist = artistRepository.save(artist);
        return ArtistModelMapper.toDTO(savedArtist);
    }

    public List<ArtistDTO> getArtists() {
        List<ArtistEntity> artists = artistRepository.findAll();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (ArtistEntity artist : artists) {
            ArtistDTO dto = ArtistModelMapper.toDTO(artist);
            artistDTOS.add(dto);
        }
        return artistDTOS;
    }

    public void isExist(Long artistId) {
        boolean exist = artistRepository.existsById(artistId);
        if (!exist) {
            System.out.println("Artist Not Found");
        }
    }

    public ArtistDTO getArtistById(Long artistId) {
        isExist(artistId);

        ArtistEntity artist = artistRepository.findById(artistId).orElse(null);
        assert(artist != null);
        return ArtistModelMapper.toDTO(artist);
    }

    public Boolean deleteArtist(Long artistId) {
        isExist(artistId);
        artistRepository.deleteById(artistId);
        return true;
    }

}
