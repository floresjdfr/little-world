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

    private int arboles;

    private int contadorCreacion;
    private int contadorMuerteArbol;
    private int contadorPrestamoGobierno;
    private int contadorDividirDineroGobierno;


    public Mundo(String nombre) {
        this.name = nombre;
        gobierno = new Gobierno(0);
        listaDoctores = new ArrayList<>();
        listaCocineros = new ArrayList<>();
        listaAlbaniles = new ArrayList<>();
        listaHerreros = new ArrayList<>();
        listaCarpinteros = new ArrayList<>();

        arboles = 20;
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
    public int getArboles() {
        return arboles;
    }
    public void setArboles(int arboles) {
        this.arboles = arboles;
    }
    public int getContadorMuerteArbol() {
        return contadorMuerteArbol;
    }
    public void setContadorMuerteArbol(int contadorMuerteArbol) {
        this.contadorMuerteArbol = contadorMuerteArbol;
    }
    public int getContadorPrestamoGobierno() {
        return contadorPrestamoGobierno;
    }
    public void setContadorPrestamoGobierno(int contadorPrestamoGobierno) {
        this.contadorPrestamoGobierno = contadorPrestamoGobierno;
    }
    public int getContadorDividirDineroGobierno() {
        return contadorDividirDineroGobierno;
    }
    public void setContadorDividirDineroGobierno(int contadorDividirDineroGobierno) {
        this.contadorDividirDineroGobierno = contadorDividirDineroGobierno;
    }

    //Metodos generales
    public void aumentarContadorCreacion(){
        contadorCreacion++;
    }
    public void resetCotnadorCreacion(){
        contadorCreacion = 0;
    }
    public void aumentarContadorMuerteArbol(){
        contadorMuerteArbol++;
    }
    public void resetContadorMuerteArbol(){
        contadorMuerteArbol = 0;
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
    public void sembrarArbol(){
        arboles++;
        gobierno.sembrarArbol();
    }
    public Persona buscarPersona(int idPersona){

        Persona p = null;

        p = this.buscarDoctor(idPersona);
        if (p != null)
            return p;
        p = this.buscarCocinero(idPersona);
        if(p != null)
            return p;
        p = this.buscarAlbanil(idPersona);
        if(p != null)
            return p;
        p = this.buscarHerrero(idPersona);
        if(p != null)
            return p;
        p = this.buscarCarpintero(idPersona);
        if(p != null)
            return p;
        return p;
    }
    public void conducirBicicleta(Persona p){
        p.conducirBicicleta();
    }
    public void comprarBicicleta(Persona p, double precio){
        p.comprarBicicleta(precio);
    }
    public void venderBicicleta(Persona h, double precio){
        h.venderBicicleta(precio);
    }


    //Doctores
    public void crearDoctor(Doctor d) {
        listaDoctores.add(d);
    }
    public Doctor buscarDoctor(int idDoctor){
        for (Doctor d: listaDoctores){
            if (d.getId() == idDoctor)
                return d;
        }
        return null;
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
    public Cocinero buscarCocinero(int idCocinero){
        for (Cocinero c: listaCocineros){
            if (c.getId() == idCocinero)
                return c;
        }
        return null;
    }


    //Albaniles
    public void crearAlbanil(Albañil a){
        listaAlbaniles.add(a);
    }
    public void pagarConstruccionAlbanil(Albañil a){
        a.ganarDinero();
    }
    public Albañil buscarAlbanil(int idAlbanil){
        for (Albañil a: listaAlbaniles){
            if (a.getId() == idAlbanil)
                return a;
        }
        return null;
    }

    //Herreros
    public void crearHerrero(Herrero h){
        listaHerreros.add(h);
    }
    public void pagarConstruccionHerreros(Herrero h){
        h.ganarDinero();
    }
    public Herrero buscarHerrero(int idHerrero){
        for (Herrero h: listaHerreros){
            if (h.getId() == idHerrero)
                return h;
        }
        return null;
    }
    public void construirBicicleta(Herrero h, double precio){
        h.construirBicicleta(precio);
    }


    //Carpinteros
    public void crearCarpintero(Carpintero c){
        listaCarpinteros.add(c);
    }
    public void pagarConstruccionCarpintero(Carpintero c){
        c.ganarDinero();
    }
    public Carpintero buscarCarpintero (int idCarpintero){
        for (Carpintero c: listaCarpinteros){
            if (c.getId() == idCarpintero)
                return c;
        }
        return null;
    }

}

