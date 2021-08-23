package uh.ac.cr.model;
import java.util.ArrayList;

public class Albañil extends Persona {

    public ArrayList<Albañil> listaAlbañiles = new ArrayList<>();


    public Albañil(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
    }

    public Albañil(String nombreAlbañil) {
        super(nombreAlbañil);
    }}

