package com.Album.Music.services;

import com.Album.Music.dtos.artistDtos.ResponseArtistDTO;
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

    public ResponseArtistDTO createArtist(ResponseArtistDTO dto) {
        ArtistEntity artist = ArtistModelMapper.toEntity(dto);
        ArtistEntity savedArtist = artistRepository.save(artist);
        return ArtistModelMapper.toDTO(savedArtist);
    }

    public List<ResponseArtistDTO> getArtists() {
        List<ArtistEntity> artists = artistRepository.findAll();
        List<ResponseArtistDTO> responseArtistDTOS = new ArrayList<>();
        for (ArtistEntity artist : artists) {
            ResponseArtistDTO dto = ArtistModelMapper.toDTO(artist);
            responseArtistDTOS.add(dto);
        }
        return responseArtistDTOS;
    }

    public void isExist(Long artistId) {
        boolean exist = artistRepository.existsById(artistId);
        if (!exist) {
            System.out.println("Artist Not Found with ID: " + artistId);
        }
    }

    public ResponseArtistDTO getArtistById(Long artistId) {
        isExist(artistId);

        ArtistEntity artist = artistRepository.findById(artistId).orElse(null);
        assert(artist != null);
        return ArtistModelMapper.toDTO(artist);
    }

    public ResponseArtistDTO getArtistByName(String artistName) {
        boolean exist = artistRepository.existsByArtistName(artistName);
        if (!exist) {
            System.out.println("Artist Not Found with name " + artistName);
        }
        ArtistEntity artist = artistRepository.findByArtistName(artistName);
        assert(artist != null);
        return ArtistModelMapper.toDTO(artist);
    }

    public void deleteArtist(Long artistId) {
        isExist(artistId);
        artistRepository.deleteById(artistId);
    }

}
