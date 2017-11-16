package com.company.tpIntegrador.travellers;

public class ViajeroFrecuente implements TipoViajero {

    @Override
    public Double calculateDiscount(Viajero viajero) {

        Integer acum = viajero.getWastedMiles().intValue()/1000;
        return acum*0.02;
    }
}
