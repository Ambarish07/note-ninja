package com.noteninja.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class SongNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Integer id;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "wait_time")
    private Integer waitTime;
    @Column(name = "order")
    private Integer order;

    // Having 2 separate entities for Chord and StringFret, so that in future we can have jam sessions
    // where some can play chords and others can play strfret.

    @JoinColumn(name = "chord_id")
    private Chord chord;

    @JoinColumn(name = "fret_id")
    private StringFret stringFret;
}
