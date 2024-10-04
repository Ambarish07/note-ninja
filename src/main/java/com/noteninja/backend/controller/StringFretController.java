package com.noteninja.backend.controller;

import com.noteninja.backend.model.Chord;
import com.noteninja.backend.model.StringFret;
import com.noteninja.backend.service.StringFretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stringfrets")
public class StringFretController {
    @Autowired
    private StringFretService service;

    @GetMapping
    public ResponseEntity<List<StringFret>> getAllStringFrets(){
        return ResponseEntity.ok().body(service.getAllStringFrets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<StringFret>> getStringFretByID(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.getStringFretByID(id));
    }
    @PostMapping
    public ResponseEntity<StringFret> createStringFret(@RequestBody StringFret stringFret){

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createStringFret(stringFret));
    }

    //    @PutMapping("/{id}")
//    public Optional<ResponseEntity<StringFret>> updateChord(@PathVariable String id, @RequestBody StringFret stringFret){
//        return null;
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChord(@PathVariable Integer id){
        this.service.deleteChord(id);
        return ResponseEntity.ok().body("Deleted StringFret with ID : " + id + ", if it existed.");
    }
}
