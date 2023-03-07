package com.prasad.evchargingstation.evchargingstationapp.service;

import java.util.List;
import java.util.Optional;

import com.prasad.evchargingstation.evchargingstationapp.model.Station;

public interface StationService {
    
    Station saveStation(Station station);
    
    List<Station> getAllStations();
    
    Optional<Station> getStationById(Long stationId);
    
    void deleteStationById(Long stationId);
}
