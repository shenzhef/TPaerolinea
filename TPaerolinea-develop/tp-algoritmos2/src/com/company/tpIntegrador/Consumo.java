package com.company.tpIntegrador;

public class Consumo extends GeneradorDeMillas{

    private int costoConsumo;

    public double obtenerConsumo(double factorMillas) {  // Aca podriamos sino pasar como parametro un consumo
        return this.costoConsumo*factorMillas;
    }
}
