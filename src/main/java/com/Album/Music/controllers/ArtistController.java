package com.Album.Music.controllers;

import com.Album.Music.dtos.artistDtos.ResponseArtistDTO;
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
    private ResponseEntity<ResponseArtistDTO> createArtist(@RequestBody ResponseArtistDTO responseArtistDTO){
        ResponseArtistDTO artist = artistService.createArtist(responseArtistDTO);
        return ResponseEntity.ok(artist);
    }

    @GetMapping
    private ResponseEntity<List<ResponseArtistDTO>> getArtist(){
        List<ResponseArtistDTO> responseArtistDTO = artistService.getArtists();
        return ResponseEntity.ok(responseArtistDTO);
    }

    @GetMapping(path = "/{artistId}")
    private ResponseEntity<ResponseArtistDTO> getArtistById(@PathVariable Long artistId){
        ResponseArtistDTO artist = artistService.getArtistById(artistId);
        return ResponseEntity.ok(artist);
    }

    @DeleteMapping(path = "/{artistId}")
    private Boolean deleteArtistById(@PathVariable Long artistId){
        artistService.deleteArtist(artistId);
        return true;
    }

}
