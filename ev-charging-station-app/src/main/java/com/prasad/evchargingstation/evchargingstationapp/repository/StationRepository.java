package com.prasad.evchargingstation.evchargingstationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prasad.evchargingstation.evchargingstationapp.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
