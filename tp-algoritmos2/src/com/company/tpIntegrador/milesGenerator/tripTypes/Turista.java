package com.company.tpIntegrador.milesGenerator.tripTypes;

import com.company.tpIntegrador.Lugar;
import com.company.tpIntegrador.milesGenerator.Viaje;

import java.math.BigDecimal;

public class Turista extends Viaje {

    public Turista(String id, String description, Boolean state, BigDecimal milesFactor, Lugar from, Lugar to) {
        super(id, description, state, milesFactor, from, to);
    }

    @Override
    public BigDecimal calculateMilesForType() {
        return null;
    }
}
