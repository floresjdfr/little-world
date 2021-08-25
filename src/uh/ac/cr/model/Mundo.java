package uh.ac.cr.model;

import uh.ac.cr.model.persona.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountedCompleter;

public class Mundo {

    private String name;
    private Gobierno gobierno;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Cocinero> listaCocineros;
    private ArrayList<Albañil> listaAlbaniles;
    private ArrayList<Herrero> listaHerreros;
    private ArrayList<Carpintero> listaCarpinteros;

    private int contadorCreacion;

    public Mundo(String nombre) {
        this.name = nombre;
        gobierno = null;
        listaDoctores = new ArrayList<>();
        listaCocineros = new ArrayList<>();
        listaAlbaniles = new ArrayList<>();
        listaHerreros = new ArrayList<>();
        listaCocineros = new ArrayList<>();
        listaCarpinteros = new ArrayList<>();
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
    public ArrayList<Albañil> getListaAlbaniles() {
        return listaAlbaniles;
    }
    public void setListaAlbaniles(ArrayList<Albañil> listaAlbaniles) {
        this.listaAlbaniles = listaAlbaniles;
    }
    public ArrayList<Herrero> getListaHerreros() {
        return listaHerreros;
    }
    public void setListaHerreros(ArrayList<Herrero> listaHerreros) {
        this.listaHerreros = listaHerreros;
    }
    public ArrayList<Carpintero> getListaCarpinteros() {
        return listaCarpinteros;
    }
    public void setListaCarpinteros(ArrayList<Carpintero> listaCarpinteros) {
        this.listaCarpinteros = listaCarpinteros;
    }
    public int getContadorCreacion() {
        return contadorCreacion;
    }
    public void setContadorCreacion(int contadorCreacion) {
        this.contadorCreacion = contadorCreacion;
    }

    //Metodos generales
    public void aumentarContadorCreacion(){
        contadorCreacion++;
    }
    public void resetCotnadorCreacion(){
        contadorCreacion = 0;
    }
    public void darDineroATodos(double dinero){
        for (Doctor d: listaDoctores)
            d.setDinero(d.getDinero() + dinero);
        for (Cocinero c: listaCocineros)
            c.setDinero(c.getDinero() + dinero);
        for (Albañil a: listaAlbaniles)
            a.setDinero(a.getDinero() + dinero);
        for (Herrero h: listaHerreros)
            h.setDinero(h.getDinero() + dinero);
        for (Carpintero c: listaCarpinteros)
            c.setDinero(c.getDinero() + dinero);
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


    //Albaniles
    public void crearAlbanil(Albañil a){
        listaAlbaniles.add(a);
    }

    //Herreros
    public void crearHerrero(Herrero h){
        listaHerreros.add(h);
    }

    //Carpinteros
    public void crearCarpintero(Carpintero c){
        listaCarpinteros.add(c);
    }

}

