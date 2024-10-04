package com.noteninja.backend.controller;

import com.noteninja.backend.model.Chord;
import com.noteninja.backend.model.SongNote;
import com.noteninja.backend.service.SongNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/notes")
public class SongNoteController {
    @Autowired
    private SongNoteService service;

    @GetMapping
    public ResponseEntity<List<SongNote>> getAllNotes(){
        return ResponseEntity.ok().body(service.getAllSongNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SongNote>> getNoteByID(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getNoteById(id));
    }

    @PostMapping
    public ResponseEntity<SongNote> createNote(@RequestBody SongNote note){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createNote(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Integer id){
        this.service.deleteNote(id);
        return ResponseEntity.ok().body("Deleted Chord with ID : " + id + ", if it existed.");
    }
}
