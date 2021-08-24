package uh.ac.cr.logic;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.persona.Persona;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdministrarDoctor extends Administrador{

    public AdministrarDoctor(Mundo mundo) {
        super(mundo);
    }
    public ArrayList<Doctor> getListaDeDoctores() {
        return super.getMundo().getListaDoctores();
    }
    public void crearDoctor(int id, String nombre, String apellidos, double dinero, double salario, String especialidad){
        Doctor nuevoDoctor = new Doctor(id, nombre, apellidos, dinero, 5, especialidad);
        super.getMundo().crearDoctor(nuevoDoctor);
    }
    public void ganarDinero(){
        Random rand = new Random();
        int doctorRandom = rand.nextInt(super.getMundo().getListaDoctores().size());//Se elije un doctor random de la lista

        Doctor doc = super.getMundo().getListaDoctores().get(doctorRandom); //Se obtiene el doctor random de la lista de doctores
        doc.ganarDinero();
    }
}


