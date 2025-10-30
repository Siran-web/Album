package com.Album.Music.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

    @Column(length = 20 , nullable = false)
    private String artistName;

    private String nationality;

//    @OneToMany(mappedBy = "artist")
//    private List<MusicEntity> musicEntities;
}
