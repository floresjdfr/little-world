package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;

import java.util.Scanner;

public class InterfazCarpintero extends Interfaz{
    public InterfazCarpintero(Juego juego) {
        super(juego);
    }
    public void crearCarpintero(){

        int id = 0;
        String nombre = "";
        String apellidos = "";

        Scanner input = new Scanner(System.in);
        System.out.print("ID carpintero: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Nombre carpintero: ");
        nombre = input.nextLine();
        System.out.print("Apellidos carpintero: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearCarpintero(id, nombre, apellidos))
            System.out.println("Debe crear mas doctores para crear un carpintero");
    }
}
