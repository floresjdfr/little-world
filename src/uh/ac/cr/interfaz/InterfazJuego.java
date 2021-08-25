package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.persona.*;

import java.util.Scanner;

public class InterfazJuego extends Interfaz{
    public InterfazJuego(Juego juego) {
        super(juego);
    }

    public void imprimirEstadisticas(){
        System.out.println("Estadisticas:");
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
}
