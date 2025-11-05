package com.Album.Music.services;

import com.Album.Music.modelMappers.ArtistModelMapper;
import com.Album.Music.repositories.ArtistRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private ArtistModelMapper artistModelMapper;

    @InjectMocks
    private ArtistService artistService;



}