package uh.ac.cr.model.vehiculo;

public class Bicicleta extends Vehiculo{

    private Boolean puedeSerConducida;

    public Bicicleta() {
        super(2, "Bicicleta");
        puedeSerConducida = false;
    }

    //Metodos no utilizados
    @Override
    public boolean puedeGanarInteres() {
        return false;
    }
    @Override
    public void setPuedeGanarInteres(boolean puedeGanarInteres) {}


    //Metodos utiles
    public void setPuedeSerConducida(Boolean puedeSerConducida) {
        this.puedeSerConducida = puedeSerConducida;
    }
    @Override
    public Boolean getPuedeSerConducida() {
        return puedeSerConducida;
    }
    @Override
    public void conducir() {
        System.out.println("Conducción de bicicleta: debe mantener el balance y pedalear de manera continua");
        puedeSerConducida = false;
    }
}
