package com.Album.Music.entities;

import com.Album.Music.entities.types.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "music")
public class MusicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicId;

    @Column(length = 100 , nullable = false)
    private String title;

    @PastOrPresent
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany
    @JoinColumn
    private ArtistEntity artistEntity;

}
