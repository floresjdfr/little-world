package uh.ac.cr.logic.persona;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Albañil;

import java.util.ArrayList;

public class AdministrarAlbañil extends Administrador {
    public AdministrarAlbañil(Mundo mundo) {
        super(mundo);
    }

    public Boolean crearAlbañil(int id, String nombre, String apellidos) {

        try {

            int cantDoc = super.getMundo().getListaDoctores().size();//Cantidad actual de doctores
            int cantCoc = super.getMundo().getListaCocineros().size();//Cantidad actual de cocineros
            int cantAlb;

            try {
                cantAlb = super.getMundo().getListaAlbaniles().size() + 1;//Cantidad actual de albañiles + el nuevo albañil
            }catch (Exception ex){
                cantAlb = 1;
            }

            if (cantDoc >= cantAlb * 0.5 && cantCoc >= cantAlb * 0.5) {
                super.getMundo().crearAlbanil(new Albañil(id, nombre, apellidos, 2, 0, new ArrayList<>(),
                        new ArrayList<>()));
                super.getMundo().aumentarContadorCreacion();

                if (super.getMundo().getContadorCreacion() == 5) {//Por cada 5 operaciones de creacion las personas reciben 1 dolar
                    super.getMundo().darDineroATodos(1);
                    super.getMundo().resetCotnadorCreacion();
                }
                return true;
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }

}
