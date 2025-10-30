package com.Album.Music.controllers;

import com.Album.Music.dtos.ArtistDTO;
import com.Album.Music.services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @PostMapping
    private ResponseEntity<ArtistDTO> createArtist(@RequestBody ArtistDTO artistDTO){
        ArtistDTO artist = artistService.createArtist(artistDTO);
        return ResponseEntity.ok(artist);
    }

    @GetMapping
    private ResponseEntity<List<ArtistDTO>> getArtist(){
        List<ArtistDTO> artistDTO = artistService.getArtists();
        return ResponseEntity.ok(artistDTO);
    }

    @GetMapping(path = "/{artistId}")
    private ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long artistId){
        ArtistDTO artist = artistService.getArtistById(artistId);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping(path = "/{artistId}")
    private Boolean deleteArtistById(@PathVariable Long artistId){
        artistService.deleteArtist(artistId);
        return true;
    }

}
