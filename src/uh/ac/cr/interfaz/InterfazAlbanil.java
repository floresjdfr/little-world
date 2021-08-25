package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;

import java.util.Scanner;

public class InterfazAlbanil extends Interfaz{
    public InterfazAlbanil(Juego juego) {
        super(juego);
    }
    public void crearAlbanil(){

        int id = 0;
        String nombre = "";
        String apellidos = "";

        Scanner input = new Scanner(System.in);
        System.out.print("ID albañil: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Nombre albañil: ");
        nombre = input.nextLine();
        System.out.print("Apellidos albañil: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearAlbanil(id, nombre, apellidos))
            System.out.println("Debe crear mas doctores o mas cocineros para crear un albañil");
    }
}
