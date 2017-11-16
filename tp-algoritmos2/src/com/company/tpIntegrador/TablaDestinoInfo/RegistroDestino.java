package com.company.tpIntegrador.TablaDestinoInfo;

import com.company.tpIntegrador.Lugar;

import java.math.BigDecimal;

public class RegistroDestino {
    private Lugar origen;
    private Lugar to;
    private BigDecimal costoMillas;
    private BigDecimal gananciaMillas;

    public RegistroDestino(Lugar origen, Lugar to, BigDecimal costoMillas, BigDecimal gananciaMillas) {
        this.origen = origen;
        this.to = to;
        this.costoMillas = costoMillas;
        this.gananciaMillas = gananciaMillas;
    }

    public Lugar getOrigen() {
        return origen;
    }

    public void setOrigen(Lugar origen) {
        this.origen = origen;
    }

    public Lugar getTo() {
        return to;
    }

    public void setTo(Lugar to) {
        this.to = to;
    }

    public BigDecimal getCostoMillas() {
        return costoMillas;
    }

    public void setCostoMillas(BigDecimal costoMillas) {
        this.costoMillas = costoMillas;
    }

    public BigDecimal getGananciaMillas() {
        return gananciaMillas;
    }

    public void setGananciaMillas(BigDecimal gananciaMillas) {
        this.gananciaMillas = gananciaMillas;
    }
}
