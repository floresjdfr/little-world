package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Doctor;

import java.util.ArrayList;
import java.util.Random;

public class AdministrarDoctor extends Administrador {

    public AdministrarDoctor(Mundo mundo) {
        super(mundo);
    }

    public ArrayList<Doctor> getListaDeDoctores() {
        return super.getMundo().getListaDoctores();
    }

    public void crearDoctor(int id, String nombre, String apellidos, String especialidad) {

        Doctor nuevoDoctor = new Doctor(id, nombre, apellidos, 0, 0, new ArrayList<>(), new ArrayList<>(), especialidad);
        super.getMundo().crearDoctor(nuevoDoctor);

        super.getMundo().aumentarContadorCreacion();

        if (super.getMundo().getContadorCreacion() == 5) {//Por cada 5 operaciones de creacion las personas reciben 1 dolar
            super.getMundo().darDineroATodos(1);
            super.getMundo().resetCotnadorCreacion();
        }
    }
}


