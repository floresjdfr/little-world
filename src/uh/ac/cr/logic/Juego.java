package uh.ac.cr.logic;

import uh.ac.cr.logic.persona.*;
import uh.ac.cr.logic.vehiculo.AdministrarVehiculo;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.*;

import java.util.ArrayList;

public class Juego {

    private AdministrarMundo adminJuego;
    private AdministrarCreacionPersona adminCreacionPersonas;
    private AdministrarMundo adminMundo;
    private AdministrarVehiculo adminVehiculo;
    private AdministradorArchivo adminArchivo;

    public Juego(Mundo mundo) {

        this.adminJuego = new AdministrarMundo(mundo);
        this.adminCreacionPersonas = new AdministrarCreacionPersona(mundo);
        this.adminMundo = new AdministrarMundo(mundo);
        this.adminVehiculo = new AdministrarVehiculo(mundo);
        this.adminArchivo = new AdministradorArchivo(mundo);
    }

    //Personas
    public ArrayList<Doctor> getDoctores() {
        return adminCreacionPersonas.getDoctores();
    }

    public ArrayList<Cocinero> getCocineros() {
        return adminCreacionPersonas.getCocineros();
    }

    public ArrayList<Albañil> getAlbaniles() {
        return adminCreacionPersonas.getAlbaniles();
    }

    public ArrayList<Herrero> getHerreros() {
        return adminCreacionPersonas.getHerreros();
    }

    public ArrayList<Carpintero> getCarpinteros() {
        return adminCreacionPersonas.getCarpinteros();
    }

    //Mundo
    public String getNombreMundo() {
        return adminJuego.getNombreMundo();
    }

    public Boolean sembrarArbol(Boolean salir) {
        return adminMundo.sembrarArbol(salir);
    }

    public int getArboles() {
        return adminMundo.getArboles();
    }

    public Boolean construirCasa(int idPersona, Boolean salir) {
        return adminMundo.construirCasa(idPersona, salir);
    }

    public void solicitarPrestamo(int idPrestamista, String interesado, double totalPrestamo, Boolean salir) {
        adminMundo.solicitarPrestamo(idPrestamista, interesado, totalPrestamo, salir);
    }

    public void pagarPrestamo(int idPrestamista, String pagadora, double pago, Boolean salir) {
        adminMundo.pagarPrestamo(idPrestamista, pagadora, pago, salir);
    }

    public String imprimirGobierno() {
        return adminMundo.imprimirGobierno();
    }

    public void construirBicicleta(int idHerreroConstructor, Boolean salir) {
        adminVehiculo.construirBicicleta(idHerreroConstructor, salir);
    }

    public void comprarBicicleta(int idComprador, int idVendedor, Boolean salir) {
        adminVehiculo.comprarBicicleta(idComprador, idVendedor, salir);
    }

    public void conducirBicicleta(int personaConductora, Boolean salir) {
        adminVehiculo.conducirBicicleta(personaConductora, salir);
    }

    public void construirAutomovil(int idCarpinteroConstructor, int idDoctorConstructor, Boolean salir) {
        adminVehiculo.construirAutomovil(idCarpinteroConstructor, idDoctorConstructor, salir);
    }

    public void comprarAutomovil(int idPersonaCompradora, int idPersonaVendedora, Boolean salir) {
        adminVehiculo.comprarAutomovil(idPersonaCompradora, idPersonaVendedora, salir);
    }

    public void conducirAutomovil(int idPersonaConductora, Boolean salir) {
        adminVehiculo.conducirAutomovil(idPersonaConductora, salir);
    }

    public int esIntValido(String supuestoString){
        return AdministrarValidaciones.esIntValido(supuestoString);
    }
    //Doctores
    public void crearDoctor(int id, String nombre, String apellidos, String especialidad, Boolean salir) {
        adminCreacionPersonas.crearDoctor(id, nombre, apellidos, especialidad, salir);
    }

    //Cocineros
    public void crearCocinero(int id, String nombre, String apellidos, String recetas, Boolean salir) {
        adminCreacionPersonas.crearCocinero(id, nombre, apellidos, recetas, salir);
    }

    public void agregarReceta(String receta) {
        adminCreacionPersonas.agregarReceta(receta);
    }

    public String recetasNoDisponibles(String nuevasRecetas) {
        return adminCreacionPersonas.recetasNoDisponibles(nuevasRecetas);
    }

    //Albaniles
    public Boolean crearAlbanil(int id, String nombre, String apellidos, Boolean salir) {
        return adminCreacionPersonas.crearAlbañil(id, nombre, apellidos, salir);
    }

    //Herreros
    public Boolean crearHerrero(int id, String nombre, String apellidos, Boolean salir) {
        return adminCreacionPersonas.crearHerrero(id, nombre, apellidos, salir);
    }

    //Carpinteros
    public Boolean crearCarpintero(int id, String nombre, String apellidos, Boolean salir) {
        return adminCreacionPersonas.crearCarpintero(id, nombre, apellidos, salir);
    }

    //Archivos
    public void guardarMundo(String nombre){
        adminArchivo.saveFile(nombre);
    }
    public Mundo recuperarMundo(String nombre){
        return adminArchivo.readFile(nombre);
    }


}
