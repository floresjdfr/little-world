package uh.ac.cr.model.vehiculo;
public class Vehiculo {

    private int NumeroLlantas;
    private String Nombre;
    private int cantVecesConducido;

    public Vehiculo(int numeroLlantas, String nombre, int cantVecesConducido) {
        NumeroLlantas = numeroLlantas;
        Nombre = nombre;
        this.cantVecesConducido = cantVecesConducido;
    }
    public int getNumeroLlantas() {
        return NumeroLlantas;
    }
    public void setNumeroLlantas(int numeroLlantas) {
        NumeroLlantas = numeroLlantas;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getCantVecesConducido() {
        return cantVecesConducido;
    }
    public void setCantVecesConducido(int cantVecesConducido) {
        this.cantVecesConducido = cantVecesConducido;
    }


}
