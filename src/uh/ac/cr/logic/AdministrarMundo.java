package uh.ac.cr.logic;

import uh.ac.cr.model.*;

import java.util.Locale;
import java.util.Random;

import uh.ac.cr.model.persona.*;

public class AdministrarMundo extends Administrador {
    AdministrarValidaciones validaciones;

    public AdministrarMundo(Mundo mundo) {
        super(mundo);
        validaciones = new AdministrarValidaciones(mundo);
    }

    public String getNombreMundo() {
        return super.getMundo().getName();
    }

    public int getArboles() {
        return super.getMundo().getArboles();
    }

    public Boolean sembrarArbol(Boolean salir) {
        if (super.getMundo().getGobierno().getCapitalEconomico() > 0.5) {//Verifica que el gobierna tenga capital para pagar el arbol
            super.getMundo().sembrarArbol();
            validaciones.validarTodasOperaciones(salir);
            return true;
        }
        return false;
    }

    public Boolean construirCasa(int idPersona, Boolean salir) {
        Persona p = null;

        try {
            p = this.buscarPersona(idPersona);
            if (p == null)
                throw new Exception("Persona no existe");
        } catch (Exception ex) {
            System.out.println("Persona con esa identificacion no existe");
            return false;
        }

        if (cumpleRequisitosParaConstruirCasa(p)) {

            double salarioCarpintero = 4;
            double salarioAlbanil = 2;
            double salarioHerrero = 3;
            double impuesto = 10;
            double dineroNecesario = salarioCarpintero * 2 + salarioAlbanil * 3 + salarioHerrero + impuesto;

            pagarConstruccionEmpleados();
            p.construirCasa(dineroNecesario);
            System.out.println("Casa construida");

            validaciones.validacionesCreacion();
            validaciones.validarTodasOperaciones(salir);

            return true;
        }
        return false;
    }

    private Boolean cumpleRequisitosParaConstruirCasa(Persona p) {

        int cantCarpinteros = super.getMundo().getListaCarpinteros().size();
        int cantAlbaniles = super.getMundo().getListaAlbaniles().size();
        int cantHerrero = super.getMundo().getListaHerreros().size();

        double salarioCarpintero = 4;
        double salarioAlbanil = 2;
        double salarioHerrero = 3;
        double impuesto = 10;

        if (cantCarpinteros >= 2 && cantAlbaniles >= 3 && cantHerrero >= 1) {

            double dineroNecesario = salarioCarpintero * 2 + salarioAlbanil * 3 + salarioHerrero + impuesto;

            if (p.getDinero() >= dineroNecesario) {
                return true;
            }

            System.out.println("No tiene dinero suficiente para construir");
            return false;
        }
        System.out.println("Deben existir 2 carpinteros, 3 albañiles y 1 hererro para construir la casa");
        return false;
    }

    private void pagarConstruccionEmpleados() {

        //Se ocupa pagar a 3 albañiles random
        for (int i = 0; i < 3; i++)
            pagarContruccionAbanil(2);
        //Se ocupa pagar a 2 carpinteros random
        for (int i = 0; i < 2; i++)
            pagarContruccionCarpintero(4);
        pagarContruccionHerrero(3);
        this.getMundo().pagarAGobierno(10);
    }

    private void pagarContruccionAbanil(double cantidad) {
        Random rand = new Random();
        int albanilRand = rand.nextInt(super.getMundo().getListaAlbaniles().size());
        super.getMundo().pagarConstruccionAlbanil(super.getMundo().getListaAlbaniles().get(albanilRand), cantidad);
    }

    private void pagarContruccionHerrero(double cantidad) {
        Random rand = new Random();
        int herreroRand = rand.nextInt(super.getMundo().getListaHerreros().size());
        super.getMundo().pagarConstruccionHerreros(super.getMundo().getListaHerreros().get(herreroRand), cantidad);
    }

    private void pagarContruccionCarpintero(double cantidad) {
        Random rand = new Random();
        int carpinteroRand = rand.nextInt(super.getMundo().getListaCarpinteros().size());
        super.getMundo().pagarConstruccionCarpintero(super.getMundo().getListaCarpinteros().get(carpinteroRand), cantidad);
    }

    public Persona buscarPersona(int idPersona) {
        return super.getMundo().buscarPersona(idPersona);
    }

    public Boolean solicitarPrestamo(int idPrestamista, String interesado, double totalPrestamo, Boolean salir) {

        Persona personaPrestamista = this.buscarPersona(idPrestamista);
        int idInteresado;

        if (personaPrestamista == null) {
            System.out.println("Persona prestamista no existe");
            return false;
        }

        if (interesado.toLowerCase(Locale.ROOT).equals("gobierno")) {

            if (personaPrestamista.getDinero() >= totalPrestamo) {
                if (this.getMundo().getGobierno().getPrestamos().size() < 2) {
                    this.getMundo().getGobierno().solicitarPrestamo(idPrestamista, totalPrestamo);
                    personaPrestamista.prestarDinero(totalPrestamo);

                    validaciones.validarTodasOperaciones(salir);

                    return true;
                }
                System.out.println("Gobierno ya posee 2 prestamos activos");
                return false;
            }
            System.out.println("Persona prestamista no dispone de dinero suficiente");
            return false;
        }


        try {
            idInteresado = Integer.parseInt(interesado);
        } catch (Exception ex) {
            System.out.println("Identificacion del interesado no valida");
            return false;
        }

        Persona personaInteresada = this.buscarPersona(idInteresado);

        if (personaInteresada != null) {
            if (personaPrestamista.getDinero() >= totalPrestamo) {
                personaInteresada.solicitarPrestamo(idPrestamista, totalPrestamo);
                personaPrestamista.prestarDinero(totalPrestamo);

                validaciones.validacionesCreacion();
                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            System.out.println("Persona prestamista no dispone de dinero suficiente");
            return false;
        }
        System.out.println("Persona interesada no existe");
        return false;
    }

    public Boolean pagarPrestamo(int idPrestamista, String idPagador, double cantidadAPagar, Boolean salir) {

        int idPagadorInt;
        Persona personaPrestamista = this.buscarPersona(idPrestamista);

        //Verifica si persona prestamista existe
        if (personaPrestamista == null) {
            System.out.println("Persona prestamista no existe");
            return false;
        }

        //Verifica si gobierno es quien realiza solicitud
        if (idPagador.toLowerCase(Locale.ROOT).equals("gobierno")) {
            if (this.getMundo().getGobierno().getCapitalEconomico() >= cantidadAPagar) {
                this.getMundo().getGobierno().pagarPrestamo(idPrestamista, cantidadAPagar);
                personaPrestamista.recibirPagoPrestamo(cantidadAPagar);

                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            System.out.println("Persona pagadora no dispone de dinero suficiente");
            return false;
        }

        //Convierte el id en int
        try {
            idPagadorInt = Integer.parseInt(idPagador);
        } catch (Exception ex) {
            System.out.println("Identificacion del pagador no valida");
            return false;
        }


        Persona personaPagadora = this.buscarPersona(idPagadorInt);

        //Realiza el proceso de pago del prestamo en caso que sea de persona a persona
        if (personaPagadora != null) {
            if (personaPagadora.getDinero() >= cantidadAPagar) {
                personaPagadora.pagarPrestamo(idPrestamista, cantidadAPagar);
                personaPrestamista.recibirPagoPrestamo(cantidadAPagar);

                validaciones.validacionesCreacion();
                validaciones.validarTodasOperaciones(salir);

                return true;
            }
            System.out.println("Persona pagadora no dispone de dinero suficiente");
            return false;
        }
        System.out.println("Persona pagadora no existe");
        return false;
    }

    public String imprimirGobierno() {
        return this.getMundo().getGobierno().toString();
    }
}