package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.persona.Cocinero;
import uh.ac.cr.model.persona.Doctor;

public class InterfazJuego extends Interfaz{
    public InterfazJuego(Juego juego) {
        super(juego);
    }
    public void imprimirEstadisticas(){
        System.out.println("Estadisticas:");
        System.out.println("Nombre del mundo: " + super.getJuego().getNombreMundo());
        System.out.println("--------------------------------------");
        System.out.println("Doctores");
        System.out.print("\n");

        for(Doctor d : super.getJuego().getDoctores()){
            System.out.println(d.toString());
        }
        System.out.print("\n");
        System.out.println("--------------------------------------");
        System.out.println("Cocineros");
        for(Cocinero c : super.getJuego().getCocineros()){
            System.out.println(c.toString());
        }
        System.out.print("\n");
    }
}
