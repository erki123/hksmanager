package com.example.hksmanager;

import com.example.hksmanager.component.Race;
import com.example.hksmanager.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/*@Component
public class DataLoader implements CommandLineRunner {

    private final RaceService raceService;

    @Autowired
    public DataLoader(RaceService raceService) {
        this.raceService = raceService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRaceData();
    }

    private void loadRaceData() {
        if (raceService.findAllRaces().isEmpty()) {
            Race race1 = new Race(null, "Race1", "Pärnu", "22.07.24", "First race in Pärnu");
            raceService.addRace(race1);
        }
    }
}*/
