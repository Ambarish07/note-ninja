package com.noteninja.backend.repository;

import com.noteninja.backend.model.Chord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChordRepository extends JpaRepository<Chord, Integer> {
}