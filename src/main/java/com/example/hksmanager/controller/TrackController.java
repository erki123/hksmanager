package com.example.hksmanager.controller;

import com.example.hksmanager.component.Track;
import com.example.hksmanager.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    // Read all tracks
    @GetMapping("/all")
    public ResponseEntity<List<Track>> getAllTracks(){
        List<Track> tracks = trackService.findAllTracks();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    // Find track by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Track> getTrackByID(@PathVariable("id") Long id){
        Track track = trackService.findTrackById(id);
        return new ResponseEntity<>(track, HttpStatus.OK);
    }

    // Add new track
    @PostMapping("/add")
    public ResponseEntity<Track> addTrack(@RequestBody Track track){
        Track newTrack = trackService.addTrack(track);
        return new ResponseEntity<>(newTrack, HttpStatus.CREATED);
    }

    // Update track
    @PutMapping("/update")
    public ResponseEntity<Track> updateTrack(@RequestBody Track track){
        Track updatedTrack = trackService.updateTrack(track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.OK);
    }

    // Delete track
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") Long id){
        trackService.deleteTrack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
