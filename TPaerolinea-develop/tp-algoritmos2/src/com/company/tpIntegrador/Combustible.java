package com.company.tpIntegrador;

public class Combustible extends GeneradorDeMillas {
    private int litrosCargados;

    double obtenerCombustible(double factorMillas) {
        return  litrosCargados/factorMillas;
    }
}
