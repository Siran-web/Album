package com.Album.Music.controllers;

import com.Album.Music.dtos.musicDtos.ResponseMusicDTO;
import com.Album.Music.types.Genre;
import com.Album.Music.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<ResponseMusicDTO> createMusic(@RequestBody ResponseMusicDTO inputMusic) {
        ResponseMusicDTO responseMusicDTO = musicService.createMusic(inputMusic);
        return new ResponseEntity<>(responseMusicDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseMusicDTO>> getAllMusic() {
        List<ResponseMusicDTO> responseMusicDTOS = musicService.getAllMusic();
        return new ResponseEntity<>(responseMusicDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/{musicId}")
    public ResponseEntity<ResponseMusicDTO> getMusicById(@PathVariable Long musicId) {
        ResponseMusicDTO responseMusicDTO = musicService.getMusicById(musicId);
        return new ResponseEntity<>(responseMusicDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/artist/{artistId}")
    public ResponseEntity<List<ResponseMusicDTO>> getMusicByArtistId(@PathVariable Long artistId) {
        List<ResponseMusicDTO> responseMusicDTOS = musicService.getMusicByArtistId(artistId);
        return new ResponseEntity<>(responseMusicDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/genre/ {genre}")
    public ResponseEntity<List<ResponseMusicDTO>> getMusicByGenre(@PathVariable Genre genre) {
        List<ResponseMusicDTO> responseMusicDTOS = musicService.getMusicByGenre(genre);
        return new ResponseEntity<>(responseMusicDTOS, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{musicId}")
    public Boolean deleteMusicById(@PathVariable Long musicId) {
        musicService.deleteMusicById(musicId);
        return true;
    }
}
