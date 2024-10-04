package com.noteninja.backend.service;

import com.noteninja.backend.model.StringFret;
import com.noteninja.backend.repository.StringFretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StringFretService {

    @Autowired
    StringFretRepository repository;

    public StringFretService(){
    }
    public List<StringFret> getAllStringFrets() {
        return this.repository.findAll();
    }

    public Optional<StringFret> getStringFretByID(Integer id) {
        return repository.findById(id);
    }

    public StringFret createStringFret(StringFret stringFrets) {
        return repository.save(stringFrets);
    }

//    public StringFret updateStringFret(StringFret stringFret) {
//        return repository. ;
//    }
    public void deleteChord(Integer id) {
        repository.deleteById(id);
    }

}
