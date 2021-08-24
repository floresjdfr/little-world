package uh.ac.cr;
import uh.ac.cr.interfaz.InterfazDoctor;
import uh.ac.cr.logic.AdministradorMundo;
import uh.ac.cr.logic.Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) {

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AdministradorMundo administradorMundo = new AdministradorMundo();



        boolean userWantsToExit = false;
        while (!userWantsToExit) {

            System.out.println("Escriba el comando. Para instrucciones escriba Ayuda.");
            String command = "";

            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch(command)
            {
                case "Ayuda":
                    System.out.println("Comando: Ayuda.");
                    System.out.println(
                                    "Crear mundo: Se solicita el nombre del mundo. \n" +
                                    "Comenzar mundo: Se buscará el archivo que contenga el mundo guardado. \n" +
                                    "Crear doctor: Solicita los datos personales. \n" +
                                    "Crear cocinero: Solicita los datos personales. \n" +
                                    "Crear albañil: Solicita los datos personales. Por cada albañil deben existir 0,5 doctores y 0,5 cocineros. \n" +
                                    "Crear herrero: Solicita los datos personales. Por cada herrero deben existir 0,5 doctores. \n" +
                                    "Crear carpintero: Solicita los datos personales. Por cada carpintero debe existir un doctor. \n" +
                                    "Construir casa: Deben existir 2 carpinteros, 3 albañiles y 1 herrero. \n" +
                                    "Sembrar árbol: Tiene un costo de 0,5 dólares. Cada 10 operaciones mueren 5 árboles. \n" +
                                    "Construir bicicleta: Deben existir herreros. Tiene un costo un dólar. \n" +
                                    "Comprar bicicleta: Tiene un costo de 3 dólares. Se puede conducir cada 5 operaciones. \n" +
                                    "Conducir bicicleta: Sólo puede ser conducida por su dueño. Debe mantener el balance y pedalear de manera continua. \n"+
                                    "Construir automóvil: Deben existir 1 carpintero y 1 doctor. Ambos deben tener en 10 dólares en conjunto para pagar 5 al gobierno en impuestos, 2 al herrero en materiales, y 3 al cocinero en alimentación. \n" +
                                    "Comprar automóvil: Tiene un costo de 25 dólares. Por cada 10 operaciones en el mundo, el dueño gana 2 dólares en intereses. \n" +
                                    "Conducir automóvil: Sólo puede ser conducido por su dueño. Por cada conducción mueren 3 árboles. Debe ser conducido luego de ganar intereses para empezar a generarlos de nuevo. \n" +
                                    "Solicitar préstamo: Una persona debe pagar su préstamo en menos de 10 operaciones propias o morirá. Una persona puede tener 2 préstamos simultáneamente. \n" +
                                    "Imprimir estadísticas: Muestra información del estado del mundo. \n" +
                                    "Guardar mundo: Guarda la partida con el estado actual del mundo en un archivo .txt. \n" +
                                    "Salir: Terminar la ejecución del mundo. \n"
                    );
                    break;
                case "Exit":
                    System.out.println("Exit.");
                    userWantsToExit = true;
                    break;
                default:
                    AdministradorMundo.handleCommand(command);
            }

        }

         */
        Juego juego = Juego.getInstance();
        InterfazDoctor interfazDoctor = new InterfazDoctor();

        interfazDoctor.crearDoctor();
        interfazDoctor.crearDoctor();
        interfazDoctor.imprimirDoctores();



    }
}


