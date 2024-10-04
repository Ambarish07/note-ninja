package com.noteninja.backend.controller;

import com.noteninja.backend.model.Chord;
import com.noteninja.backend.service.ChordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/chords")
public class ChordController {
    @Autowired
    private ChordService service;

    @GetMapping
    public ResponseEntity<List<Chord>> getAllChords() {
        return ResponseEntity.ok().body(service.getAllChords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Chord>> getChordByID(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getChordByID(id));
    }
    @PostMapping
    public ResponseEntity<Chord> createChord(@RequestBody Chord chord){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createChord(chord));
    }

//    @PutMapping("/{id}")
//    public Optional<ResponseEntity<Chord>> updateChord(@PathVariable String id, @RequestBody Chord chord){
//        return null;
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChord(@PathVariable Integer id){
        this.service.deleteChord(id);
        return ResponseEntity.ok().body("Deleted Chord with ID : " + id + ", if it existed.");
    }
}
