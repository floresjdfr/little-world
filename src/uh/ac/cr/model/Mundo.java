package uh.ac.cr.model;
import uh.ac.cr.model.persona.Doctor;

import java.util.ArrayList;
import java.util.Iterator;
public class Mundo {

    private String name;
    private Gobierno gobierno;
    private ArrayList<Doctor> listaDoctores;

    //Singleton

    private static Mundo mundo;

    private Mundo() {
        name = "";
        gobierno = null;
        listaDoctores = new ArrayList<>();
    }
    public static Mundo getInstance(){
        if (mundo == null)
            mundo = new Mundo();
        return mundo;
    }

    //---------------

    public Gobierno getGobierno() {
        return gobierno;
    }

    public void setGobierno(Gobierno gobierno) {
        this.gobierno = gobierno;
    }


    //Doctores

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }
    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }
    public void crearDoctor(Doctor d){
        listaDoctores.add(d);
    }




}

