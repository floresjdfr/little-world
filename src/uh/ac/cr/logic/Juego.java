package uh.ac.cr.logic;

import uh.ac.cr.logic.persona.*;
import uh.ac.cr.logic.vehiculo.AdministrarVehiculo;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.*;

import java.util.ArrayList;

public class Juego {

    private AdministrarMundo adminJuego;
    private AdministrarDoctor adminDoctor;
    private AdministrarCocinero adminCocinero;
    private AdministrarAlbañil adminAlbanil;
    private AdministarHerrero adminHerrero;
    private AdministrarCarpintero adminCarpintero;
    private AdministrarMundo adminMundo;
    private AdministrarVehiculo adminVehiculo;

    public Juego(Mundo mundo){
        this.adminJuego = new AdministrarMundo(mundo);
        this.adminDoctor = new AdministrarDoctor(mundo);
        this.adminCocinero = new AdministrarCocinero(mundo);
        this.adminAlbanil = new AdministrarAlbañil(mundo);
        this.adminHerrero = new AdministarHerrero(mundo);
        this.adminCarpintero = new AdministrarCarpintero(mundo);
        this.adminMundo = new AdministrarMundo(mundo);
        this.adminVehiculo = new AdministrarVehiculo(mundo);
    }

    //Mundo
    public String getNombreMundo(){
        return adminJuego.getNombreMundo();
    }
    public Boolean sembrarArbol(){
        return adminMundo.sembrarArbol();
    }
    public int getArboles(){
        return adminMundo.getArboles();
    }
    public Boolean construirCasa(int idPersona){
        return adminMundo.construirCasa(idPersona);
    }
    public void comprarBicicleta(int idComprador, int idVendedor){
        adminVehiculo.comprarBicicleta(idComprador, idVendedor);
    }

    //Doctores
    public void crearDoctor(int id, String nombre, String apellidos, String especialidad){
        adminDoctor.crearDoctor(id, nombre, apellidos, especialidad);
    }
    public ArrayList<Doctor> getDoctores(){
        return adminDoctor.getListaDeDoctores();
    }

    //Cocineros
    public ArrayList<Cocinero> getCocineros(){
        return adminCocinero.getCocineros();
    }
    public void crearCocinero(int id, String nombre, String apellidos, String recetas){
        adminCocinero.crearCocinero(id, nombre, apellidos, recetas);
    }
    public void ganarDinero(){
        adminCocinero.ganarDinero();
    }
    public void agregarReceta(String receta){
        adminCocinero.agregarReceta(receta);
    }
    public String recetasNoDisponibles(String nuevasRecetas){
        return adminCocinero.recetasNoDisponibles(nuevasRecetas);
    }

    //Albaniles
    public Boolean crearAlbanil(int id, String nombre, String apellidos){
        return adminAlbanil.crearAlbañil(id, nombre, apellidos);
    }
    public ArrayList<Albañil> getAlbaniles(){
        return adminAlbanil.getMundo().getListaAlbaniles();
    }

    //Herreros
    public Boolean crearHerrero(int id, String nombre, String apellidos){
        return adminHerrero.crearHerrero(id, nombre, apellidos);
    }
    public ArrayList<Herrero> getHerreros(){
        return adminHerrero.getMundo().getListaHerreros();
    }
    public void construirBicicleta(int idHerreroConstructor){
        adminVehiculo.construirBicicleta(idHerreroConstructor);
    }

    //Carpinteros
    public Boolean crearCarpintero(int id, String nombre, String apellidos){
        return adminCarpintero.crearCarpintero(id, nombre, apellidos);
    }
    public ArrayList<Carpintero> getCarpinteros(){
        return adminCarpintero.getMundo().getListaCarpinteros();
    }


}
