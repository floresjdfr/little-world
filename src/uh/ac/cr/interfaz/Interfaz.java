package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;

public class Interfaz {
    private Juego juego;

    public Interfaz(Juego juego) {
        this.juego = juego;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
