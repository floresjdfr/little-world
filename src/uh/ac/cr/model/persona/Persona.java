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
    private Boolean personaSaludable;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Prestamo> prestamos;
    private int contadorOperaciones5;
    private int contadorOperaciones10;


    public Persona(int id, String nombre, String apellidos, double dinero, int casas, Boolean personaSaludable,
                   int contadorOperaciones5, int contadorOperaciones10, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dinero = dinero;
        this.casas = casas;
        this.personaSaludable = personaSaludable;
        this.vehiculos = vehiculos;
        this.prestamos = prestamos;
        this.contadorOperaciones5 = contadorOperaciones5;
        this.contadorOperaciones10 = contadorOperaciones10;
    }

    public Persona(int id, String nombre, String apellidos, double dinero, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dinero = dinero;
        this.casas = casas;
        this.vehiculos = vehiculos;
        this.prestamos = prestamos;
        personaSaludable = true;
    }

    public abstract String toFile();

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

    public Boolean getPersonaSaludable() {
        return personaSaludable;
    }
    public void setPersonaSaludable(Boolean personaSaludable) {
        this.personaSaludable = personaSaludable;
    }

    public int getContadorOperaciones5() {
        return contadorOperaciones5;
    }

    public void setContadorOperaciones5(int contadorOperaciones5) {
        this.contadorOperaciones5 = contadorOperaciones5;
    }

    public int getContadorOperaciones10() {
        return contadorOperaciones10;
    }

    public void setContadorOperaciones10(int contadorOperaciones10) {
        this.contadorOperaciones10 = contadorOperaciones10;
    }

    public abstract void ganarDinero(double cantidad);

    public abstract void perderDinero(double cantidad);

    @Override
    public String toString() {
        return  "Id:" + Id + '\n' +
                "Nombre: " + nombre + '\n' +
                "Apellidos: " + apellidos + '\n' +
                "Estado de salud: " + (personaSaludable ? "Saludable" : "Enfermo") + '\n' +
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

    public Boolean conducirBicicleta() {
        /**
         * En caso de que alguna bicicleta este disponible para ser conducida, este metodo permite conducirla
         */
        for (Vehiculo v : vehiculos) {
            if (v.getNombre().equals("Bicicileta")) {
                if (v.getPuedeSerConducida()) {
                    v.conducir();
                    dinero += 0.1;
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean conducirAutomovil() {
        Vehiculo vehiculo = buscarVehiculoSinInteresesActivos();
        if (vehiculo != null){
            vehiculo.conducir();
            return true;
        }
        for (Vehiculo v : vehiculos) {
            if (v.getNombre().equals("Automovil")) {
                v.conducir();
                return true;
            }
        }
        return false;
    }

    Vehiculo buscarVehiculoSinInteresesActivos(){
        for (Vehiculo v : vehiculos){
            if (v.getNombre().equals("Automovil")) {
                if (!v.puedeGanarInteres())
                    return v;
            }
        }
        return null;
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

    public void agregarAutomovil() {
        vehiculos.add(new Automovil());
    }

    public void eliminarAutomovil() {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getNombre() == "Automovil")
                this.vehiculos.remove(i);
        }
    }

    @Override
    public void pagarPrestamo(int prestamista, double abono) {
        ArrayList<Prestamo> prestamosCopy = getPrestamos();

        for (int i = 0; i < prestamosCopy.size(); i++) {
            if (prestamosCopy.get(i).getIdPrestamista() == prestamista) {
                prestamosCopy.get(i).abonar(abono);
                if (!prestamosCopy.get(i).getEstado()) {//En caso que el prestamo sea pagado en su totalidad
                    prestamosCopy.remove(i);
                    if (prestamosCopy.size() == 0)
                        this.resetearContadorOperaciones10();
                }
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

    public void cambiarEstadoSalud(Boolean estado){
        this.personaSaludable = estado;
    }

    public void permitirConduccionBicicletas(){
        for (Vehiculo v: vehiculos){
            if (v.getNombre().equals("Bicicleta")){
                if (!v.getPuedeSerConducida())
                    v.setPuedeSerConducida(true);
            }
        }
    }
    public void aumentarContadorOperaciones5(){
        contadorOperaciones5++;
    }
    public void aumentarContadorOperaciones10(){
        contadorOperaciones10++;
    }
    public void resetearContadorOperaciones5(){
        contadorOperaciones5 = 0;
    }
    public void resetearContadorOperaciones10(){
        contadorOperaciones10 = 0;
    }
}


