package com.company.tpIntegrador;


import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.TablaDestinoInfo.TablaDeDestinos;
import com.company.tpIntegrador.exceptions.CanjeableExistenteException;
import com.company.tpIntegrador.exceptions.RegistroDestinoExistente;
import com.company.tpIntegrador.exceptions.UsuarioExistenteException;
import com.company.tpIntegrador.milesGenerator.Combustible;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.milesGenerator.Hotel;
import com.company.tpIntegrador.milesGenerator.Viaje;
import com.company.tpIntegrador.milesGenerator.tripTypes.Business;
import com.company.tpIntegrador.milesGenerator.tripTypes.Primera;
import com.company.tpIntegrador.travellers.Viajero;
import com.company.tpIntegrador.travellers.ViajeroFrecuente;
import com.company.tpIntegrador.travellers.ViajeroNormal;
import com.google.gson.Gson;


import java.io.File;
import java.math.BigDecimal;
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
    public static void main(String args[]){

    GeneradorDeMillas combustible = new Combustible("shell","se cargo 400 pesos",true,new BigDecimal(1.2),new BigDecimal(1));
    ArrayList<GeneradorDeMillas> generadorDeMillas = new ArrayList<>();
    generadorDeMillas.add(combustible);
    Viajero juan = new Viajero("Juan", 312331, generadorDeMillas ,null,0,0, new ViajeroNormal());
    ArrayList<Viajero> viajeros= new ArrayList<>();
    viajeros.add(juan);
    Lugar cancun = new Lugar("Cancun","deas");
    Lugar miami = new Lugar("Miami","das");
    RegistroDestino destino1 = new RegistroDestino(cancun,miami,new BigDecimal(1300),200);
    ArrayList<RegistroDestino> destinos = new ArrayList<>();
    destinos.add(destino1);
    TablaDeDestinos tablaDeDestinos1 = new TablaDeDestinos(destinos);

        Viaje viajeEnPrimera = new Primera("da","descripcion",true,new BigDecimal(1.1),cancun,miami,null);

        SistemaCanjeMillas sistemaCanjeMillas = new SistemaCanjeMillas(generadorDeMillas,viajeros,null,tablaDeDestinos1);


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
public void gananciaMillas(RegistroDestino registroDestino,Viaje viaje, Viajero viajero) {
       BigDecimal ganancia = registroDestino.getCostoMillas().multiply(viaje.getMilesFactor());
       if (viaje.getClass().getSimpleName() == "Business") {
          ganancia.plus(); // agregarle el 50%, nose como hacerlo con bigdecimal
           viajero.setAcumulatedMiles(ganancia.intValue());
       } else  if (viaje.getClass().getSimpleName() == "Primera"){
        ganancia.plus(); // agregarle el 100%
           viajero.setAcumulatedMiles(ganancia.intValue());
       }
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
