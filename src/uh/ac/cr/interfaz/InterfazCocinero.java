package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;


import java.util.Scanner;

public class InterfazCocinero extends Interfaz{
    public InterfazCocinero(Juego juego) {
        super(juego);
    }

    public void crearCocinero(){
        int id = 0;
        String nombre = "";
        String apellidos = "";
        String recetas = "";

        Scanner input = new Scanner(System.in);
        System.out.print("ID cocinero: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Nombre cocinero: ");
        nombre = input.nextLine();
        System.out.print("Apellidos cocinero: ");
        apellidos = input.nextLine();

        Boolean recetaCompeta = false;
        while(!recetaCompeta){
            System.out.print("Recetas del cocinero (escriba las recetas separadas por ','): ");
            recetas = input.nextLine();
            String recetaNoDisponible = super.getJuego().recetasNoDisponibles(recetas);
            if (recetaNoDisponible != null)
                System.out.println("Error: Receta " + recetaNoDisponible + " ya es realizada por otro cocinero");
            else
                recetaCompeta = true;
        }
        super.getJuego().crearCocinero(id, nombre, apellidos, recetas);

    }
    public void agregarReceta(){
        Scanner input = new Scanner(System.in);
        String receta;
        System.out.print("Nombre de la receta: ");
        receta = input.nextLine();
        super.getJuego().agregarReceta(receta);
    }
}
