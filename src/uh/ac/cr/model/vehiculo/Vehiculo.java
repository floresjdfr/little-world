package uh.ac.cr.model.vehiculo;
public abstract class Vehiculo {

    private int NumeroLlantas;
    private String Nombre;

    public Vehiculo(int numeroLlantas, String nombre) {
        NumeroLlantas = numeroLlantas;
        Nombre = nombre;
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
    public abstract void conducir();
    public abstract Boolean getPuedeSerConducida();
    public abstract void setPuedeSerConducida(Boolean puedeSerConducida);
    public abstract void setPuedeGanarInteres(boolean puedeGanarInteres);
    public abstract boolean puedeGanarInteres();


}
