package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Carpintero;
import uh.ac.cr.model.persona.Herrero;

import java.util.ArrayList;

public class AdministrarCarpintero extends Administrador {
    public AdministrarCarpintero(Mundo mundo) {
        super(mundo);
    }
    public Boolean crearCarpintero(int id, String nombre, String apellidos){
        try {

            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantCarp;

            try {
                cantCarp = super.getMundo().getListaCarpinteros().size() + 1;//Cantidad actual de carpinteros + el nuevo carpintero
            }catch (Exception ex){
                cantCarp = 1;
            }

            if (cantDoc >= cantCarp) {
                super.getMundo().crearCarpintero(new Carpintero(id, nombre, apellidos, 4, 0,
                        new ArrayList<>(), new ArrayList<>()));
                super.getMundo().aumentarContadorCreacion();

                if (super.getMundo().getContadorCreacion() == 5) {//Por cada 5 operaciones de creacion las personas reciben 1 dolar
                    super.getMundo().darDineroATodos(1);
                    super.getMundo().resetCotnadorCreacion();
                }
                return true;
            }
            return false;
        }catch (Exception ex){
            System.err.println(ex.getStackTrace());
            return false;
        }


    }
}
