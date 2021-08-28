package uh.ac.cr.interfaz;

import uh.ac.cr.logic.Juego;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.*;

import java.util.Scanner;

public class InterfazJuego extends Interfaz {

    private Scanner input;

    public InterfazJuego(Juego juego) {
        super(juego);
        input = new Scanner(System.in);
    }

    public void imprimirEstadisticas() {
        System.out.println("Nombre del mundo: " + super.getJuego().getNombreMundo());
        System.out.println("Cantidad arboles: " + super.getJuego().getArboles());
        System.out.println(super.getJuego().imprimirGobierno());

        if (super.getJuego().getDoctores().size() > 0) {
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Doctores");
            System.out.print("\n");
        }
        for (Doctor d : super.getJuego().getDoctores()) {
            System.out.println(d.toString());
        }

        if (super.getJuego().getCocineros().size() > 0) {
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Cocineros");
            System.out.print("\n");
        }
        for (Cocinero c : super.getJuego().getCocineros()) {
            System.out.println(c.toString());
        }

        if (super.getJuego().getAlbaniles().size() > 0) {
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Albañiles");
            System.out.print("\n");
        }
        for (Albañil a : super.getJuego().getAlbaniles()) {
            System.out.println(a.toString());
        }

        if (super.getJuego().getHerreros().size() > 0) {
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Herreros");
            System.out.print("\n");
        }
        for (Herrero h : super.getJuego().getHerreros()) {
            System.out.println(h.toString());
        }

        if (super.getJuego().getCarpinteros().size() > 0) {
            System.out.print("\n");
            System.out.println("--------------------------------------");
            System.out.println("Carpinteros");
            System.out.print("\n");
        }
        for (Carpintero c : super.getJuego().getCarpinteros()) {
            System.out.println(c.toString());
        }
    }

    public static void ayuda() {
        System.out.println(
                "'Comenzar nuevo mundo': Se solicita el nombre del mundo. \n" +
                        "'Comenzar mundo nombreMundoEjemplo': Se buscará el archivo que contenga el mundo guardado. \n" +
                        "'Crear doctor': Solicita los datos personales. \n" +
                        "'Crear cocinero': Solicita los datos personales. \n" +
                        "'Crear albañil': Solicita los datos personales. Por cada albañil deben existir 0,5 doctores y 0,5 cocineros. \n" +
                        "'Crear herrero': Solicita los datos personales. Por cada herrero deben existir 0,5 doctores. \n" +
                        "'Crear carpintero': Solicita los datos personales. Por cada carpintero debe existir un doctor. \n" +
                        "'Construir casa': Deben existir 2 carpinteros, 3 albañiles y 1 herrero. \n" +
                        "'Sembrar arbol': Tiene un costo de 0,5 dólares. Cada 10 operaciones mueren 5 árboles. \n" +
                        "'Construir bicicleta': Deben existir herreros. Tiene un costo un dólar. \n" +
                        "'Comprar bicicleta': Tiene un costo de 3 dólares. Se puede conducir cada 5 operaciones. \n" +
                        "'Conducir bicicleta': Sólo puede ser conducida por su dueño. Debe mantener el balance y pedalear de manera continua. \n" +
                        "'Construir automovil': Deben existir 1 carpintero y 1 doctor. Ambos deben tener en 10 dólares en conjunto para pagar 5 al gobierno en impuestos, 2 al herrero en materiales, y 3 al cocinero en alimentación. \n" +
                        "'Comprar automovil': Tiene un costo de 25 dólares. Por cada 10 operaciones en el mundo, el dueño gana 2 dólares en intereses. \n" +
                        "'Conducir automovil': Sólo puede ser conducido por su dueño. Por cada conducción mueren 3 árboles. Debe ser conducido luego de ganar intereses para empezar a generarlos de nuevo. \n" +
                        "'Solicitar prestamo': Una persona debe pagar su préstamo en menos de 10 operaciones propias o morirá. Una persona puede tener 2 préstamos simultáneamente. \n" +
                        "'Pagar prestamo': Una persona debe pagar su préstamo en menos de 10 operaciones propias o morirá. Una persona puede tener 2 préstamos simultáneamente. \n" +
                        "'Imprimir estadísticas': Muestra información del estado del mundo. \n" +
                        "'Guardar mundo': Guarda la partida con el estado actual del mundo en un archivo .txt. \n" +
                        "'Salir': Terminar la ejecución del mundo. \n"
        );
    }

    public void sembrarArbol(Boolean salir) {
        if (super.getJuego().sembrarArbol(salir)) {
            System.out.println("Arbol sembrado");
            return;
        }
        System.out.println("Gobierno no dispone de dinero para sembrar un arbol");
    }

    public void contruirCasa(Boolean salir) {
        int idPersona;
        System.out.print("Digite la identificacion de persona que construirá casa: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idPersona = super.getJuego().esIntValido(supuestoID);
        if (idPersona == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        if (super.getJuego().construirCasa(idPersona, salir)) {
            System.out.println("Casa construida");
            return;
        }
        System.out.println("Casa no pudo ser construida");
    }

    public void construirBicicleta(Boolean salir) {
        int idHerreroConstructor;
        System.out.print("Identificacion de herrero constructor: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idHerreroConstructor = super.getJuego().esIntValido(supuestoID);
        if (idHerreroConstructor == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().construirBicicleta(idHerreroConstructor, salir);
    }

    public void comprarBicicleta(Boolean salir) {

        int idComprador = 0;
        int idVendedor = 0;

        System.out.print("Identificacion del comprador: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idComprador = super.getJuego().esIntValido(supuestoID);
        if (idComprador == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        System.out.print("Identificacion del vendedor: ");
        String supuestoID2;
        supuestoID2 = input.nextLine();
        idComprador = super.getJuego().esIntValido(supuestoID2);
        if (idComprador == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().comprarBicicleta(idComprador, idVendedor, salir);
    }

    public void conducirBicicleta(Boolean salir) {
        int idPersonaConductora;

        System.out.print("Identificacion de persona que conducira bicicleta: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idPersonaConductora = super.getJuego().esIntValido(supuestoID);
        if (idPersonaConductora == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().conducirBicicleta(idPersonaConductora, salir);
    }

    public void construirAutomovil(Boolean salir) {
        int idDoctorConstructor;
        int idCarpinteroConstructor;

        System.out.print("Identificacion de doctor constructor: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idDoctorConstructor = super.getJuego().esIntValido(supuestoID);
        if (idDoctorConstructor == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Identificacion de carpintero constructor: ");
        String supuestoID2;
        supuestoID2 = input.nextLine();
        idCarpinteroConstructor = super.getJuego().esIntValido(supuestoID2);
        if (idCarpinteroConstructor == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().construirAutomovil(idCarpinteroConstructor, idDoctorConstructor, salir);
    }

    public void comprarAutomovil(Boolean salir) {
        int personaCompradora;
        int personaVendedora;

        System.out.print("Identificacion de persona compradora: ");
        String supuestoID;
        supuestoID = input.nextLine();
        personaCompradora = super.getJuego().esIntValido(supuestoID);
        if (personaCompradora == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Identificacion de persona vendedora: ");
        String supuestoID2;
        supuestoID2 = input.nextLine();
        personaVendedora = super.getJuego().esIntValido(supuestoID2);
        if (personaVendedora == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().comprarAutomovil(personaCompradora, personaVendedora, salir);

    }

    public void conducirAutomovil(Boolean salir) {
        int idPersonaConductora;

        System.out.print("Identificacion de persona que conducira automovil: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idPersonaConductora = super.getJuego().esIntValido(supuestoID);
        if (idPersonaConductora == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }

        super.getJuego().conducirAutomovil(idPersonaConductora, salir);
    }

    public void solicitarPrestamo(Boolean salir) {

        String interesado;
        int idPrestamista;
        double cantidadPrestamo;

        System.out.print("Identificacion del prestamista: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idPrestamista = super.getJuego().esIntValido(supuestoID);
        if (idPrestamista == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Identificacion del interesado, en caso de ser el gobierno escriba 'Gobierno': ");
        interesado = input.nextLine();
        System.out.print("Cantidad de dinero a solicitar: ");
        cantidadPrestamo = input.nextDouble();
        input.nextLine();

        super.getJuego().solicitarPrestamo(idPrestamista, interesado, cantidadPrestamo, salir);
    }

    public void pagarPrestamo(Boolean salir) {

        int idPrestamista;
        String idPagador;
        double cantidadAPagar;

        System.out.print("Identificacion del prestamista: ");
        String supuestoID;
        supuestoID = input.nextLine();
        idPrestamista = super.getJuego().esIntValido(supuestoID);
        if (idPrestamista == -1) {
            System.out.println("No puede ingresar caracteres para ese campo, solo numeros");
            return;
        }
        System.out.print("Identificacion del pagador, en caso de ser el gobierno escriba 'Gobierno': ");
        idPagador = input.nextLine();
        System.out.print("Cantidad a pagar: ");
        cantidadAPagar = input.nextDouble();
        input.nextLine();

        super.getJuego().pagarPrestamo(idPrestamista, idPagador, cantidadAPagar, salir);
    }

    public void guardarMundo() {
        super.getJuego().guardarMundo(super.getJuego().getNombreMundo());
        System.out.println("Mundo guardado");
    }
    public Mundo recuperarMundo(String mundo){
        return super.getJuego().recuperarMundo(mundo);
    }

}
