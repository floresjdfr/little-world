package uh.ac.cr.logic;

import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Persona;
import uh.ac.cr.model.vehiculo.Vehiculo;

public class AdministrarValidaciones extends Administrador {

    public AdministrarValidaciones(Mundo mundo) {
        super(mundo);
    }

    public boolean iniciarOperacionesCreacion() {
        if (super.getMundo().getContadorCreacion() == 5) {
            super.getMundo().resetCotnadorCreacion();
            return true;
        }
        return false;
    }

    public boolean iniciarOperaciones5() {
        if (super.getMundo().getContadorOperaciones5() == 5) {
            super.getMundo().resetContador5();
            return true;
        }
        return false;
    }

    public boolean iniciarOperaciones10() {
        if (super.getMundo().getContadorOperaciones10() == 10) {
            super.getMundo().resetContador10();
            return true;
        }
        return false;
    }

    public boolean iniciarOperaciones15() {
        if (super.getMundo().getContadorOperaciones15() == 15) {
            super.getMundo().resetContador15();
            return true;
        }
        return false;
    }

    public boolean iniciarOperaciones30() {
        if (super.getMundo().getContadorOperaciones30() == 30) {
            super.getMundo().resetContador30();
            return true;
        }
        return false;
    }

    public void validarTodasOperaciones(Boolean salir) {

        super.getMundo().aumentarContador5();
        super.getMundo().aumentarContador10();
        super.getMundo().aumentarContador15();
        super.getMundo().aumentarContador30();

        validarOperaciones5();
        validarOperaciones10();
        validarOperaciones15();
        validarOperaciones30(salir);
    }

    public void validacionesCreacion() {
        super.getMundo().aumentarContadorCreacion();
        if (iniciarOperacionesCreacion()) {
            int cantidadDineroARegalar = 1;
            super.getMundo().darDineroATodos(cantidadDineroARegalar);
        }
    }

    public void validarOperaciones5() {
        if (iniciarOperaciones5()) {
            this.enfermarTodosConProbabilidad50();
            //this.curarMatarEnfermosProbabilidad50();
            this.permitirConduccionBicicletas();
            this.darDineroSiHayArboles();
        }
    }

    public void validarOperaciones10() {
        if (iniciarOperaciones10()) {
            int cantArbolesMueren = 5;

            super.getMundo().muerteArboles(cantArbolesMueren);
            this.ganarDineroPorAutomoviles();
        }
    }

    public void validarOperaciones15() {
        if (iniciarOperaciones15()) {
            this.dividirDineroGobierno();
        }
    }

    public void validarOperaciones30(Boolean salir) {
        if (iniciarOperaciones30()) {
            if (gorbiernoConPrestamos()) {
                System.out.println("Gobierno colapso porque no pago prestamo");
                salir = true;
            }
        }
    }

    //Metodos para 5 operaciones
    public void enfermarTodosConProbabilidad50() {
        for (Persona p : super.getMundo().getListaDoctores()) {
            if (super.getMundo().getRandom1and2() == 1){
                super.getMundo().enfermarPersona(p);
            }
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            if (super.getMundo().getRandom1and2() == 1)
                super.getMundo().enfermarPersona(p);
        }
        for (Persona p : super.getMundo().getListaAlbaniles()) {
            if (super.getMundo().getRandom1and2() == 1)
                super.getMundo().enfermarPersona(p);
        }
        for (Persona p : super.getMundo().getListaHerreros()) {
            if (super.getMundo().getRandom1and2() == 1)
                super.getMundo().enfermarPersona(p);
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            if (super.getMundo().getRandom1and2() == 1)
                super.getMundo().enfermarPersona(p);
        }
    }

    public void curarMatarEnfermosProbabilidad50() {
        for (int i = 0; i < super.getMundo().getListaDoctores().size(); i++) {
            if (!super.getMundo().getListaDoctores().get(i).getPersonaSaludable()) {
                if (super.getMundo().getRandom1and2() == 1)
                    super.getMundo().getListaDoctores().get(i).setPersonaSaludable(true);
                else {
                    super.getMundo().getListaDoctores().remove(i);
                    super.getMundo().setPersonasMuertas(super.getMundo().getPersonasMuertas() + 1);
                }
            }
        }
        for (int i = 0; i < super.getMundo().getListaCocineros().size(); i++) {
            if (!super.getMundo().getListaCocineros().get(i).getPersonaSaludable()) {
                if (super.getMundo().getRandom1and2() == 1)
                    super.getMundo().getListaCocineros().get(i).setPersonaSaludable(true);
                else {
                    super.getMundo().getListaCocineros().remove(i);
                    super.getMundo().setPersonasMuertas(super.getMundo().getPersonasMuertas() + 1);
                }
            }
        }
        for (int i = 0; i < super.getMundo().getListaCarpinteros().size(); i++) {
            if (!super.getMundo().getListaCarpinteros().get(i).getPersonaSaludable()) {
                if (super.getMundo().getRandom1and2() == 1)
                    super.getMundo().getListaCarpinteros().get(i).setPersonaSaludable(true);
                else {
                    super.getMundo().getListaCarpinteros().remove(i);
                    super.getMundo().setPersonasMuertas(super.getMundo().getPersonasMuertas() + 1);
                }
            }
        }
        for (int i = 0; i < super.getMundo().getListaAlbaniles().size(); i++) {
            if (!super.getMundo().getListaAlbaniles().get(i).getPersonaSaludable()) {
                if (super.getMundo().getRandom1and2() == 1)
                    super.getMundo().getListaAlbaniles().get(i).setPersonaSaludable(true);
                else {
                    super.getMundo().getListaAlbaniles().remove(i);
                    super.getMundo().setPersonasMuertas(super.getMundo().getPersonasMuertas() + 1);
                }
            }
        }
        for (int i = 0; i < super.getMundo().getListaHerreros().size(); i++) {
            if (!super.getMundo().getListaHerreros().get(i).getPersonaSaludable()) {
                if (super.getMundo().getRandom1and2() == 1)
                    super.getMundo().getListaHerreros().get(i).setPersonaSaludable(true);
                else {
                    super.getMundo().getListaHerreros().remove(i);
                    super.getMundo().setPersonasMuertas(super.getMundo().getPersonasMuertas() + 1);
                }
            }
        }
    }

    public void permitirConduccionBicicletas() {
        for (Persona p : super.getMundo().getListaDoctores()) {
            p.permitirConduccionBicicletas();
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            p.permitirConduccionBicicletas();
        }
        for (Persona p : super.getMundo().getListaAlbaniles()) {
            p.permitirConduccionBicicletas();
        }
        for (Persona p : super.getMundo().getListaHerreros()) {
            p.permitirConduccionBicicletas();
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            p.permitirConduccionBicicletas();
        }
    }

    public void darDineroSiHayArboles() {
        double cantArbolesDeseados = 3;//Por persona
        int cantArbolesActuales = super.getMundo().getArboles();
        int cantPersonas = super.getMundo().contarPersonas();

        if (cantArbolesDeseados >= (double) (cantArbolesActuales / cantPersonas)) {
            double recompensa = 5;
            super.getMundo().darDineroATodos(recompensa);
        }
    }

    //Metodos para 10 operaciones
    public void ganarDineroPorAutomoviles() {
        for (Persona p : super.getMundo().getListaDoctores()) {
            for (Vehiculo v : p.getVehiculos()) {
                v.puedeGanarInteres();
                v.setPuedeGanarInteres(false);
            }
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            for (Vehiculo v : p.getVehiculos()) {
                v.puedeGanarInteres();
                v.setPuedeGanarInteres(false);
            }
        }
        for (Persona p : super.getMundo().getListaAlbaniles()) {
            for (Vehiculo v : p.getVehiculos()) {
                v.puedeGanarInteres();
                v.setPuedeGanarInteres(false);
            }
        }
        for (Persona p : super.getMundo().getListaHerreros()) {
            for (Vehiculo v : p.getVehiculos()) {
                v.puedeGanarInteres();
                v.setPuedeGanarInteres(false);
            }
        }
        for (Persona p : super.getMundo().getListaCocineros()) {
            for (Vehiculo v : p.getVehiculos()) {
                v.puedeGanarInteres();
                v.setPuedeGanarInteres(false);
            }
        }
    }

    //Metodos para 15 operaciones
    public void dividirDineroGobierno() {

        double dineroDividible = super.getMundo().getGobierno().getCapitalEconomico() / 2;
        double dineroPorPersona = super.getMundo().contarPersonas();

        if (dineroDividible > 0) {

            super.getMundo().gobiernoDarDinero(dineroDividible);

            for (Persona p : super.getMundo().getListaDoctores())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaCocineros())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaAlbaniles())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaHerreros())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaCocineros())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaDoctores())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaCocineros())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaAlbaniles())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaHerreros())
                p.ganarDinero(dineroPorPersona);
            for (Persona p : super.getMundo().getListaCocineros())
                p.ganarDinero(dineroPorPersona);
        }
    }

    //Metodos para 30 operaciones
    public Boolean gorbiernoConPrestamos() {
        if (super.getMundo().getGobierno().getPrestamos().size() > 0)
            return true;
        return false;
    }
}
