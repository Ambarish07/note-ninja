package com.noteninja.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chords")
public class Chord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chord_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "chord_name")
    private String chordName;
    @OneToMany(mappedBy = "chord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StringFret> frets;
}

