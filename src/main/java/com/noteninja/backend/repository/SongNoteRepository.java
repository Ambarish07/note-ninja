package com.noteninja.backend.repository;

import com.noteninja.backend.model.SongNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SongNoteRepository extends JpaRepository<SongNote, Integer> {
}
