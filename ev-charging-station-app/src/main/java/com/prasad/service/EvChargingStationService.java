package com.prasad.evchargingstation.service;

import com.prasad.evchargingstation.exception.EvChargingStationNotFoundException;
import com.prasad.evchargingstation.model.EvChargingStation;
import java.util.List;

public interface EvChargingStationService {
    List<EvChargingStation> getAllEvChargingStations();
    EvChargingStation getEvChargingStationById(Long id) throws EvChargingStationNotFoundException;
    EvChargingStation createEvChargingStation(EvChargingStation evChargingStation);
    EvChargingStation updateEvChargingStation(Long id, EvChargingStation evChargingStation) throws EvChargingStationNotFoundException;
    void deleteEvChargingStation(Long id) throws EvChargingStationNotFoundException;
}
