package com.company.tpIntegrador;

import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.travellers.Viajero;

import java.util.List;

public class SistemaCanjeMillas {

    //SOLO LOS DISPONIBLES
    private List<GeneradorDeMillas> generadorDeMillas;
    private List<Viajero> viajeros;
    private List<Canjeable> canjeables;

    public SistemaCanjeMillas(List<GeneradorDeMillas> generadorDeMillas, List<Viajero> viajeros, List<Canjeable> canjeables) {
        this.generadorDeMillas = generadorDeMillas;
        this.viajeros = viajeros;
        this.canjeables = canjeables;
    }

    public List<GeneradorDeMillas> getGeneradorDeMillas() {
        return generadorDeMillas;
    }

    public void setGeneradorDeMillas(List<GeneradorDeMillas> generadorDeMillas) {
        this.generadorDeMillas = generadorDeMillas;
    }

    public List<Viajero> getViajeros() {
        return viajeros;
    }

    public void setViajeros(List<Viajero> viajeros) {
        this.viajeros = viajeros;
    }

    public List<Canjeable> getCanjeables() {
        return canjeables;
    }

    public void setCanjeables(List<Canjeable> canjeables) {
        this.canjeables = canjeables;
    }
}
