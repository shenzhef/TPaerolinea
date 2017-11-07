package com.company.tpIntegrador.milesGenerator;

import com.company.tpIntegrador.Lugar;

import java.math.BigDecimal;

public class Hotel extends GeneradorDeMillas {
    private Lugar place;
    private String category;
    private BigDecimal pricePerNight;
    private BigDecimal nightsNumber;

    public Hotel(String id, String description, Boolean state, BigDecimal milesFactor, Lugar place, String category, BigDecimal pricePerNight, BigDecimal nightsNumber) {
        super(id, description, state, milesFactor);
        this.place = place;
        this.category = category;
        this.pricePerNight = pricePerNight;
        this.nightsNumber = nightsNumber;
    }

    public BigDecimal getNightsNumber() {
        return nightsNumber;
    }

    public Lugar getPlace() {
        return place;
    }

    public void setPlace(Lugar place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public BigDecimal calculateMiles(BigDecimal milesFactor) {
        return this.nightsNumber.multiply(this.pricePerNight).multiply(milesFactor);
    }
}
