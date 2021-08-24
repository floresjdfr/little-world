package uh.ac.cr.logic;

import uh.ac.cr.interfaz.InterfazDoctor;
import uh.ac.cr.model.persona.Doctor;

import java.util.ArrayList;

public class Juego {

    private static Juego juego;
    private Juego(){
        adminDoctor = new AdministrarDoctor();
    }
    public static Juego getInstance(){
        if (juego == null)
            juego = new Juego();
        return juego;
    }

    private AdministrarDoctor adminDoctor;

    //Doctores

    public void crearDoctor(int id, String nombre, String apellidos, double dinero, double salario, String especialidad){
        adminDoctor.crearDoctor(id, nombre, apellidos, dinero, salario, especialidad);
    }

    public ArrayList<Doctor> obtenerDoctores(){
        return adminDoctor.obtenerDoctores();
    }
}
