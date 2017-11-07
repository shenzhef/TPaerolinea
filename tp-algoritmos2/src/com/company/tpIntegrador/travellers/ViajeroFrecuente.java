package com.company.tpIntegrador.travellers;

import com.company.tpIntegrador.Canjeable;
import com.company.tpIntegrador.exceptions.ExcessLimitDiscountException;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;

import java.util.List;

public class ViajeroFrecuente extends Viajero {

    public ViajeroFrecuente(String name, Integer dni, List<GeneradorDeMillas> generatorList, List<Canjeable> canjeableList, Integer acumulatedMiles) {
        super(name, dni, generatorList, canjeableList, acumulatedMiles);
    }

    @Override
    public Double calculateDiscount() {
        Integer acum = this.getAcumulatedMiles()/1000;
        Double discount = acum*0.02;
        if (discount<30){
            return discount;
        }else return 30d;
    }
}
