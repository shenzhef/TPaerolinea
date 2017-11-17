package com.company.tpIntegrador;

import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.TablaDestinoInfo.TablaDeDestinos;
import com.company.tpIntegrador.milesGenerator.Combustible;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.milesGenerator.Viaje;
import com.company.tpIntegrador.milesGenerator.tripTypes.Primera;
import com.company.tpIntegrador.travellers.Viajero;
import com.company.tpIntegrador.travellers.ViajeroNormal;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        //SE AGREGAN GENERADORES A LA LISTA DE GENERADORES DE MILLAS
        GeneradorDeMillas combustible = new Combustible("shell","se cargo 400 pesos",true,new BigDecimal(1.2),new BigDecimal(1));
        ArrayList<GeneradorDeMillas> generadorDeMillas = new ArrayList<>();
        generadorDeMillas.add(combustible);

        //SE AGREGAN VIAJEROS A LA LISTA DE VIAJEROS
        Viajero juan = new Viajero("Juan", 312331, generadorDeMillas ,null,new BigDecimal(0),new BigDecimal(0), new ViajeroNormal());
        ArrayList<Viajero> viajeros= new ArrayList<>();
        viajeros.add(juan);

        //SE AGREGAN LUGARES AL REGISTRO DE DESTINO, Y ESE REGISTRO SE AGREGA A LA LISTA DE DESTINOS
        Lugar cancun = new Lugar("Cancun","deas");
        Lugar miami = new Lugar("Miami","das");
        RegistroDestino destino1 = new RegistroDestino(cancun,miami,new BigDecimal(300),new BigDecimal(200));
        ArrayList<RegistroDestino> destinos = new ArrayList<>();
        destinos.add(destino1);
        TablaDeDestinos tablaDeDestinos1 = new TablaDeDestinos(destinos);

        //SE CREAN ELEMENTOS CANJEABLES Y SE METEN A LA LISTA DE CANJEABLES
        Viaje viajeEnPrimera = new Primera("da","descripcion",true,new BigDecimal(1.6),cancun,miami,null,destino1);
        Producto sillon = new Producto("SILLON","sillon de dos plazas",new BigDecimal(400));
        ArrayList<Canjeable> canjeables = new ArrayList<>();
        canjeables.add(sillon);
        canjeables.add(viajeEnPrimera);

        //SE INSTANCIA EL SISTEMA DE CANJE DE MILLAS CON TODOS LOS ELEMENTOS ANTERIORES
        SistemaCanjeMillas sistemaCanjeMillas = new SistemaCanjeMillas(generadorDeMillas,viajeros,canjeables,tablaDeDestinos1);
        sistemaCanjeMillas.gananciaMillasPorViaje(juan,viajeEnPrimera,tablaDeDestinos1);

        //    sistemaCanjeMillas.canjearMillasPorProducto(juan,sillon);
        sistemaCanjeMillas.canjeoDisponible(juan);

        //REGISTRAR UN USUARIO DADO UN JSON
        try {
            Gson gson = new Gson();

            JsonReader jsonReader = new JsonReader(new FileReader("registrarMillas.json"));
            sistemaCanjeMillas.registrarMillas(gson,jsonReader);

        }catch (FileNotFoundException e){
            System.out.println("No se encontro el archivo");
        }
    }
}
