package uh.ac.cr.model.persona;


import java.util.ArrayList;
import java.util.List;

public class Cocinero extends Persona {

    private List<String> recetas;

    public Cocinero(int id, String nombre, String apellidos, double dinero, double salario, List<String> recetas) {
        super(id, nombre, apellidos, dinero, salario);
        this.recetas = recetas;
    }

    public Cocinero(int id) {
        super(id);
    }
    public List<String> getRecetas() {
        return recetas;
    }
    public void setRecetas(List<String> recetas) {
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
}