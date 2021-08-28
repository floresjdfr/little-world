package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.logic.AdministrarValidaciones;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class AdministrarCreacionPersona extends Administrador {
    private AdministrarValidaciones validaciones;

    public AdministrarCreacionPersona(Mundo mundo) {
        super(mundo);
        validaciones = new AdministrarValidaciones(mundo);
    }

    public Boolean crearHerrero(int id, String nombre, String apellidos, Boolean salir) {
        if (validaciones.existeUsuario(id)){
            System.out.println("Persona con esa identificacion ya existe");
            return false;
        }

        try {

            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantHerr;

            try {
                cantHerr = super.getMundo().getListaHerreros().size() + 1;//Cantidad actual de herreros + el nuevo herrero
            } catch (Exception ex) {
                cantHerr = 1;
            }

            if (cantDoc >= cantHerr * 0.5) {
                super.getMundo().crearHerrero(new Herrero(id, nombre, apellidos, 3, 0,
                        new ArrayList<>(), new ArrayList<>()));

                validaciones.validacionesCreacion();
                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean crearAlbañil(int id, String nombre, String apellidos, Boolean salir) {

        if (validaciones.existeUsuario(id)){
            System.out.println("Persona con esa identificacion ya existe");
            return false;
        }

        try {

            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantCoc = super.getMundo().getListaCocineros().size();//Cantidad actual de cocineros
            int cantAlb;

            try {
                cantAlb = super.getMundo().getListaAlbaniles().size() + 1;//Cantidad actual de albañiles + el nuevo albañil
            } catch (Exception ex) {
                cantAlb = 1;
            }

            if (cantDoc >= cantAlb * 0.5 && cantCoc >= cantAlb * 0.5) {
                super.getMundo().crearAlbanil(new Albañil(id, nombre, apellidos, 2, 0, new ArrayList<>(),
                        new ArrayList<>()));

                validaciones.validacionesCreacion();
                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean crearCarpintero(int id, String nombre, String apellidos, Boolean salir) {

        if (validaciones.existeUsuario(id)){
            System.out.println("Persona con esa identificacion ya existe");
            return false;
        }

        try {
            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantCarp;

            try {
                cantCarp = super.getMundo().getListaCarpinteros().size() + 1;//Cantidad actual de carpinteros + el nuevo carpintero
            } catch (Exception ex) {
                cantCarp = 1;
            }

            if (cantDoc >= cantCarp) {
                super.getMundo().crearCarpintero(new Carpintero(id, nombre, apellidos, 4, 0,
                        new ArrayList<>(), new ArrayList<>()));

                validaciones.validacionesCreacion();
                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            return false;
        } catch (Exception ex) {
            System.err.println(ex.getStackTrace());
            return false;
        }
    }

    public void crearCocinero(int id, String nombre, String apellidos, String recetas, Boolean salir) {

        if (validaciones.existeUsuario(id)){
            System.out.println("Persona con esa identificacion ya existe");
            return;
        }

        String[] arrRecetas = recetas.toLowerCase(Locale.ROOT).split(",");
        ArrayList<String> listaRecetas = new ArrayList<>(Arrays.asList(arrRecetas));
        super.getMundo().crearCocinero(new Cocinero(id, nombre, apellidos, 0, 0,
                new ArrayList<>(), new ArrayList<>(), listaRecetas));

        validaciones.validacionesCreacion();
        validaciones.validarTodasOperaciones(salir);
    }

    public void agregarReceta(String receta) {

        //Verificar que receta no existe
        for (Cocinero c : super.getMundo().getListaCocineros()) {
            if (c.getRecetas().contains(receta.toLowerCase(Locale.ROOT))) {
                System.out.println("Receta no agregada porque ya existe en otro cocinero");
                return;
            }
        }

        Random rand = new Random();
        int cocineroRandom = rand.nextInt(super.getMundo().getListaCocineros().size());//Se elije un cocinero random de la lista
        Cocinero c = super.getMundo().getListaCocineros().get(cocineroRandom);
        super.getMundo().cocineroAgregarReceta(c, receta.toLowerCase(Locale.ROOT));
    }

    public String recetasNoDisponibles(String nuevaReceta) {
        String[] arrRecetas = nuevaReceta.toLowerCase(Locale.ROOT).split(",");
        for (Cocinero c : super.getMundo().getListaCocineros()) {
            for (String r : arrRecetas) {
                if (c.getRecetas().contains(r))
                    return r;
            }
        }
        return null;
    }

    public void crearDoctor(int id, String nombre, String apellidos, String especialidad, Boolean salir) {

        if (validaciones.existeUsuario(id)){
            System.out.println("Persona con esa identificacion ya existe");
            return;
        }

        Doctor nuevoDoctor = new Doctor(id, nombre, apellidos, 0, 0, new ArrayList<>(), new ArrayList<>(), especialidad);
        super.getMundo().crearDoctor(nuevoDoctor);

        validaciones.validacionesCreacion();
        validaciones.validarTodasOperaciones(salir);

    }

    public ArrayList<Doctor> getDoctores(){
        return super.getMundo().getListaDoctores();
    }
    public ArrayList<Cocinero> getCocineros(){
        return super.getMundo().getListaCocineros();
    }
    public ArrayList<Albañil> getAlbaniles(){
        return super.getMundo().getListaAlbaniles();
    }
    public ArrayList<Herrero> getHerreros(){
        return super.getMundo().getListaHerreros();
    }
    public ArrayList<Carpintero> getCarpinteros(){
        return super.getMundo().getListaCarpinteros();
    }


}

