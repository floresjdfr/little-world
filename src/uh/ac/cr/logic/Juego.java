package uh.ac.cr.logic;

import uh.ac.cr.logic.persona.AdministradorCocinero;
import uh.ac.cr.logic.persona.AdministrarDoctor;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.persona.Cocinero;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;

public class Juego {

    private AdministrarDoctor adminDoctor;
    private AdministradorCocinero adminCocinero;
    private AdministradorJuego adminJuego;

    public Juego(Mundo mundo){
        this.adminDoctor = new AdministrarDoctor(mundo);
        this.adminCocinero = new AdministradorCocinero(mundo);
        this.adminJuego = new AdministradorJuego(mundo);
    }

    //Mundo
    public String getNombreMundo(){
        return adminJuego.getNombreMundo();
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


}
