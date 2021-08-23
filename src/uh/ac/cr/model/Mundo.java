package uh.ac.cr.model;
import java.util.ArrayList;
import java.util.Iterator;
public class Mundo {
    private String name;

    private Gobierno gobierno;

    public Mundo(String name) {
        this.name = name;

        gobierno = null;
    }





    public Gobierno getGobierno() {
        return gobierno;
    }

    public void setGobierno(Gobierno gobierno) {
        this.gobierno = gobierno;
    }
}

