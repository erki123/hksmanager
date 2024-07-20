package com.example.hksmanager.repository;

import com.example.hksmanager.component.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    Optional<Race> findRaceById(Long id);
    void deleteRaceById(Long id);
}
