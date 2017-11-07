package com.company.tpIntegrador.milesGenerator;

import java.math.BigDecimal;

public abstract class GeneradorDeMillas {
    private String id;
    private String description;
    private Boolean state; //CAMBIAR EL TIPO DEL ESTADO AHORA LO DEJO EN BOOLEAN PARA HACERLO MAS CLARO
    private BigDecimal milesFactor;

    public GeneradorDeMillas(String id, String description, Boolean state, BigDecimal milesFactor) {
        this.id = id;
        this.description = description;
        this.state = state;
        this.milesFactor = milesFactor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public BigDecimal getMilesFactor() {
        return milesFactor;
    }

    public void setMilesFactor(BigDecimal milesFactor) {
        this.milesFactor = milesFactor;
    }

    public abstract BigDecimal calculateMiles(BigDecimal milesFactor);
}
