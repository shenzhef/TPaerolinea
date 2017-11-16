package com.company.tpIntegrador.travellers;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;

import java.util.List;

public class Viajero {
    private String name;
    private Integer dni;
    private List<GeneradorDeMillas> generatorList;
    private List<Canjeable> canjeableList;
    private Integer acumulatedMiles;
    private Integer wastedMiles;
    private TipoViajero tipoViajero;

    //CONSTRUCTOR
    public Viajero(String name, Integer dni, List<GeneradorDeMillas> generadorDeMillas, List<Canjeable> canjeableList, Integer acumulatedMiles, Integer wastedMiles, TipoViajero tipoViajero) {
        this.name = name;
        this.dni = dni;
        this.generatorList = generadorDeMillas;
        this.canjeableList = canjeableList;
        this.acumulatedMiles = acumulatedMiles;
        this.wastedMiles = wastedMiles;
        this.tipoViajero = tipoViajero;
    }

    public double calcularDescuento(){
        return tipoViajero.calculateDiscount(this);
    }

    //GETTERS Y SETTERS
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

    public Integer getWastedMiles() {
        return wastedMiles;
    }

    public void setWastedMiles(Integer wastedMiles) {
        this.wastedMiles = wastedMiles;
    }

    public TipoViajero getTipoViajero() {
        return tipoViajero;
    }

    public void setTipoViajero(TipoViajero tipoViajero) {
        this.tipoViajero = tipoViajero;
    }
}
