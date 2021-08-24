package uh.ac.cr.logic;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.persona.Persona;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdministrarDoctor{

    private static Mundo mundo;

    public AdministrarDoctor() {
        mundo = Mundo.getInstance();
    }

    public ArrayList<Doctor> getListaDeDoctores() {
        return mundo.getListaDoctores();
    }

    public void crearDoctor(int id, String nombre, String apellidos, double dinero, double salario, String especialidad){
        Doctor nuevoDoctor = new Doctor(id, nombre, apellidos, dinero, salario, especialidad);
        mundo.crearDoctor(nuevoDoctor);
    }

    /*
    El parametro 'id' identifica al doctor que va a ganar dinero
     */
    public void ganarDinero(){
        Random rand = new Random();
        int doctorRandom = rand.nextInt(mundo.getListaDoctores().size());//Se elije un doctor random de la lista

        Doctor doc = mundo.getListaDoctores().get(doctorRandom); //Se obtiene el doctor random de la lista de doctores
        doc.ganarDinero();

    }

    public ArrayList<Doctor> obtenerDoctores(){
        return mundo.getListaDoctores();
    }
}


