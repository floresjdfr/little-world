package uh.ac.cr.model.persona;

import java.util.ArrayList;

public class Carpintero extends Persona {


    public Carpintero(int id, String nombre, String apellidos, double dinero, double salario) {
        super(id, nombre, apellidos, dinero, salario);
    }

    public Carpintero(int id) {
        super(id);
    }

    @Override
    public void ganarDinero() {
        super.setDinero(super.getDinero() + super.getSalario());
    }

    @Override
    public void perderDinero() {

    }


}
