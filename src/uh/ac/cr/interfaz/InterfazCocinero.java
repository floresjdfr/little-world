package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;


import java.util.Scanner;

public class InterfazCocinero extends Interfaz{
    public InterfazCocinero(Juego juego) {
        super(juego);
    }

    public void crearCocinero(){
        int id;
        String nombre;
        String apellidos;

        Scanner input = new Scanner(System.in);
        System.out.println("ID cocinero");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Nombre cocinero");
        nombre = input.nextLine();
        System.out.println("Apellidos cocinero");
        apellidos = input.nextLine();

        super.getJuego().crearCocinero(id, nombre, apellidos);

    }
    public void ganarDinero(){
        super.getJuego().ganarDinero();
    }
    public void agregarReceta(){
        Scanner input = new Scanner(System.in);
        String receta;
        System.out.print("Nombre de la receta: ");
        receta = input.nextLine();
        super.getJuego().agregarReceta(receta);
    }
}
