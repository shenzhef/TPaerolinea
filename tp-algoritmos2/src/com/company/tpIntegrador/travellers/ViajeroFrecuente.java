package com.company.tpIntegrador.travellers;

public class ViajeroFrecuente implements TipoViajero {

    @Override
    public Double calculateDiscount(Viajero viajero) {
        Integer acum = viajero.getWastedMiles()/1000;
        return acum*0.02;
    }
}
