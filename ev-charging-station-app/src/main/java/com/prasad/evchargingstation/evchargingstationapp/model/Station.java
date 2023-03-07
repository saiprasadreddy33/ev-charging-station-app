package com.prasad.evchargingstation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stationId;

    private String stationName;

    private String stationImage;

    private String stationPricing;

    private String stationAddress;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationImage() {
        return stationImage;
    }

    public void setStationImage(String stationImage) {
        this.stationImage = stationImage;
    }

    public String getStationPricing() {
        return stationPricing;
    }

    public void setStationPricing(String stationPricing) {
        this.stationPricing = stationPricing;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    // constructors, equals, hashcode, toString methods
}
