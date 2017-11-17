package com.company.tpIntegrador.milesGenerator;

import java.math.BigDecimal;

public class Combustible extends GeneradorDeMillas {
    private BigDecimal chargedLiters;


    public Combustible(){
        super();
    }

    public Combustible(String id, String description, Boolean state, BigDecimal milesFactor, BigDecimal chargedLiters) {
        super(id, description, state, milesFactor);
        this.chargedLiters = chargedLiters;
    }

    public BigDecimal getChargedLiters() {
        return chargedLiters;
    }

    public void setChargedLiters(BigDecimal chargedLiters) {
        this.chargedLiters = chargedLiters;
    }

    @Override
    public BigDecimal calculateMiles(BigDecimal milesFactor) {
        return this.chargedLiters.divide(milesFactor);
    }
}
