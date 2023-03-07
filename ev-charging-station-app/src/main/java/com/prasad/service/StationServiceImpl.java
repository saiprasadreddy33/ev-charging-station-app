package com.prasad.evchargingstation.evchargingstationapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.evchargingstation.evchargingstationapp.exception.ResourceNotFoundException;
import com.prasad.evchargingstation.evchargingstationapp.model.Station;
import com.prasad.evchargingstation.evchargingstationapp.repository.StationRepository;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationRepository stationRepository;

    @Override
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public Station getStationById(Long stationId) throws ResourceNotFoundException {
        Optional<Station> station = stationRepository.findById(stationId);
        if (!station.isPresent()) {
            throw new ResourceNotFoundException("Station not found with id : " + stationId);
        }
        return station.get();
    }

    @Override
    public Station createStation(Station station) {
        return stationRepository.save(station);
    }

    @Override
    public Station updateStation(Long stationId, Station stationDetails) throws ResourceNotFoundException {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Station not found for this id :: " + stationId));

        station.setStationName(stationDetails.getStationName());
        station.setStationImage(stationDetails.getStationImage());
        station.setStationPricing(stationDetails.getStationPricing());
        station.setStationAddress(stationDetails.getStationAddress());

        return stationRepository.save(station);
    }

    @Override
    public void deleteStation(Long stationId) throws ResourceNotFoundException {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new ResourceNotFoundException("Station not found for this id :: " + stationId));

        stationRepository.delete(station);
    }
}
