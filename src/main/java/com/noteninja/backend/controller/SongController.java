package com.noteninja.backend.controller;
import com.noteninja.backend.model.Song;
import com.noteninja.backend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/songs")
public class SongController {
    @Autowired
    private SongService service;

    @GetMapping
    public ResponseEntity<List<Song>> getAllChords() {
        return ResponseEntity.ok().body(service.getAllSongs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Song>> getChordByID(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getSongById(id));
    }
    @PostMapping
    public ResponseEntity<Song> createChord(@RequestBody Song song){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createSong(song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChord(@PathVariable Integer id){
        this.service.deleteSong(id);
        return ResponseEntity.ok().body("Deleted Chord with ID : " + id + ", if it existed.");
    }
}
