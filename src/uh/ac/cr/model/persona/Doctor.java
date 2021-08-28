package uh.ac.cr.model.persona;

import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Automovil;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;

public class Doctor extends Persona {

    private String especialidad;

    public Doctor(int id, String nombre, String apellidos, double dinero,  int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, String especialidad) {
        super(id, nombre, apellidos, dinero, casas, vehiculos, prestamos);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    @Override
    public void ganarDinero(double cantidad) {
        super.setDinero(super.getDinero() + cantidad);
    }
    @Override
    public void perderDinero(double cantidad) {
        super.setDinero(super.getDinero() - cantidad);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Especialidad: " + especialidad + '\n';
    }



}
