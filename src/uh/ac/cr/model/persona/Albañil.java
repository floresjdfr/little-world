package uh.ac.cr.model.persona;

import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;

public class Albañil extends Persona {


    public Albañil(int id, String nombre, String apellidos, double dinero, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, casas, vehiculos, prestamos);
    }

    public Albañil(int id, String nombre, String apellidos, double dinero, int casas, Boolean personaSaludable, int contadorOperaciones5,
                   int contadorOperaciones10, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        super(id, nombre, apellidos, dinero, casas, personaSaludable, contadorOperaciones5, contadorOperaciones10, vehiculos, prestamos);
    }

    @Override
    public String toFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getId() + "\n");
        stringBuilder.append(super.getNombre() + "\n");
        stringBuilder.append(super.getApellidos() + "\n");
        stringBuilder.append(super.getDinero() + "\n");
        stringBuilder.append(super.getCasas() + "\n");
        stringBuilder.append(super.getPersonaSaludable() + "\n");
        stringBuilder.append(super.getContadorOperaciones5() + "\n");
        stringBuilder.append(super.getContadorOperaciones10() + "\n");
        for (Vehiculo v: super.getVehiculos()){
            v.toFile();
        }
        for (Prestamo p: super.getPrestamos()){
            p.toFile();
        }
        stringBuilder.append("/Albañil\n");
        return stringBuilder.toString();
    }

    @Override
    public void ganarDinero(double cantidad) {
        super.setDinero(super.getDinero() + cantidad);
    }
    @Override
    public void perderDinero(double cantidad) {
        super.setDinero(super.getDinero() - cantidad);
    }

}



