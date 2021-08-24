package uh.ac.cr.model.persona;
import java.util.ArrayList;
public abstract class Persona {
    private int Id;
    private String nombre;
    private String apellidos;
    private double dinero;
    private double salario;

    public Persona(int id, String nombre, String apellidos, double dinero, double salario) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dinero = dinero;
        this.salario = salario;
    }

    public Persona(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dinero=" + dinero +
                ", salario=" + salario +
                '}';
    }

    public abstract void ganarDinero();
    public abstract void perderDinero();
}


