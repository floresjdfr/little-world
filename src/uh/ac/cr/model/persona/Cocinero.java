package uh.ac.cr.model.persona;


import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Persona {

    private ArrayList<String> recetas;

    public Cocinero(int id, String nombre, String apellidos, double dinero, double salario, ArrayList<String> recetas) {
        super(id, nombre, apellidos, dinero, salario);
        this.recetas = recetas;
    }

    public Cocinero(int id) {
        super(id);
    }
    public ArrayList<String> getRecetas() {
        return recetas;
    }
    public void setRecetas(ArrayList<String> recetas) {
        this.recetas = recetas;
    }
    @Override
    public void ganarDinero() {
        super.setDinero(super.getDinero() + super.getSalario());
    }
    @Override
    public void perderDinero() {

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