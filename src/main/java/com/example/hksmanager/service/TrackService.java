package com.example.hksmanager.service;

import com.example.hksmanager.exception.TrackNotFoundException;
import com.example.hksmanager.component.Track;
import com.example.hksmanager.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrackService {

    private static final Logger logger = LoggerFactory.getLogger(TrackService.class);
    private final TrackRepository trackRepo;

    @Autowired
    public TrackService(TrackRepository trackRepo){
        this.trackRepo = trackRepo;
    }

    // Adding new track
    public Track addTrack(Track track){
        return trackRepo.save(track);
    }

    // Finding all tracks
    public List<Track> findAllTracks(){
        return trackRepo.findAll();
    }

    // Updating track information
    public Track updateTrack(Track track){
        logger.info("Updating track with id {}", track.getId());
        Optional<Track> existingTrackOpt = trackRepo.findById(track.getId());
        if (existingTrackOpt.isPresent()) {
            Track existingTrack = existingTrackOpt.get();
            logger.info("Before update: {}", existingTrack);

            existingTrack.setName(track.getName());
            existingTrack.setTrackLength(track.getTrackLength());

            Track savedTrack = trackRepo.save(existingTrack);
            logger.info("After update: {}", savedTrack);
            return savedTrack;
        } else {
            throw new TrackNotFoundException("Track by id " + track.getId() + " not found");
        }
    }

    // Find track by id
    public Track findTrackById(Long id){
        return trackRepo.findTrackById(id).orElseThrow(
                () -> new TrackNotFoundException("Track by id " + id + " not found")
        );
    }

    // Delete track
    public void deleteTrack(Long id){
        trackRepo.deleteTrackById(id);
    }
}

