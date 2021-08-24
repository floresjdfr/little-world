package uh.ac.cr.logic;

import jdk.jshell.spi.ExecutionControl;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Cocinero;
import uh.ac.cr.model.persona.Persona;

import java.util.ArrayList;
import java.util.Random;

public class AdministradorCocinero extends Administrador{
    public AdministradorCocinero(Mundo mundo) {
        super(mundo);
    }
    public void crearCocinero(int id, String nombre, String apellidos){
        ArrayList<String> recetas = new ArrayList<>();
        super.getMundo().crearCocinero(new Cocinero(id, nombre, apellidos, 0, 0.5, recetas));
    }
    public ArrayList<Cocinero> getCocineros(){
        return super.getMundo().getListaCocineros();
    }
    public void ganarDinero(){
        Random rand = new Random();
        int cocineroRandom = rand.nextInt(super.getMundo().getListaCocineros().size());//Se elije un cocinero random de la lista
        Cocinero c = super.getMundo().getListaCocineros().get(cocineroRandom);
        super.getMundo().cocineroGanarDinero(c);
    }
    public void agregarReceta(String receta){

        //Verificar que receta no existe
        for (Cocinero c: super.getMundo().getListaCocineros()){
            if (c.getRecetas().contains(receta)){
                System.out.println("Receta no agregada porque ya existe en otro cocinero");
                return;
            }
        }

        Random rand = new Random();
        int cocineroRandom = rand.nextInt(super.getMundo().getListaCocineros().size());//Se elije un cocinero random de la lista
        Cocinero c = super.getMundo().getListaCocineros().get(cocineroRandom);
        super.getMundo().cocineroAgregarReceta(c, receta);
    }
}
