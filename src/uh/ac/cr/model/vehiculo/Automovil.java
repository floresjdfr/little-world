package uh.ac.cr.model.vehiculo;

public class Automovil extends Vehiculo {
    private boolean puedeGanarInteres;

    public Automovil() {
        super(4, "Automovil");
        puedeGanarInteres = true;
    }

    public Automovil(int numeroLlantas, String nombre, boolean puedeGanarInteres) {
        super(numeroLlantas, nombre);
        this.puedeGanarInteres = puedeGanarInteres;
    }

    @Override
    public String toFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getNumeroLlantas() + "\n");
        stringBuilder.append(super.getNombre() + "\n");
        stringBuilder.append(puedeGanarInteres + "\n");
        stringBuilder.append("/Automovil\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean puedeGanarInteres() {
        return puedeGanarInteres;
    }

    @Override
    public void setPuedeSerConducida(Boolean puedeSerConducida) {
    }

    public void setPuedeGanarInteres(boolean puedeGanarInteres) {
        this.puedeGanarInteres = puedeGanarInteres;
    }

    @Override
    public void conducir() {
        puedeGanarInteres = true;
    }

    @Override
    public Boolean getPuedeSerConducida() {
        return null;
    }
}
