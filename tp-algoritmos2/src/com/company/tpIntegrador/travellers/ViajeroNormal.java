package com.company.tpIntegrador.travellers;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;

import java.util.List;

public class ViajeroNormal extends Viajero {

    public ViajeroNormal(String name, Integer dni, List<GeneradorDeMillas> generatorList, List<Canjeable> canjeableList, Integer acumulatedMiles) {
        super(name, dni, generatorList, canjeableList, acumulatedMiles);
    }

    @Override
    public Double calculateDiscount() {
        Integer acum = this.getAcumulatedMiles()/1000;
        return acum*0.01;
    }
}
