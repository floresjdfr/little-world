package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.persona.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfazDoctor extends Interfaz{

    public InterfazDoctor(Juego juego) {
        super(juego);
    }

    public void crearDoctor(){
        int Id;
        String nombre;
        String apellidos;
        String especialidad;
        Scanner input = new Scanner(System.in);
        System.out.println("ID doctor");
        Id = input.nextInt();
        input.nextLine();
        System.out.println("Nombre doctor");
        nombre = input.nextLine();
        System.out.println("Apellidos doctor");
        apellidos = input.nextLine();
        System.out.println("Especialidad doctor");
        especialidad = input.nextLine();
        //int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, String especialidad
        super.getJuego().crearDoctor(Id, nombre, apellidos, especialidad);
    }
    public void imprimirDoctores(){
        System.out.println("Lista de doctores");
        ArrayList<Doctor> docs = super.getJuego().getDoctores();
        for (int i = 0; i < docs.size(); i++){
            System.out.println("Doctor No: " + (i+1) + docs.get(i));
        }
    }
}
