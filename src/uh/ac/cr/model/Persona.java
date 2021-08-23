package uh.ac.cr.model;
import java.util.ArrayList;
public abstract class Persona {
    private String nombre;
    private String apellidos;
    private int Id;

    public Persona(String nombre, String apellidos, int id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        Id = id;
    }

    public Persona() {

    }

    public abstract class administrarDinero {
    }

    public Persona(String nombreHerrero) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}


