package com.company.tpIntegrador.travellers;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;

import java.util.List;

public abstract class Viajero {
    private String name;
    private Integer dni;
    private List<GeneradorDeMillas> generatorList;
    private List<Canjeable> canjeableList;
    private Integer acumulatedMiles;

    public Viajero(String name, Integer dni, List<GeneradorDeMillas> generatorList, List<Canjeable> canjeableList,
                   Integer acumulatedMiles) {
        this.name = name;
        this.dni = dni;
        this.generatorList = generatorList;
        this.canjeableList = canjeableList;
        this.acumulatedMiles = acumulatedMiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public List<GeneradorDeMillas> getGeneratorList() {
        return generatorList;
    }

    public void setGeneratorList(List<GeneradorDeMillas> generatorList) {
        this.generatorList = generatorList;
    }

    public List<Canjeable> getCanjeableList() {
        return canjeableList;
    }

    public void setCanjeableList(List<Canjeable> canjeableList) {
        this.canjeableList = canjeableList;
    }

    public Integer getAcumulatedMiles() {
        return acumulatedMiles;
    }

    public void setAcumulatedMiles(Integer acumulatedMiles) {
        this.acumulatedMiles = acumulatedMiles;
    }
    public abstract Double calculateDiscount();
}
