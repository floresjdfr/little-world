package uh.ac.cr.model.vehiculo;
public class Vehiculo {
    private int NumeroLlantas;
    private String Nombre;

    public Vehiculo(int llantas, String Nombre) {
        this.NumeroLlantas = llantas;
        this.Nombre = Nombre;

    }

    public int getNumeroLlantas() {
        return NumeroLlantas;
    }

    public String getNombre() {
        return Nombre;
    }


}
