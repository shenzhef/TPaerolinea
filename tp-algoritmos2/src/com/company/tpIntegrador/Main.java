package com.company.tpIntegrador;

import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.TablaDestinoInfo.TablaDeDestinos;
import com.company.tpIntegrador.milesGenerator.Combustible;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.milesGenerator.Viaje;
import com.company.tpIntegrador.milesGenerator.tripTypes.Primera;
import com.company.tpIntegrador.travellers.Viajero;
import com.company.tpIntegrador.travellers.ViajeroNormal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
       GeneradorDeMillas combustible = new Combustible("shell","se cargo 400 pesos",true,new BigDecimal(1.2),new BigDecimal(1));
        ArrayList<GeneradorDeMillas> generadorDeMillas = new ArrayList<>();
        generadorDeMillas.add(combustible);
        Viajero juan = new Viajero("Juan", 312331, generadorDeMillas ,null,new BigDecimal(0),new BigDecimal(0), new ViajeroNormal());
        ArrayList<Viajero> viajeros= new ArrayList<>();
        viajeros.add(juan);
        Lugar cancun = new Lugar("Cancun","deas");
        Lugar miami = new Lugar("Miami","das");
        RegistroDestino destino1 = new RegistroDestino(cancun,miami,new BigDecimal(1300),new BigDecimal(200));
        ArrayList<RegistroDestino> destinos = new ArrayList<>();
        destinos.add(destino1);
        TablaDeDestinos tablaDeDestinos1 = new TablaDeDestinos(destinos);

        Viaje viajeEnPrimera = new Primera("da","descripcion",true,new BigDecimal(1.6),cancun,miami,null);

        SistemaCanjeMillas sistemaCanjeMillas = new SistemaCanjeMillas(generadorDeMillas,viajeros,null,tablaDeDestinos1);
sistemaCanjeMillas.gananciaMillasPorViaje(juan,viajeEnPrimera,tablaDeDestinos1);
Producto sillon = new Producto("SILLON","sillon de dos plazas",new BigDecimal(400));
        ArrayList<Canjeable> canjeables = new ArrayList<>();
        canjeables.add(sillon);

sistemaCanjeMillas.canjearMillasPorProducto(juan,sillon);

    }
}
