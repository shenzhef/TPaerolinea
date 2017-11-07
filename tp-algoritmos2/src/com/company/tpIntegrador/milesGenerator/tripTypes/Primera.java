package com.company.tpIntegrador.milesGenerator.tripTypes;

import com.company.tpIntegrador.Adicional;
import com.company.tpIntegrador.Lugar;
import com.company.tpIntegrador.milesGenerator.Viaje;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Primera extends Viaje {

    private List<Adicional> adicionals = new ArrayList<>(3);

    public Primera(String id, String description, Boolean state, BigDecimal milesFactor, Lugar from, Lugar to, List<Adicional> adicionals) {
        super(id, description, state, milesFactor, from, to);
        this.adicionals = adicionals;
    }

    public List<Adicional> getAdicionals() {
        return adicionals;
    }

    public void setAdicionals(List<Adicional> adicionals) {
        this.adicionals = adicionals;
    }

    @Override
    public BigDecimal calculateMilesForType() {
        return null;
    }
}
