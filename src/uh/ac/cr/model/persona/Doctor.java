package uh.ac.cr.model.persona;

import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
public class Doctor extends Persona{

    private String especialidad;


    public Doctor(int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, String especialidad) {
        super(id, nombre, apellidos, dinero, salario, casas, vehiculos, prestamos);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public void ganarDinero() {
        super.setDinero(super.getDinero() + super.getSalario());
    }
    @Override
    public void perderDinero() {
        super.setDinero(super.getDinero() - 3);
    }
    @Override
    public String toString() {
        return super.toString() +
                "Especialidad: " + especialidad + '\n';
    }
}
