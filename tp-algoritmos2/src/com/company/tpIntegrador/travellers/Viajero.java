package com.company.tpIntegrador.travellers;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;

import java.math.BigDecimal;
import java.util.List;

public class Viajero {
    private String name;
    private Integer dni;
    private List<GeneradorDeMillas> generatorList;
    private List<Canjeable> canjeableList;
    private BigDecimal acumulatedMiles;
    private BigDecimal wastedMiles;
    private TipoViajero tipoViajero;

    //CONSTRUCTOR
    public Viajero(String name, Integer dni, List<GeneradorDeMillas> generadorDeMillas, List<Canjeable> canjeableList, BigDecimal acumulatedMiles, BigDecimal wastedMiles, TipoViajero tipoViajero) {
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

    public BigDecimal getAcumulatedMiles() {
        return acumulatedMiles;
    }

    public void setAcumulatedMiles(BigDecimal acumulatedMiles) {
        this.acumulatedMiles = acumulatedMiles;
    }

    public BigDecimal getWastedMiles() {
        return wastedMiles;
    }

    public void setWastedMiles(BigDecimal wastedMiles) {
        this.wastedMiles = wastedMiles;
    }

    public TipoViajero getTipoViajero() {
        return tipoViajero;
    }

    public void setTipoViajero(TipoViajero tipoViajero) {
        this.tipoViajero = tipoViajero;
    }
}
