package com.company.tpIntegrador;

import java.math.BigDecimal;

public class Producto implements Canjeable {
    private String name;
    private String description;
    private BigDecimal milesCost;

    public Producto(String name, String description, BigDecimal milesCost) {
        this.name = name;
        this.description = description;
        this.milesCost = milesCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMilesCost() {
        return milesCost;
    }

    public void setMilesCost(BigDecimal milesCost) {
        this.milesCost = milesCost;
    }
}
