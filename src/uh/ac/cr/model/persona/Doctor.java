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

    public Doctor(int id, String nombre, String apellidos, double dinero, int casas, Boolean personaSaludable, int contadorOperaciones5,
                  int contadorOperaciones10, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, String especialidad) {
        super(id, nombre, apellidos, dinero, casas, personaSaludable, contadorOperaciones5, contadorOperaciones10, vehiculos, prestamos);
        this.especialidad = especialidad;
    }

    @Override
    public String toFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<doctor>\n");
        stringBuilder.append(super.getId() + "\n");
        stringBuilder.append(super.getNombre() + "\n");
        stringBuilder.append(super.getApellidos() + "\n");
        stringBuilder.append(super.getDinero() + "\n");
        stringBuilder.append(super.getCasas() + "\n");
        stringBuilder.append(super.getPersonaSaludable() + "\n");
        stringBuilder.append(super.getContadorOperaciones5() + "\n");
        stringBuilder.append(super.getContadorOperaciones10() + "\n");
        stringBuilder.append("<vehiculos>\n");
        for (Vehiculo v: super.getVehiculos()){
            stringBuilder.append(v.toFile());
        }
        stringBuilder.append("<vehiculos>\n");
        stringBuilder.append("<prestamos>\n");
        for (Prestamo p: super.getPrestamos()){
            stringBuilder.append(p.toFile());
        }
        stringBuilder.append("<prestamos>\n");
        stringBuilder.append(especialidad + "\n");
        stringBuilder.append("<doctor>\n");
        return stringBuilder.toString();
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
