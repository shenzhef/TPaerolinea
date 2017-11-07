package com.company.tpIntegrador.milesGenerator;

import java.math.BigDecimal;

public class Combustible extends GeneradorDeMillas {
    private BigDecimal chargedLiters;


    public Combustible(String id, String description, Boolean state, BigDecimal milesFactor, BigDecimal chargedLiters) {
        super(id, description, state, milesFactor);
        this.chargedLiters = chargedLiters;
    }

    @Override
    public BigDecimal calculateMiles(BigDecimal milesFactor) {
        return this.chargedLiters.divide(milesFactor);
    }
}
