package com.company.tpIntegrador;


import com.company.tpIntegrador.TablaDestinoInfo.RegistroDestino;
import com.company.tpIntegrador.TablaDestinoInfo.TablaDeDestinos;
import com.company.tpIntegrador.exceptions.CanjeableExistenteException;
import com.company.tpIntegrador.exceptions.RegistroDestinoExistente;
import com.company.tpIntegrador.exceptions.UsuarioExistenteException;
import com.company.tpIntegrador.milesGenerator.GeneradorDeMillas;
import com.company.tpIntegrador.milesGenerator.Viaje;
import com.company.tpIntegrador.travellers.Viajero;
import com.company.tpIntegrador.travellers.ViajeroFrecuente;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.sun.jndi.cosnaming.CNCtx;
import org.omg.CORBA.PUBLIC_MEMBER;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    //PUNTO 2 TERMINAR
    public void registrarMillas(Gson gson,JsonReader jsonFile){
        Viajero viajero = gson.fromJson(jsonFile,Viajero.class);
        System.out.println(viajero.toString());
    }

    //FUNCION GANANCIA MILLAS POR VIAJES

    public void gananciaMillasPorViaje(Viajero viajero, Viaje viaje, TablaDeDestinos tablaDeDestinos){
        List<RegistroDestino> destinoList = tablaDeDestinos.getDestinos();

        //ACA SE FILTRA LA LISTA DE DESTINOS Y SE HACE EL GET 0 PARA OBTENER EL REGISTRO DE DESTINO QUE CORRESPONDE.
        RegistroDestino registroDestinoResultado =
                destinoList.stream().filter(registroDestino -> registroDestino.getOrigen().equals(viaje.getFrom()))
                        .filter(registroDestino -> registroDestino.getTo().equals(viaje.getTo()))
                        .collect(Collectors.toList()).get(0);
        System.out.println(registroDestinoResultado.getOrigen().getName());

        //AHORA SE VA A CALCULAR LA GANANCIA DE MILLAS PARA EL VIAJERO QUE ENTRA POR PARAMETRO Y SE LE VA A SETEAR EL RESULTADO
        BigDecimal gananciaMillas = new BigDecimal(0);
        gananciaMillas = gananciaMillas.add((registroDestinoResultado.getGananciaMillas().multiply(viaje.calculateMiles(viaje.getMilesFactor()))));

        gananciaMillas = gananciaMillas.add(viajero.getAcumulatedMiles());
        viajero.setAcumulatedMiles(gananciaMillas.setScale(0, BigDecimal.ROUND_HALF_EVEN));

    }

    //FUNCION CANJE DE MILLAS
    public void canjearMillasPorProducto(Viajero viajero, Producto producto) {
        ArrayList<Canjeable> canjeables = new ArrayList<>();
        if (producto.getMilesCost().compareTo(viajero.getAcumulatedMiles() ) < 0) {
            viajero.setAcumulatedMiles(viajero.getAcumulatedMiles().subtract(producto.getMilesCost()));
            canjeables.add(producto);
            this.getCanjeables().remove(producto);
            viajero.setCanjeableList(canjeables);
        }
        if (producto.getMilesCost().compareTo(new BigDecimal(1000)) > 0 ) {
            viajero.setTipoViajero(new ViajeroFrecuente());
        }
    }
    public void canjearMillasViaje(Viajero viajero,Viaje viaje)
    {
        ArrayList<Canjeable> canjeables = new ArrayList<>();
        if (viaje.getRegistroDestino().getCostoMillas().compareTo(viajero.getAcumulatedMiles()) < 0 ) {
            viajero.setAcumulatedMiles(viajero.getAcumulatedMiles().subtract(viaje.getRegistroDestino().getCostoMillas()));
            canjeables.add(viaje);
            this.canjeables.remove(viaje);
            viajero.setCanjeableList(canjeables);
        }
        if (viaje.getRegistroDestino().getCostoMillas().compareTo(new BigDecimal(1000)) > 0 ) {
            viajero.setTipoViajero(new ViajeroFrecuente());
        }
    }
    public void canjeoDisponible(Viajero viajero) {
        List<Canjeable>  canjeables= this.getCanjeables();

        List<Canjeable> canjeable= (List<Canjeable>) canjeables.stream().filter(e -> viajero.getAcumulatedMiles().compareTo(e.costoMillas() ) > 0).collect(Collectors.toList());
        for (Canjeable canje: canjeable) {
            System.out.println(canje.mostrarCanjeable());
        }
    }
}
