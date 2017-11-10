package com.company.tpIntegrador;

import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.TablaDestinoInfo.TablaDeDestinos;
import com.company.tpIntegrador.exceptions.CanjeableExistenteException;
import com.company.tpIntegrador.exceptions.RegistroDestinoExistente;
import com.company.tpIntegrador.exceptions.UsuarioExistenteException;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.milesGenerator.Viaje;
import com.company.tpIntegrador.travellers.Viajero;
import com.google.gson.Gson;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SistemaCanjeMillas {

    //SOLO LOS DISPONIBLES
    private List<GeneradorDeMillas> generadorDeMillas;
    private List<Viajero> viajeros;
    private List<Canjeable> canjeables;
    private TablaDeDestinos tablaDeDestinos;

    public SistemaCanjeMillas(List<GeneradorDeMillas> generadorDeMillas, List<Viajero> viajeros, List<Canjeable> canjeables, TablaDeDestinos tablaDeDestinos) {
        this.generadorDeMillas = generadorDeMillas;
        this.viajeros = viajeros;
        this.canjeables = canjeables;
        this.tablaDeDestinos = tablaDeDestinos;
    }

    public List<GeneradorDeMillas> getGeneradorDeMillas() {
        return generadorDeMillas;
    }

    public void setGeneradorDeMillas(List<GeneradorDeMillas> generadorDeMillas) {
        this.generadorDeMillas = generadorDeMillas;
    }

    public List<Viajero> getViajeros() {
        return viajeros;
    }

    public void setViajeros(List<Viajero> viajeros) {
        this.viajeros = viajeros;
    }

    public List<Canjeable> getCanjeables() {
        return canjeables;
    }

    public void setCanjeables(List<Canjeable> canjeables) {
        this.canjeables = canjeables;
    }

    public TablaDeDestinos getTablaDeDestinos() {
        return tablaDeDestinos;
    }

    public void setTablaDeDestinos(TablaDeDestinos tablaDeDestinos) {
        this.tablaDeDestinos = tablaDeDestinos;
    }

    //ALTA
    public void altaUsuario(Viajero viajero){
        if (!(this.viajeros.contains(viajero))){
            this.viajeros.add(viajero);
        }else throw new UsuarioExistenteException("El usuario ya existe");
    }

    public void altaCanjeable(Canjeable canjeable){
        if (!(this.canjeables.contains(canjeable))){
            this.canjeables.add(canjeable);
        }else throw new CanjeableExistenteException("El canjeable ya existe");
    }

    public void altaLugar(RegistroDestino registroDestino){
        if(!(this.tablaDeDestinos.getDestinos().contains(registroDestino))){
            this.tablaDeDestinos.getDestinos().add(registroDestino);
        }else throw new RegistroDestinoExistente("Ya existe el registro en la tabla");
    }

    //BAJA
    public void bajaUsuario(Viajero viajero){
        if (this.viajeros.contains(viajero)){
            this.viajeros.remove(viajero);
        }else throw  new NoSuchElementException("No existe ese usuario");
    }
    public void bajaCanjeable(Canjeable canjeable){
        if (this.canjeables.contains(canjeable)){
            this.canjeables.remove(canjeable);
        }else throw new NoSuchElementException("No existe ese canjeable");
    }
    public void bajaLugar(RegistroDestino registroDestino){
        if (this.tablaDeDestinos.getDestinos().contains(registroDestino)){
            this.tablaDeDestinos.getDestinos().remove(registroDestino);
        }else throw new NoSuchElementException("No existe ese registro");
    }

    //Busqueda Viajero DNI
    public Viajero buscarViajero(String nombre, Integer dni){
        for (Viajero v : this.viajeros){
            if (v.getDni().equals(dni) && v.getName().equals(nombre)){
                return v;
            }
        }
        throw new NoSuchElementException("no existe el usuario");
    }

    public void registrarMillas(File jsonFile){
        String json = jsonFile.toString();
        Viajero viajero = new Gson().fromJson(json,Viajero.class);
        GeneradorDeMillas generadorDeMillas = viajero.getGeneratorList().get(0);
        if (this.viajeros.contains(viajero) && generadorDeMillas.getState()){

        }

    }
}
