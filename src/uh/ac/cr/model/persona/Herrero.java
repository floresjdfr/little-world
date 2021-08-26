package uh.ac.cr.model.persona;

import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.vehiculo.Bicicleta;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
public class Herrero extends Persona {


    public Herrero(int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, salario, casas, vehiculos, prestamos);
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

    public void construirBicicleta(double precio){
        super.setDinero(super.getDinero() - precio);
        super.getVehiculos().add(new Bicicleta());
    }



}
