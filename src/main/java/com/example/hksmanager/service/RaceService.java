package com.example.hksmanager.service;

import com.example.hksmanager.exception.RaceNotFoundException;
import com.example.hksmanager.component.Race;
import com.example.hksmanager.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RaceService {

    private static final Logger logger = LoggerFactory.getLogger(RaceService.class);
    private final RaceRepository raceRepo;

    @Autowired
    public RaceService(RaceRepository raceRepo){
        this.raceRepo = raceRepo;
    }

    // Adding new race
    public Race addRace(Race race){
        return raceRepo.save(race);
    }

    // Finding all races
    public List<Race> findAllRaces(){
        return raceRepo.findAll();
    }

    // Updating race information
    public Race updateRace(Race race){
        logger.info("Updating race with id {}", race.getId());
        Optional<Race> existingRaceOpt = raceRepo.findById(race.getId());
        if (existingRaceOpt.isPresent()) {
            Race existingRace = existingRaceOpt.get();
            logger.info("Before update: {}", existingRace);

            existingRace.setName(race.getName());
            existingRace.setLocation(race.getLocation());
            existingRace.setTime(race.getTime());
            existingRace.setDescription(race.getDescription());

            Race savedRace = raceRepo.save(existingRace);
            logger.info("After update: {}", savedRace);
            return savedRace;
        } else {
            throw new RaceNotFoundException("Race by id " + race.getId() + " not found");
        }
    }

    // Find race by id
    public Race findRaceById(Long id){
        return raceRepo.findRaceById(id).orElseThrow(
                () -> new RaceNotFoundException("Race by id " + id + " not found")
        );
    }

    // Delete race
    public void deleteRace(Long id){
        raceRepo.deleteRaceById(id);
    }
}