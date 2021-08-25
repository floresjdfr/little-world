package uh.ac.cr.logic.persona;

import jdk.jshell.spi.ExecutionControl;
import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.persona.Cocinero;
import uh.ac.cr.model.persona.Persona;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class AdministrarCocinero extends Administrador {
    public AdministrarCocinero(Mundo mundo) {
        super(mundo);
    }

    public void crearCocinero(int id, String nombre, String apellidos, String recetas){
        String[] arrRecetas = recetas.toLowerCase(Locale.ROOT).split(",");
        ArrayList<String> listaRecetas = new ArrayList<>(Arrays.asList(arrRecetas));
        super.getMundo().crearCocinero(new Cocinero(id, nombre, apellidos, 0, 0.5, 0,
                new ArrayList<>(), new ArrayList<>(), listaRecetas));
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
            if (c.getRecetas().contains(receta.toLowerCase(Locale.ROOT))){
                System.out.println("Receta no agregada porque ya existe en otro cocinero");
                return;
            }
        }

        Random rand = new Random();
        int cocineroRandom = rand.nextInt(super.getMundo().getListaCocineros().size());//Se elije un cocinero random de la lista
        Cocinero c = super.getMundo().getListaCocineros().get(cocineroRandom);
        super.getMundo().cocineroAgregarReceta(c, receta.toLowerCase(Locale.ROOT));
    }
    public String recetasNoDisponibles(String nuevaReceta){
        String[] arrRecetas = nuevaReceta.toLowerCase(Locale.ROOT).split(",");
        for (Cocinero c: super.getMundo().getListaCocineros()){
            for(String r: arrRecetas){
                if (c.getRecetas().contains(r))
                    return r;
            }
        }
        return null;
    }
}