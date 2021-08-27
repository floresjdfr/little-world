package uh.ac.cr.model.persona;

import uh.ac.cr.model.prestamo.Prestamista;
import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Automovil;
import uh.ac.cr.model.vehiculo.Bicicleta;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;


public abstract class Persona implements Prestamista {
    private int Id;
    private String nombre;
    private String apellidos;
    private double dinero;
    private int casas;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Prestamo> prestamos;
    private Boolean permisoConducirBicicleta;


    public Persona(int id, String nombre, String apellidos, double dinero, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dinero = 50;
        this.casas = casas;
        this.vehiculos = vehiculos;
        this.prestamos = prestamos;
        this.permisoConducirBicicleta = false;
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

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Boolean getPermisoConducirBicicleta() {
        return permisoConducirBicicleta;
    }

    public void setPermisoConducirBicicleta(Boolean permisoConducirBicicleta) {
        this.permisoConducirBicicleta = permisoConducirBicicleta;
    }

    public abstract void ganarDinero(double cantidad);

    public abstract void perderDinero(double cantidad);

    @Override
    public String toString() {
        return "Id:" + Id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellidos: " + apellidos + '\n' +
                "Dinero: " + dinero + '\n' +
                "Casas: " + casas + '\n' +
                "Automoviles: " + this.getCantidadAutomoviles() + '\n' +
                "Bicicletas: " + this.getCantidadBicicletas() + '\n' +
                this.prestamosToString() + '\n';
    }

    String prestamosToString() {
        if (this.prestamos.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("----------------\n");
            stringBuilder.append("Prestamos\n");
            for (int i = 0; i < this.prestamos.size(); i++) {
                stringBuilder.append("\tPrestamo " + (i + 1) + "\n");
                stringBuilder.append("\tPrestamista: " + prestamos.get(i).getIdPrestamista() + "\n");
                stringBuilder.append("\tTotal del prestamo: " + prestamos.get(i).getTotalPrestamo() + "\n");
                stringBuilder.append("\tTotal pendiente: " + prestamos.get(i).getPendientePago() + "\n\n");
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public int getCantidadBicicletas() {
        int counter = 0;
        for (Vehiculo v : this.vehiculos) {
            if (v.getNombre().equals("Bicicleta"))
                counter++;
        }
        return counter;
    }

    public int getCantidadAutomoviles() {
        int counter = 0;
        for (Vehiculo v : this.vehiculos) {
            if (v.getNombre().equals("Automovil"))
                counter++;
        }
        return counter;
    }

    public void construirCasa(double costo) {
        dinero -= costo;
        casas++;
    }

    public void conducirBicicleta() {
        dinero += 0.1;
        permisoConducirBicicleta = false;
    }

    public void venderBicicleta(double precio) {
        dinero += precio;
        eliminarBicicleta();
    }

    public void eliminarBicicleta() {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getNombre() == "Bicicleta")
                this.vehiculos.remove(i);
        }
    }
    public void comprarBicicleta(double precio) {
        dinero -= precio;
        vehiculos.add(new Bicicleta());
    }
    public void construirAutomovil(double precio) {
        vehiculos.add(new Automovil());
        dinero -= precio;
    }
    @Override
    public void pagarPrestamo(int prestamista, double abono) {
        ArrayList<Prestamo> prestamosCopy = getPrestamos();

        for (int i = 0; i < prestamosCopy.size(); i++) {
            if (prestamosCopy.get(i).getIdPrestamista() == prestamista) {
                prestamosCopy.get(i).abonar(abono);
                if (!prestamosCopy.get(i).getEstado())//En caso que el prestamo sea pagado en su totalidad
                    prestamosCopy.remove(i);
            }
        }
    }
    @Override
    public void solicitarPrestamo(int prestamista, double total) {
        this.prestamos.add(new Prestamo(prestamista, this.getId(), total, total, true));
        this.dinero += total;
    }
    public void prestarDinero(double total) {
        dinero -= total;
    }
    public void recibirPagoPrestamo(double abono) {
        dinero += abono;
    }
}


