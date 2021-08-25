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
                super.getMundo().crearCarpintero(new Carpintero(id, nombre, apellidos, 0, 4, 0,
                        new ArrayList<>(), new ArrayList<>()));
                return true;
            }
            return false;
        }catch (Exception ex){
            System.err.println(ex.getStackTrace());
            return false;
        }
    }
}
