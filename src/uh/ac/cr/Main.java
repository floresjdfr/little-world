package uh.ac.cr;

import uh.ac.cr.interfaz.*;
import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.Mundo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Boolean salir = false;
        Mundo mundo = null;
        Juego juego = null;
        InterfazJuego interfazJuego = null;
        InterfazPersonas interfazPersonas = null;

        String opcion = "";

        System.out.println("Juego Pequeño Mundo");
        while (!salir) {
            System.out.print("> ");
            opcion = input.nextLine();
            switch (opcion) {
                case "Salir": {
                    salir = true;
                    break;
                }
                case "Comenzar nuevo mundo": {
                    System.out.print("Nombre del nuevo mundo: ");
                    String nombreMundo = input.nextLine();
                    mundo = new Mundo(nombreMundo);
                    juego = new Juego(mundo);
                    interfazJuego = new InterfazJuego(juego);
                    interfazPersonas = new InterfazPersonas(juego);
                    break;
                }
                case "Crear doctor": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazPersonas.crearDoctor(salir);
                    break;
                }
                case "Crear cocinero": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazPersonas.crearCocinero(salir);
                    break;
                }
                case "Crear albañil": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazPersonas.crearAlbanil(salir);
                    break;
                }
                case "Crear herrero": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazPersonas.crearHerrero(salir);
                    break;
                }
                case "Crear carpintero": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazPersonas.crearCarpintero(salir);
                    break;
                }
                case "Sembrar arbol": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.sembrarArbol(salir);
                    break;
                }
                case "Construir casa": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.contruirCasa(salir);
                    break;
                }
                case "Construir bicicleta": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.construirBicicleta(salir);
                    break;
                }
                case "Comprar bicicleta": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.comprarBicicleta(salir);
                    break;
                }
                case "Conducir bicicleta": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.conducirBicicleta(salir);
                    break;
                }
                case "Construir automovil": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.construirAutomovil(salir);
                    break;
                }
                case "Comprar automovil": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.comprarAutomovil(salir);
                    break;
                }
                case "Conducir automovil": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.conducirAutomovil(salir);
                    break;
                }
                case "Solicitar prestamo": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.solicitarPrestamo(salir);
                    break;
                }
                case "Pagar prestamo": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.pagarPrestamo(salir);
                    break;
                }
                case "Imprimir estadisticas": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.imprimirEstadisticas();
                    break;
                }
                case "Ayuda":{
                    InterfazJuego.ayuda();
                    break;
                }
                case "Guardar mundo": {
                    if (mundo == null) {
                        System.out.println("Mundo no iniciado");
                        break;
                    }
                    interfazJuego.guardarMundo();
                    break;
                }
                default: {
                    Pattern p = Pattern.compile("Comenzar\smundo\s\\w+");
                    Matcher m = p.matcher(opcion);
                    if (m.matches()){
                        juego = new Juego(null);
                        interfazJuego = new InterfazJuego(juego);
                        mundo = interfazJuego.recuperarMundo(opcion);
                        if (mundo == null){
                            System.out.println("Mundo no existe");
                            break;
                        }
                        juego = new Juego(mundo);
                        interfazJuego = new InterfazJuego(juego);
                        interfazPersonas = new InterfazPersonas(juego);
                        break;
                    }
                    else{
                        System.out.println("Comando no reconocido.");
                        break;
                    }
                }


            }//End switch
        }//End while


    }
}


