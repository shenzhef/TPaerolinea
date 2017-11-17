package com.company.tpIntegrador.milesGenerator;

import java.math.BigDecimal;

public class Consumo extends GeneradorDeMillas {
    private BigDecimal consumo;

    public Consumo(String id, String description, Boolean state, BigDecimal milesFactor, BigDecimal consumo) {
        super(id, description, state, milesFactor);
        this.consumo = consumo;
    }

    public Consumo (){
        super();
    }

    public BigDecimal getConsumo() {
        return consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }

    @Override
    public BigDecimal calculateMiles(BigDecimal milesFactor) {
        return this.consumo.multiply(milesFactor);
    }
}
