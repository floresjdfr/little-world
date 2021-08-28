package uh.ac.cr.model.persona;

import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Bicicleta;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
public class Herrero extends Persona {


    public Herrero(int id, String nombre, String apellidos, double dinero, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, casas, vehiculos, prestamos);
    }

    public Herrero(int id, String nombre, String apellidos, double dinero, int casas, Boolean personaSaludable, int contadorOperaciones5,
                   int contadorOperaciones10, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, casas, personaSaludable, contadorOperaciones5, contadorOperaciones10, vehiculos, prestamos);
    }

    @Override
    public void ganarDinero(double cantidad) {
        super.setDinero(super.getDinero() + cantidad);
    }
    @Override
    public void perderDinero(double cantidad) {
        super.setDinero(super.getDinero() - cantidad);
    }

    public void construirBicicleta(double precio){
        super.setDinero(super.getDinero() - precio);
        super.getVehiculos().add(new Bicicleta());
    }



}
