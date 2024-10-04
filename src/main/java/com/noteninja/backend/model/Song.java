package com.noteninja.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;
    @Column(name = "genre")
    private String genre;
    @Column(name = "notes")
    private List<SongNote> notes;
}
