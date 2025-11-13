package com.Album.Music.entities;

import com.Album.Music.types.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "album_table")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20 , nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @PastOrPresent
    private LocalDate releaseDate;

    @ManyToOne
    private ArtistEntity artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<MusicEntity> music = new ArrayList<>();
}
