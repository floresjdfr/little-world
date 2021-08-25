package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;

import java.util.Scanner;

public class InterfazHerrero extends Interfaz{
    public InterfazHerrero(Juego juego) {
        super(juego);
    }
    public void crearHerrero(){

        int id = 0;
        String nombre = "";
        String apellidos = "";

        Scanner input = new Scanner(System.in);
        System.out.print("ID herrero: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Nombre herrero: ");
        nombre = input.nextLine();
        System.out.print("Apellidos herrero: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearHerrero(id, nombre, apellidos))
            System.out.println("Debe crear mas doctores para crear un herrero");
    }
}
