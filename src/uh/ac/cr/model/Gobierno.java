package uh.ac.cr.model;
public class Gobierno {

    private double CapitalEconomico;

    public Gobierno(double capitalEconomico) {
        CapitalEconomico = capitalEconomico;
    }
    public double getCapitalEconomico() {
        return CapitalEconomico;
    }
    public void setCapitalEconomico(double capitalEconomico) {
        CapitalEconomico = capitalEconomico;
    }

    public void sembrarArbol(){
         this.CapitalEconomico -= 0.5;
    }

}
