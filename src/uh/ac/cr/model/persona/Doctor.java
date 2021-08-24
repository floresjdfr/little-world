package uh.ac.cr.model.persona;

import java.util.ArrayList;
public class Doctor extends Persona{

    private String especialidad;


    public Doctor(int id, String nombre, String apellidos, double dinero, double salario, String especialidad) {
        super(id, nombre, apellidos, dinero, salario);
        this.especialidad = especialidad;
    }

    public Doctor(int id) {
        super(id);
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
        return "Doctor{" +
                "especialidad='" + especialidad + '\'' + super.toString() + '\'' +
                '}';
    }
}
