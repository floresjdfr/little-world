package uh.ac.cr.model.persona;

import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;

public class Carpintero extends Persona {


    public Carpintero(int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, salario, casas, vehiculos, prestamos);
    }
    @Override
    public void ganarDinero() {
        super.setDinero(super.getDinero() + super.getSalario());
    }

    @Override
    public void perderDinero() {

    }


}
