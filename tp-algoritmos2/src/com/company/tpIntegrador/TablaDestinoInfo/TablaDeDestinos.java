package com.company.tpIntegrador.TablaDestinoInfo;

import java.util.List;

public class TablaDeDestinos {
    private List<RegistroDestino> destinos;
    //agrego comentario
    public TablaDeDestinos(List<RegistroDestino> destinos) {
        this.destinos = destinos;
    }

    public List<RegistroDestino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<RegistroDestino> destinos) {
        this.destinos = destinos;
    }
}
