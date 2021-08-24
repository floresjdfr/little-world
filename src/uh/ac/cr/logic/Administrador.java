package uh.ac.cr.logic;

import uh.ac.cr.model.Mundo;

public class Administrador {

    private Mundo mundo;

    public Administrador(Mundo mundo) {
        this.mundo = mundo;
    }
    public Mundo getMundo() {
        return mundo;
    }
    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }
}
