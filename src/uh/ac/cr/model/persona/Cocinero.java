package uh.ac.cr.model.persona;


import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Automovil;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;

public class Cocinero extends Persona {

    private ArrayList<String> recetas;

    public Cocinero(int id, String nombre, String apellidos, double dinero, int casas, ArrayList<Vehiculo>
            vehiculos, ArrayList<Prestamo> prestamos, ArrayList<String> recetas) {
        super(id, nombre, apellidos, dinero, casas, vehiculos, prestamos);
        this.recetas = recetas;
    }

    public Cocinero(int id, String nombre, String apellidos, double dinero, int casas, Boolean personaSaludable, int contadorOperaciones5,
                    int contadorOperaciones10, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, ArrayList<String> recetas) {
        super(id, nombre, apellidos, dinero, casas, personaSaludable, contadorOperaciones5, contadorOperaciones10, vehiculos, prestamos);
        this.recetas = recetas;
    }

    @Override
    public String toFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<cocinero>\n");
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
        String recetas2 = "";
        for (String s: recetas){
            recetas2 += s + ",";
        }
        stringBuilder.append(recetas2 + "\n");
        stringBuilder.append("<cocinero>\n");
        return stringBuilder.toString();
    }

    public ArrayList<String> getRecetas() {
        return recetas;
    }
    public void setRecetas(ArrayList<String> recetas) {
        this.recetas = recetas;
    }
    @Override
    public void ganarDinero(double cantidad) {
        super.setDinero(super.getDinero() + cantidad);
    }
    @Override
    public void perderDinero(double cantidad) {
        super.setDinero(super.getDinero() - cantidad);
    }
    public void agregarReceta(String nuevaReceta){
        recetas.add(nuevaReceta);
    }

    @Override
    public String toString() {
        return super.toString() +
                "recetas: " + recetas.toString();
    }

}