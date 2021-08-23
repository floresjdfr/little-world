package uh.ac.cr.model;

import java.util.ArrayList;

public class Carpintero extends Persona{


    public ArrayList<Carpintero> listaCarpintero = new ArrayList<>();

    public Carpintero (String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
    }

    public Carpintero(String nombreCarpintero) {
        super(nombreCarpintero);



    }



}
