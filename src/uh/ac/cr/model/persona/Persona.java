package uh.ac.cr.model.persona;
import uh.ac.cr.model.Prestamo;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
public abstract class Persona {
    private int Id;
    private String nombre;
    private String apellidos;
    private double dinero;
    private double salario;
    private int casas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Prestamo> prestamos;


    public Persona(int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dinero = dinero;
        this.salario = salario;
        this.casas = casas;
        this.vehiculos = vehiculos;
        this.prestamos = prestamos;
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
        return "Id:" + Id +
                "Nombre: " + nombre + '\n' +
                "Apellidos: " + apellidos + '\n' +
                "Dinero: " + dinero + '\n' +
                "Salario: " + salario + '\n' +
                "Casas: " + casas + '\n' +
                "Automoviles: " + this.getCantidadAutomoviles() + '\n' +
                "Bicicletas: " + this.getCantidadBicicletas() + '\n' +
                "Prestamos:" + prestamos.size() + '\n';
    }
    public int getCantidadBicicletas(){
        int counter = 0;
        for (Vehiculo v: this.vehiculos){
            if (v.getClass().getSimpleName().equals("Bicicleta"))
                counter++;
        }
        return counter;
    }
    public int getCantidadAutomoviles(){
        int counter = 0;
        for (Vehiculo v: this.vehiculos){
            if (v.getClass().getSimpleName().equals("Automovil"))
                counter++;
        }
        return counter;
    }
    public abstract void ganarDinero();
    public abstract void perderDinero();
}


