package com.Album.Music.repositories;

import com.Album.Music.entities.ArtistEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    private ArtistEntity artistEntity;

//    @BeforeEach
//    void setUp() {
//       ArtistEntity artistEntity = ArtistEntity.builder()
//               .artistId(1L)
//               .artistName("Simran")
//               .nationality("Bihari")
//               .build();
//    }

    @Test
    void testFindByArtistName() {
        //Arrange
        artistRepository.save(artistEntity);

        //Act
        ArtistEntity artist = artistRepository.findByArtistName("Simran");

        //Assert
        assertThat(artist).isNotNull();
        assertThat(artist.getArtistName()).isEqualTo("Simran");
    }

    @Test
    void testFindByName_NotFound() {
        //Arrange
        String name  = "Shama";

        //Act
        ArtistEntity artist = artistRepository.findByArtistName(name);

        //Assert
        assertThat(artist).isNull();
        assertThat(artist.getArtistName()).isEqualTo(name);

    }
}