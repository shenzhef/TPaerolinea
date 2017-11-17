package com.company.tpIntegrador.milesGenerator.tripTypes;

import com.company.tpIntegrador.Lugar;
import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.milesGenerator.Viaje;

import java.math.BigDecimal;

public class Turista extends Viaje {

    public Turista(String id, String description, Boolean state, BigDecimal milesFactor, Lugar from, Lugar to, RegistroDestino registroDestino) {
        super(id, description, state, milesFactor, from, to, registroDestino);
    }

    @Override
    public BigDecimal calculateMilesForType(BigDecimal milesFactor) {
        return milesFactor;
    }
}
