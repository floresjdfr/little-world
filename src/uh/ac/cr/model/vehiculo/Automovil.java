package uh.ac.cr.model.vehiculo;

public class Automovil extends Vehiculo{
    private boolean puedeGanarInteres;
    public Automovil() {
        super(4, "Automovil");
        puedeGanarInteres = true;
    }
    @Override
    public boolean puedeGanarInteres() {
        return puedeGanarInteres;
    }

    @Override
    public void setPuedeSerConducida(Boolean puedeSerConducida) {}

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
