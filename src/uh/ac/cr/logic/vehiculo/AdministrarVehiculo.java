package uh.ac.cr.logic.vehiculo;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.logic.AdministrarValidaciones;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.*;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class AdministrarVehiculo extends Administrador {

    private AdministrarValidaciones validaciones;

    public AdministrarVehiculo(Mundo mundo) {
        super(mundo);
        validaciones = new AdministrarValidaciones(mundo);
    }

    public void construirBicicleta(int idHerreroConstructor, Boolean salir) {

        Herrero h = super.getMundo().buscarHerrero(idHerreroConstructor);

        if (validarRequisitosBici(h)) {
            super.getMundo().construirBicicleta(h, 1);
            System.out.println("Bicicleta construida");

            validaciones.validacionesCreacion();
            validaciones.validarTodasOperaciones(salir);
        }
    }

    private Boolean validarRequisitosBici(Herrero herreroConstructor) {

        if (herreroConstructor == null) {
            System.out.println("Herrero constructor no existe");
            return false;
        }
        if (herreroConstructor.getDinero() < 1) {
            System.out.println("Herrero no cuenta con dinero suficiente para construir la bicicleta");
            return false;
        }
        return true;
    }

    public void conducirBicicleta(int idPersona, Boolean salir) {
        Persona p = super.getMundo().buscarPersona(idPersona);
        if (p != null) {
            if (verificaSiBicicletas(p)) {
                if (!super.getMundo().conducirBicicleta(p)) {
                    System.out.println("No se han realizado las operaciones necesarias en el mundo para que la persona pueda conducir la bicicleta");
                    return;
                }
                validaciones.validarTodasOperaciones(salir);
                return;
            }
            System.out.println("Persona no posee bicicletas");
            return;
        }
        System.out.println("Persona no existe");
    }

    private Boolean verificaSiBicicletas(Persona p) {
        /**
         * Verifica si persona tiene bicicletas
         */
        for (Vehiculo v : p.getVehiculos())
            if (v.getNombre().equals("Bicicleta"))
                return true;
        return false;
    }

    public void conducirAutomovil(int idPersonaConductora, Boolean salir) {
        Persona p = super.getMundo().buscarPersona(idPersonaConductora);
        int cantidadArbolesMueren = 3;
        if (p != null) {
            if (verificarSiAutos(p)) {
                p.conducirAutomovil();
                super.getMundo().muerteArboles(cantidadArbolesMueren);

                validaciones.validarTodasOperaciones(salir);

                return;
            }
            System.out.println("Persona no posee automoviles");
            return;
        }
        System.out.println("Persona no existe");
    }

    private Boolean verificarSiAutos(Persona p) {
        /**
         * Verifica si persona tiene automoviles
         */
        for (Vehiculo v : p.getVehiculos())
            if (v.getNombre().equals("Automovil"))
                return true;
        return false;
    }

    public void comprarBicicleta(int idComprador, int idVendedor, Boolean salir) {

        Persona pc = super.getMundo().buscarPersona(idComprador);
        Persona pv = super.getMundo().buscarPersona(idVendedor);

        if (pv != null && pc != null) {
            if (pv.getCantidadBicicletas() > 0) {
                if (pc.getDinero() >= 3) {
                    pv.venderBicicleta(3);
                    pc.comprarBicicleta(3);
                    System.out.println("Trueque de bicicleta realizado");

                    validaciones.validarTodasOperaciones(salir);

                    return;
                }
                System.out.println("Comprardor no tiene dinero suficiente");
                return;
            }
            System.out.println("Vendedor no tiene bicicletas disponibles");
            return;
        }
        System.out.println("Comprador o vendedor no existen");
    }

    public void construirAutomovil(int idCarpinteroConstructor, int idDoctorConstructor, Boolean salir) {

        Carpintero c = super.getMundo().buscarCarpintero(idCarpinteroConstructor);
        Doctor d = super.getMundo().buscarDoctor(idDoctorConstructor);
        Random rand = new Random();

        if (validarRequisitosAuto(c, d)) {

            int precioAutomovilPorPersona = 5;
            int impuestoGobierno = 5;
            int pagoHerrero = 2;
            int pagoCocinero = 3;
            int ganadorAutomovil = rand.nextInt(2);

            //Descuento de dinero a constructores
            c.perderDinero(precioAutomovilPorPersona);
            d.perderDinero(precioAutomovilPorPersona);

            //Pagos a realizar
            super.getMundo().pagarAGobierno(impuestoGobierno);
            this.obtenerHerreroRandom().ganarDinero(pagoHerrero);
            this.obtenerCocineroRandom().ganarDinero(pagoCocinero);

            //Quien se deja el automovil?
            if (ganadorAutomovil == 0)
                super.getMundo().agregarAutomovil(c);
            else
                super.getMundo().agregarAutomovil(d);
            System.out.println("Automovil construido");
            validaciones.validacionesCreacion();
            validaciones.validarTodasOperaciones(salir);
        }
    }

    private Boolean validarRequisitosAuto(Carpintero carpinteroConstructor, Doctor doctorConstructor) {

        if (carpinteroConstructor == null) {
            System.out.println("Carpintero constructor no existe");
            return false;
        }
        if (doctorConstructor == null) {
            System.out.println("Doctor constructor no existe");
            return false;
        }
        if (carpinteroConstructor.getDinero() < 5) {
            System.out.println("Carpintero no cuenta con dinero suficiente para construir la automovil");
            return false;
        }
        if (doctorConstructor.getDinero() < 5) {
            System.out.println("Doctor no cuenta con dinero suficiente para construir la automovil");
            return false;
        }
        if (super.getMundo().getListaHerreros().size() < 1) {
            System.out.println("Se necesita un herrero al cual comprarle los materiales para contruir el automovil");
            return false;
        }
        if (super.getMundo().getListaCocineros().size() < 1) {
            System.out.println("Se necesita un cocinero al cual comprarle la alimentacion");
            return false;
        }
        return true;
    }

    private Herrero obtenerHerreroRandom() {
        ArrayList<Herrero> cpyHerreros = super.getMundo().getListaHerreros();
        Random rand = new Random();
        int herreroRandom = rand.nextInt(cpyHerreros.size());
        return cpyHerreros.get(herreroRandom);
    }

    private Cocinero obtenerCocineroRandom() {
        ArrayList<Cocinero> cpyCocineros = super.getMundo().getListaCocineros();
        Random rand = new Random();
        int cocineroRandom = rand.nextInt(cpyCocineros.size());
        return cpyCocineros.get(cocineroRandom);
    }

    public void comprarAutomovil(int idPersonaCompradora, int idPersonaVendedora, Boolean salir) {
        Persona compradora = super.getMundo().buscarPersona(idPersonaCompradora);
        Persona vendedora = super.getMundo().buscarPersona(idPersonaVendedora);
        double precioAutomovil = 25;

        if (compradora == null) {
            System.out.println("Persona compradora no existe");
            return;
        }
        if (vendedora == null) {
            System.out.println("Persona vendedora no existe");
            return;
        }
        if (verificarReqVendedoraAuto(vendedora) && verificarReqCompradoraAuto(compradora)) {
            compradora.perderDinero(precioAutomovil);
            vendedora.ganarDinero(precioAutomovil);
            compradora.agregarAutomovil();
            vendedora.eliminarAutomovil();

            validaciones.validarTodasOperaciones(salir);
        }
    }

    private Boolean verificarReqVendedoraAuto(Persona p) {
        ArrayList<Vehiculo> cpyVehiculos = p.getVehiculos();
        for (Vehiculo v : cpyVehiculos)
            if (v.getNombre().equals("Automovil"))
                return true;
        System.out.println("Persona vendedora no dispone de automoviles");
        return false;
    }

    private Boolean verificarReqCompradoraAuto(Persona p) {
        double precioAuto = 25;
        if (p.getDinero() >= 25)
            return true;
        System.out.println("Persona compradora no dispone de suficiente dinero");
        return false;
    }
}
