package com.noteninja.backend.service;

import com.noteninja.backend.model.Chord;
import com.noteninja.backend.repository.ChordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChordService {
    @Autowired
    private ChordRepository repository;

    public ChordService() {
    }

    public List<Chord> getAllChords() {
        return this.repository.findAll();
    }

    public Optional<Chord> getChordByID(Integer id) {
        return repository.findById(id);
    }

    public Chord createChord(Chord chord) {
        return repository.save(chord);
    }

//    public Chord updateChord(Chord chord) {
//        return repository. ;
//    }
    public void deleteChord(Integer id) {
        repository.deleteById(id);
    }


}
