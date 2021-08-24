package uh.ac.cr.model.persona;

import java.util.ArrayList;
public class Herrero extends Persona {


    public Herrero(int id, String nombre, String apellidos, double dinero, double salario) {
        super(id, nombre, apellidos, dinero, salario);
    }

    public Herrero(int id) {
        super(id);
    }

    @Override
    public void ganarDinero() {
        super.setDinero(super.getDinero() + super.getSalario());
        this.perderDinero();
    }

    @Override
    public void perderDinero() {
        super.setDinero(super.getDinero() - 1);
    }

}
