package com.prasad.evchargingstation.evchargingstationapp.service;

import com.prasad.evchargingstation.evchargingstationapp.exception.EvChargingStationNotFoundException;
import com.prasad.evchargingstation.evchargingstationapp.model.EvChargingStation;
import com.prasad.evchargingstation.evchargingstationapp.repository.EvChargingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvChargingStationServiceImpl implements EvChargingStationService {

    @Autowired
    private EvChargingStationRepository evChargingStationRepository;

    @Override
    public List<EvChargingStation> getAllEvChargingStations() {
        return evChargingStationRepository.findAll();
    }

    @Override
    public EvChargingStation getEvChargingStationById(Long id) {
        Optional<EvChargingStation> optionalEvChargingStation = evChargingStationRepository.findById(id);
        if (optionalEvChargingStation.isPresent()) {
            return optionalEvChargingStation.get();
        } else {
            throw new EvChargingStationNotFoundException("EV Charging Station not found with id " + id);
        }
    }

    @Override
    public void saveOrUpdateEvChargingStation(EvChargingStation evChargingStation) {
        evChargingStationRepository.save(evChargingStation);
    }

    @Override
    public void deleteEvChargingStationById(Long id) {
        Optional<EvChargingStation> optionalEvChargingStation = evChargingStationRepository.findById(id);
        if (optionalEvChargingStation.isPresent()) {
            evChargingStationRepository.deleteById(id);
        } else {
            throw new EvChargingStationNotFoundException("EV Charging Station not found with id " + id);
        }
    }
}
