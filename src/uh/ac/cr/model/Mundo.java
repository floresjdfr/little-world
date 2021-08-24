package uh.ac.cr.model;

import uh.ac.cr.model.persona.Cocinero;
import uh.ac.cr.model.persona.Doctor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountedCompleter;

public class Mundo {

    private String name;
    private Gobierno gobierno;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Cocinero> listaCocineros;

    public Mundo(String nombre) {
        this.name = nombre;
        gobierno = null;
        listaDoctores = new ArrayList<>();
        listaCocineros = new ArrayList<>();
    }
    public Gobierno getGobierno() {
        return gobierno;
    }
    public void setGobierno(Gobierno gobierno) {
        this.gobierno = gobierno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }
    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }
    public ArrayList<Cocinero> getListaCocineros() {
        return listaCocineros;
    }
    public void setListaCocineros(ArrayList<Cocinero> listaCocineros) {
        this.listaCocineros = listaCocineros;
    }

    //Doctores
    public void crearDoctor(Doctor d) {
        listaDoctores.add(d);
    }

    //Concineros
    public void crearCocinero(Cocinero c){
        listaCocineros.add(c);
    }
    public void cocineroGanarDinero(Cocinero c){
        c.ganarDinero();
    }
    public void cocineroAgregarReceta(Cocinero c, String r){
        c.agregarReceta(r);
    }
    public ArrayList<String> cocineroGetRecetas(Cocinero c){
        return c.getRecetas();
    }

}

