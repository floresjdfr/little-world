package uh.ac.cr.model.persona;


import java.util.ArrayList;

public class Cocinero extends Persona {

    public ArrayList<Cocinero> listaCocinero = new ArrayList<>();

    public Cocinero(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
    }


}