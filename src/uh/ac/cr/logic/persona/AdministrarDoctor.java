package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.persona.Persona;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdministrarDoctor extends Administrador {

    public AdministrarDoctor(Mundo mundo) {
        super(mundo);
    }

    public ArrayList<Doctor> getListaDeDoctores() {
        return super.getMundo().getListaDoctores();
    }

    public void crearDoctor(int id, String nombre, String apellidos, String especialidad) {

        Doctor nuevoDoctor = new Doctor(id, nombre, apellidos, 0, 5, 0, new ArrayList<>(), new ArrayList<>(), especialidad);
        super.getMundo().crearDoctor(nuevoDoctor);

        super.getMundo().aumentarContadorCreacion();

        if (super.getMundo().getContadorCreacion() == 5) {//Por cada 5 operaciones de creacion las personas reciben 1 dolar
            super.getMundo().darDineroATodos(1);
            super.getMundo().resetCotnadorCreacion();
        }
    }

    public void ganarDinero() {
        Random rand = new Random();
        int doctorRandom = rand.nextInt(super.getMundo().getListaDoctores().size());//Se elije un doctor random de la lista

        Doctor doc = super.getMundo().getListaDoctores().get(doctorRandom); //Se obtiene el doctor random de la lista de doctores
        doc.ganarDinero();
    }
}


