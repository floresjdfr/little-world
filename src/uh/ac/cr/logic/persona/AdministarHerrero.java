package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Herrero;

import java.util.ArrayList;

public class AdministarHerrero extends Administrador {
    public AdministarHerrero(Mundo mundo) {
        super(mundo);
    }
    public Boolean crearHerrero(int id, String nombre, String apellidos){

        try {

            if(super.getMundo().getContadorCreacion() == 5){//Por cada 5 operaciones de creacion las personas reciben 1 dolar
                super.getMundo().darDineroATodos(1);
                super.getMundo().resetCotnadorCreacion();
            }

            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantCoc = super.getMundo().getListaCocineros().size();//Cantidad actual de cocineros
            int cantHerr;

            try {
                cantHerr = super.getMundo().getListaHerreros().size() + 1;//Cantidad actual de herreros + el nuevo herrero
            }catch (Exception ex){
                cantHerr = 1;
            }

            if (cantDoc >= cantHerr * 0.5 && cantCoc >= cantHerr * 0.5) {
                super.getMundo().crearHerrero(new Herrero(id, nombre, apellidos, 3, 3, 0,
                        new ArrayList<>(), new ArrayList<>()));
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }

    }
}
