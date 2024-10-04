package com.noteninja.backend.service;

import com.noteninja.backend.model.Chord;
import com.noteninja.backend.model.Song;
import com.noteninja.backend.model.SongNote;
import com.noteninja.backend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SongService {

        @Autowired
        private SongRepository repository;
        @Autowired
        private ChordService chordService;
        @Autowired
        private StringFretService stringFretService;
        public List<Song> getAllSongs(){
            return this.repository.findAll();
        }

        public Optional<Song> getSongById(Integer id){
            return this.repository.findById(id);
        }

        public Song createSong(Song song){
            for (SongNote note : song.getNotes()) {
//                if (note.getStringFret() != null && note.getStringFret().getId() == null) {
//                    StringFret savedFret = stringFretService.createStringFret(note.getStringFret());
//                    note.setStringFret(savedFret); // Set the saved fret with its ID back into the note
//                }

                // Save Chords
                if (note.getChord() != null && note.getChord().getId() == null) {
                    Chord savedChord = chordService.createChord(note.getChord());
                    note.setChord(savedChord); // Set the saved chord with its ID back into the note
                }
            }
            return repository.save(song);
        }
        public void deleteSong(Integer id) {
            repository.deleteById(id);
        }
}