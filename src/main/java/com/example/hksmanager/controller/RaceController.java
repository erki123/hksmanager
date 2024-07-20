package com.example.hksmanager.controller;

import com.example.hksmanager.component.Race;
import com.example.hksmanager.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService){
        this.raceService = raceService;
    }

    // Read all races
    @GetMapping("/all")
    public ResponseEntity<List<Race>> getAllRaces(){
        List<Race> races = raceService.findAllRaces();
        return new ResponseEntity<>(races, HttpStatus.OK);
    }

    // Find race by id
    @GetMapping("/find/{id}")
    public ResponseEntity<Race> getRaceByID(@PathVariable("id") Long id){
        Race race = raceService.findRaceById(id);
        return new ResponseEntity<>(race, HttpStatus.OK);
    }

    // Add new race
    @PostMapping("/add")
    public ResponseEntity<Race> addRace(@RequestBody Race race){
        Race newRace = raceService.addRace(race);
        return new ResponseEntity<>(newRace, HttpStatus.CREATED);
    }

    // Update race
    @PutMapping("/update")
    public ResponseEntity<Race> updateRace(@RequestBody Race race){
        Race updatedRace = raceService.updateRace(race);
        return new ResponseEntity<>(updatedRace, HttpStatus.OK);
    }

    // Delete race
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRace(@PathVariable("id") Long id){
        raceService.deleteRace(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
