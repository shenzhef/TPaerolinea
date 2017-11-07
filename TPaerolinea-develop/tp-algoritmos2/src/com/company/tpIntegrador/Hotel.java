package com.company.tpIntegrador;

public class Hotel extends GeneradorDeMillas {
    private Lugar lugar;
    private String categoria;
    private int precioPorNoche;
    private int cantNoches;

    double obtenerMillas(double factorMillas) {
        return cantNoches*precioPorNoche*factorMillas;
    }

}
