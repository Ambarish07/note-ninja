package com.noteninja.backend.service;

import com.noteninja.backend.model.Song;
import com.noteninja.backend.model.SongNote;
import com.noteninja.backend.repository.SongNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongNoteService {
    @Autowired
    private SongNoteRepository repository;

    public List<SongNote> getAllSongNotes(){
        return this.repository.findAll();
    }

    public Optional<SongNote> getNoteById(Integer id){
        return this.repository.findById(id);
    }

    public SongNote createNote(SongNote songNote){
        return repository.save(songNote);
    }
    public void deleteNote(Integer id) {
        repository.deleteById(id);
    }
}
