package uh.ac.cr.model;

import uh.ac.cr.model.prestamo.Prestamista;
import uh.ac.cr.model.prestamo.Prestamo;

import java.util.ArrayList;

public class Gobierno implements Prestamista {

    private double capitalEconomico;
    private ArrayList<Prestamo> prestamos;

    public Gobierno(double capitalEconomico, ArrayList<Prestamo> prestamos) {
        this.capitalEconomico = capitalEconomico;
        this.prestamos = prestamos;
    }

    public double getCapitalEconomico() {
        return capitalEconomico;
    }
    public void setCapitalEconomico(double capitalEconomico) {
        this.capitalEconomico = capitalEconomico;
    }
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }


    public void sembrarArbol(){
        this.capitalEconomico -= 0.5;
    }
    @Override
    public void solicitarPrestamo(int idPrestamista, double total) {
        this.prestamos.add(new Prestamo(idPrestamista, -1, total, total, true));
        this.capitalEconomico += total;
    }
    @Override
    public void pagarPrestamo(int idPrestamista, double abono) {
        for (int i = 0; i < this.prestamos.size(); i++) {
            if (this.prestamos.get(i).getIdPrestamista() == idPrestamista) {
                this.prestamos.get(i).abonar(abono);
                this.capitalEconomico -= abono;
                if (!this.prestamos.get(i).getEstado())//En caso que el prestamo sea pagado en su totalidad
                    this.prestamos.remove(i);
            }
        }

    }
    String prestamosToString() {
        if (this.prestamos.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("\tPrestamos\n");
            for (int i = 0; i < this.prestamos.size(); i++) {
                stringBuilder.append("\t\tPrestamo " + (i + 1) + "\n");
                stringBuilder.append("\t\tPrestamista: " + prestamos.get(i).getIdPrestamista() + "\n");
                stringBuilder.append("\t\tTotal del prestamo: " + prestamos.get(i).getTotalPrestamo() + "\n");
                stringBuilder.append("\t\tTotal pendiente: " + prestamos.get(i).getPendientePago() + "\n\n");
            }
            return stringBuilder.toString();
        }
        return "";
    }
    @Override
    public String toString() {
        return "Informacion del gobierno" + "\n" +
                "\tCapital economico: " + capitalEconomico + "\n" +
                this.prestamosToString();
    }
}
