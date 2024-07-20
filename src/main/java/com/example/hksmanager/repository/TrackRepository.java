package com.example.hksmanager.repository;

import com.example.hksmanager.component.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {

    void deleteTrackById(Long id);

    Optional<Track> findTrackById(Long id);
}
