package com.company.tpIntegrador.milesGenerator;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.Lugar;

import java.math.BigDecimal;

public abstract class Viaje extends GeneradorDeMillas implements Canjeable {
    private Lugar from;
    private Lugar to;

    public Viaje(String id, String description, Boolean state, BigDecimal milesFactor, Lugar from, Lugar to) {
        super(id, description, state, milesFactor);
        this.from = from;
        this.to = to;
    }

    public Lugar getFrom() {
        return from;
    }

    public Lugar getTo() {
        return to;
    }

    //Getters de SUPER
    @Override
    public BigDecimal getMilesFactor() {
        return super.getMilesFactor();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public Boolean getState() {
        return super.getState();
    }

    @Override
    public BigDecimal calculateMiles(BigDecimal milesFactor) {
        return calculateMilesForType(milesFactor);
    }

    public abstract BigDecimal calculateMilesForType(BigDecimal milesFactor);
}
