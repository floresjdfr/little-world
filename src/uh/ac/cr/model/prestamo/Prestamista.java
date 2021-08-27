package uh.ac.cr.model.prestamo;

import uh.ac.cr.model.persona.Persona;

public interface Prestamista {
    void solicitarPrestamo (int idPrestamista, double total);
    void pagarPrestamo(int idPrestamista, double abono);
}
