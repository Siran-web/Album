package com.Album.Music.repositories;

import com.Album.Music.entities.ArtistEntity;
import com.Album.Music.entities.MusicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    ArtistEntity findByArtistName(String artistName);

    Boolean existsByArtistName(String artistName);

    List<MusicEntity> findByArtistId(Long artistId);
}
