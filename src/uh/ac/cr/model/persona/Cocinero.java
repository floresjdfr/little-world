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