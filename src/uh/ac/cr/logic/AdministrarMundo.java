package uh.ac.cr.logic;

import uh.ac.cr.logic.AdministradorArchivo;
import uh.ac.cr.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import uh.ac.cr.model.persona.*;

public class AdministrarMundo extends Administrador {
    public AdministrarMundo(Mundo mundo) {
        super(mundo);
    }

    public String getNombreMundo() {
        return super.getMundo().getName();
    }

    public int getArboles() {
        return super.getMundo().getArboles();
    }

    public Boolean sembrarArbol() {
        if (super.getMundo().getGobierno().getCapitalEconomico() > 0.5) {//Verifica que el gobierna tenga capital para pagar el arbol
            super.getMundo().sembrarArbol();
            return true;
        }
        return false;
    }

    public Boolean construirCasa(int idPersona) {
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

            double salarioCarpintero = super.getMundo().getListaCarpinteros().get(0).getSalario();
            double salarioAlbanil = super.getMundo().getListaAlbaniles().get(0).getSalario();
            double salarioHerrero = super.getMundo().getListaHerreros().get(0).getSalario();
            double impuesto = 10;
            double dineroNecesario = salarioHerrero + salarioAlbanil + salarioCarpintero + impuesto;

            pagarConstruccionEmpleados();
            p.construirCasa(dineroNecesario);
            System.out.println("Casa construida");
            return true;
        }
        return false;
    }

    public Boolean cumpleRequisitosParaConstruirCasa(Persona p) {

        int cantCarpinteros = super.getMundo().getListaCarpinteros().size();
        int cantAlbaniles = super.getMundo().getListaAlbaniles().size();
        int cantHerrero = super.getMundo().getListaHerreros().size();

        double salarioCarpintero;
        double salarioAlbanil;
        double salarioHerrero;
        double impuesto = 10;

        try {
            //En caso que algunas de las listas no tenga ninguna persona, hay una excepcion
            salarioCarpintero = super.getMundo().getListaCarpinteros().get(0).getSalario();
            salarioAlbanil = super.getMundo().getListaAlbaniles().get(0).getSalario();
            salarioHerrero = super.getMundo().getListaHerreros().get(0).getSalario();

        } catch (Exception ex) {
            System.out.println("Deben existir 2 carpinteros, 3 albañiles y 1 hererro para construir la casa");
            return false;
        }

        if (cantCarpinteros >= 2 && cantAlbaniles >= 3 && cantHerrero >= 1) {

            double dineroNecesario = salarioCarpintero + salarioAlbanil + salarioHerrero + impuesto;

            if (p.getDinero() >= dineroNecesario) {
                return true;
            }

            System.out.println("No tiene dinero suficiente para construir");
            return false;
        }
        System.out.println("Deben existir 2 carpinteros, 3 albañiles y 1 hererro para construir la casa");
        return false;
    }

    public void pagarConstruccionEmpleados() {
        pagarContruccionAbanil();
        pagarContruccionCarpintero();
        pagarContruccionHerrero();
    }

    public void pagarContruccionAbanil() {
        Random rand = new Random();
        int albanilRand = rand.nextInt(super.getMundo().getListaAlbaniles().size());
        super.getMundo().pagarConstruccionAlbanil(super.getMundo().getListaAlbaniles().get(albanilRand));
    }

    public void pagarContruccionHerrero() {
        Random rand = new Random();
        int herreroRand = rand.nextInt(super.getMundo().getListaHerreros().size());
        super.getMundo().pagarConstruccionHerreros(super.getMundo().getListaHerreros().get(herreroRand));
    }

    public void pagarContruccionCarpintero() {
        Random rand = new Random();
        int carpinteroRand = rand.nextInt(super.getMundo().getListaCarpinteros().size());
        super.getMundo().pagarConstruccionCarpintero(super.getMundo().getListaCarpinteros().get(carpinteroRand));
    }

    public Persona buscarPersona(int idPersona) {
        return super.getMundo().buscarPersona(idPersona);
    }

    public Boolean solicitarPrestamo(int idPrestamista, String interesado, double totalPrestamo) {

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
                return true;
            }
            System.out.println("Persona prestamista no dispone de dinero suficiente");
            return false;
        }
        System.out.println("Persona interesada no existe");
        return false;
    }

    public Boolean pagarPrestamo(int idPrestamista, String idPagador, double cantidadAPagar) {

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
                return true;
            }
            System.out.println("Persona pagadora no dispone de dinero suficiente");
            return false;
        }
        System.out.println("Persona pagadora no existe");
        return false;
    }
    String imprimirGobierno(){
        return this.getMundo().getGobierno().toString();
    }
}