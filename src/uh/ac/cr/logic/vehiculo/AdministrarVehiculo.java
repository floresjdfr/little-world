package uh.ac.cr.logic.vehiculo;

import uh.ac.cr.logic.Administrador;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Herrero;
import uh.ac.cr.model.persona.Persona;

public class AdministrarVehiculo extends Administrador {
    public AdministrarVehiculo(Mundo mundo) {
        super(mundo);
    }

    public void construirBicicleta(int idHerreroConstructor) {

        Herrero h = super.getMundo().buscarHerrero(idHerreroConstructor);

        if (validarRequisitosBici(h)) {
            super.getMundo().construirBicicleta(h, 1);
            System.out.println("Bicicleta construida");
        }
    }
    public Boolean validarRequisitosBici(Herrero herreroConstructor) {

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
    public void conducirBicicleta(int idPersona){
        Persona p = super.getMundo().buscarPersona(idPersona);
        if (p != null){
            if (p.getPermisoConducirBicicleta()){
                super.getMundo().conducirBicicleta(p);
                System.out.println("Bicicleta conducida");
                return;
            }
            System.out.println("No se han realizado las operaciones necesarias en el mundo para que la persona pueda conducir la bicicleta");
            return;
        }
        System.out.println("Persona no existe");
    }
    public void comprarBicicleta(int idComprador, int idVendedor){

        Persona pc = super.getMundo().buscarPersona(idComprador);
        Persona pv = super.getMundo().buscarPersona(idVendedor);

        if (pv != null && pc != null){
            if (pv.getCantidadBicicletas() > 0){
                if (pc.getDinero() >= 3){
                    pv.venderBicicleta(3);
                    pc.comprarBicicleta(3);
                    System.out.println("Trueque de bicicleta realizado");
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
}
