package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class InterfazPersonas extends Interfaz{
    private Scanner input = new Scanner(System.in);
    public InterfazPersonas(Juego juego) {
        super(juego);
    }

    public void crearAlbanil(Boolean salir){

        int id = 0;

        String nombre = "";
        String apellidos = "";


        System.out.print("ID albañil: ");
        String supuestoID;
        supuestoID = input.nextLine();
        id = super.getJuego().esIntValido(supuestoID);
        if (id == -1){
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Nombre albañil: ");
        nombre = input.nextLine();
        System.out.print("Apellidos albañil: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearAlbanil(id, nombre, apellidos, salir))
            System.out.println("Debe crear mas doctores o mas cocineros para crear un albañil");
    }
    public void crearCarpintero(Boolean salir){

        int id = 0;
        String nombre = "";
        String apellidos = "";

        System.out.print("ID carpintero: ");
        String supuestoID;
        supuestoID = input.nextLine();
        id = super.getJuego().esIntValido(supuestoID);
        if (id == -1){
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Nombre carpintero: ");
        nombre = input.nextLine();
        System.out.print("Apellidos carpintero: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearCarpintero(id, nombre, apellidos, salir))
            System.out.println("Debe crear mas doctores para crear un carpintero");
    }
    public void crearCocinero(Boolean salir){
        int id = 0;
        String nombre = "";
        String apellidos = "";
        String recetas = "";


        System.out.print("ID cocinero: ");
        String supuestoID;
        supuestoID = input.nextLine();
        id = super.getJuego().esIntValido(supuestoID);
        if (id == -1){
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
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
        super.getJuego().crearCocinero(id, nombre, apellidos, recetas, salir);

    }
    public void crearDoctor(Boolean salir){
        int Id;
        String nombre;
        String apellidos;
        String especialidad;

        System.out.print("ID doctor: ");
        String supuestoID;
        supuestoID = input.nextLine();
        Id = super.getJuego().esIntValido(supuestoID);
        if (Id == -1){
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Nombre doctor: ");
        nombre = input.nextLine();
        System.out.print("Apellidos doctor: ");
        apellidos = input.nextLine();
        System.out.print("Especialidad doctor: ");
        especialidad = input.nextLine();
        //int id, String nombre, String apellidos, double dinero, double salario, int casas, ArrayList<Vehiculo> vehiculos, ArrayList<Prestamo> prestamos, String especialidad
        super.getJuego().crearDoctor(Id, nombre, apellidos, especialidad, salir);
    }
    public void crearHerrero(Boolean salir){

        int id = 0;
        String nombre = "";
        String apellidos = "";

        System.out.print("ID herrero: ");
        String supuestoID;
        supuestoID = input.nextLine();
        id = super.getJuego().esIntValido(supuestoID);
        if (id == -1){
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Nombre herrero: ");
        nombre = input.nextLine();
        System.out.print("Apellidos herrero: ");
        apellidos = input.nextLine();

        if (!super.getJuego().crearHerrero(id, nombre, apellidos, salir))
            System.out.println("Debe crear mas doctores para crear un herrero");
    }
}
