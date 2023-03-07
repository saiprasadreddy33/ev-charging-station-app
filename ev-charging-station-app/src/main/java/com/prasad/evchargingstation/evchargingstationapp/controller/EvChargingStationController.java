package com.prasad.evchargingstation.evchargingstationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prasad.evchargingstation.evchargingstationapp.model.EvChargingStation;
import com.prasad.evchargingstation.evchargingstationapp.service.EvChargingStationService;

@RestController
@RequestMapping("/evchargingstations")
public class EvChargingStationController {

    @Autowired
    private EvChargingStationService evChargingStationService;

    // GET all ev charging stations
    @GetMapping
    public ResponseEntity<List<EvChargingStation>> getAllEvChargingStations() {
        List<EvChargingStation> evChargingStations = evChargingStationService.getAllEvChargingStations();
        return new ResponseEntity<>(evChargingStations, HttpStatus.OK);
    }

    // GET a single ev charging station
    @GetMapping("/{id}")
    public ResponseEntity<EvChargingStation> getEvChargingStationById(@PathVariable Long id) {
        EvChargingStation evChargingStation = evChargingStationService.getEvChargingStationById(id);
        return new ResponseEntity<>(evChargingStation, HttpStatus.OK);
    }

    // CREATE a new ev charging station
    @PostMapping
    public ResponseEntity<EvChargingStation> createEvChargingStation(@RequestBody EvChargingStation evChargingStation) {
        EvChargingStation createdEvChargingStation = evChargingStationService.createEvChargingStation(evChargingStation);
        return new ResponseEntity<>(createdEvChargingStation, HttpStatus.CREATED);
    }

    // UPDATE an existing ev charging station
    @PutMapping("/{id}")
    public ResponseEntity<EvChargingStation> updateEvChargingStation(@PathVariable Long id, @RequestBody EvChargingStation evChargingStation) {
        EvChargingStation updatedEvChargingStation = evChargingStationService.updateEvChargingStation(id, evChargingStation);
        return new ResponseEntity<>(updatedEvChargingStation, HttpStatus.OK);
    }

    // DELETE an ev charging station
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvChargingStation(@PathVariable Long id) {
        evChargingStationService.deleteEvChargingStation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
