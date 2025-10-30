package com.Album.Music.controllers;

import com.Album.Music.dtos.MusicDTO;
import com.Album.Music.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
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
    public ResponseEntity<MusicDTO> createMusic(@RequestBody MusicDTO inputMusic) {
        MusicDTO musicDTO = musicService.createMusic(inputMusic);
        return new ResponseEntity<>(musicDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MusicDTO>> getAllMusic() {
        List<MusicDTO> musicDTOs = musicService.getAllMusic();
        return new ResponseEntity<>(musicDTOs, HttpStatus.OK);
    }

    @GetMapping(path = "/{musicId}")
    public ResponseEntity<MusicDTO> getMusicById(@PathVariable Long musicId) {
        MusicDTO musicDTO = musicService.getMusicById(musicId);
        return new ResponseEntity<>(musicDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{musicId}")
    public Boolean deleteMusicById(@PathVariable Long musicId) {
        musicService.deleteMusicById(musicId);
        return true;
    }
}
