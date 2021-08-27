package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.persona.*;

import java.util.Scanner;

public class InterfazJuego extends Interfaz{
    public InterfazJuego(Juego juego) {
        super(juego);
    }

    public void imprimirEstadisticas(){
        System.out.println("Nombre del mundo: " + super.getJuego().getNombreMundo());
        System.out.println("Cantidad arboles: " + super.getJuego().getArboles());

        if(super.getJuego().getDoctores().size() > 0){
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Doctores");
            System.out.print("\n");
        }
        for(Doctor d : super.getJuego().getDoctores()){
            System.out.println(d.toString());
        }

        if(super.getJuego().getCocineros().size() > 0){
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Cocineros");
            System.out.print("\n");
        }
        for(Cocinero c : super.getJuego().getCocineros()){
            System.out.println(c.toString());
        }

        if(super.getJuego().getAlbaniles().size() > 0){
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Albañiles");
            System.out.print("\n");
        }
        for(Albañil a : super.getJuego().getAlbaniles()){
            System.out.println(a.toString());
        }

        if(super.getJuego().getHerreros().size() > 0){
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Herreros");
            System.out.print("\n");
        }
        for(Herrero h : super.getJuego().getHerreros()){
            System.out.println(h.toString());
        }

        if(super.getJuego().getCarpinteros().size() > 0){
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Carpinteros");
            System.out.print("\n");
        }
        for(Carpintero c : super.getJuego().getCarpinteros()){
            System.out.println(c.toString());
        }
    }
    public void sembrarArbol(){
        if (super.getJuego().sembrarArbol()){
            System.out.println("Arbol sembrado");
            return;
        }
        System.out.println("Gobierno no dispone de dinero para sembrar un arbol");
    }
    public void contruirCasa(){
        Scanner input = new Scanner(System.in);
        int idPersona;
        System.out.print("Digite la identificacion de persona que construirá casa: ");
        idPersona = input.nextInt();
        input.nextLine();

        if (super.getJuego().construirCasa(idPersona)){
            System.out.println("Casa construida");
            return;
        }
        System.out.println("Casa no pudo ser construida");
    }
    public void construirBicicleta(){
        int idHerreroConstructor;
        Scanner input = new Scanner(System.in);


        System.out.print("Identificacion de herrero constructor: ");
        idHerreroConstructor = input.nextInt();
        input.nextLine();

        super.getJuego().construirBicicleta(idHerreroConstructor);
    }
    public void comprarBicicleta(){

        Scanner input = new Scanner(System.in);

        int idComprador;
        int idVendedor;

        System.out.print("Identificacion del comprador: ");
        idComprador = input.nextInt();
        input.nextLine();

        System.out.print("Identificacion del vendedor: ");
        idVendedor = input.nextInt();
        input.nextLine();

        super.getJuego().comprarBicicleta(idComprador, idVendedor);
    }
    public void solicitarPrestamo(){
        Scanner input = new Scanner(System.in);

        String interesado;
        int idPrestamista;
        double cantidadPrestamo;

        System.out.print("Identificacion del prestamista: ");
        idPrestamista = input.nextInt();
        input.nextLine();
        System.out.print("Identificacion del interesado, en caso de ser el gobierno escriba 'Gobierno': ");
        interesado = input.nextLine();
        System.out.print("Cantidad de dinero a solicitar: ");
        cantidadPrestamo = input.nextDouble();
        input.nextLine();

        super.getJuego().solicitarPrestamo(idPrestamista, interesado, cantidadPrestamo);
    }
    public void pagarPrestamo(){
        Scanner input = new Scanner(System.in);

        int idPrestamista;
        String idPagador;
        double cantidadAPagar;

        System.out.print("Identificacion del prestamista: ");
        idPrestamista = input.nextInt();
        input.nextLine();
        System.out.print("Identificacion del pagador, en caso de ser el gobierno escriba 'Gobierno': ");
        idPagador = input.nextLine();
        System.out.print("Cantidad a pagar: ");
        cantidadAPagar = input.nextDouble();
        input.nextLine();

        super.getJuego().pagarPrestamo(idPrestamista, idPagador, cantidadAPagar);
    }
}
