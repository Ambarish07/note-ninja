package com.noteninja.backend.repository;

import com.noteninja.backend.model.StringFret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StringFretRepository extends JpaRepository<StringFret, Integer> {

}
