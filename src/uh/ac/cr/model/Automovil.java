package uh.ac.cr.model;
import java.util.ArrayList;
public class Automovil extends Vehiculo{

    public ArrayList<Automovil> listaAutomovil= new ArrayList<>();


    public Automovil(int llantas, String Nombre) {
        super(llantas, Nombre);
    }


}
