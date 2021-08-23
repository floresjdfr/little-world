package uh.ac.cr.logic;
import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.persona.Persona;

import java.util.ArrayList;
import java.util.Scanner;

public class AdministrarDoctor extends Persona {
    Scanner Datos;
    private ArrayList<Doctor> listaDoctores;

    //administrarDinero administrarDinero = null;

    public class AdministradorDoctor extends Mundo {

        public AdministradorDoctor(String name){
            super(name);
        }
    }

    public AdministrarDoctor() {
        super();
        this.Datos = new Scanner(System.in);
        this.listaDoctores = new ArrayList();
    }

        public ArrayList<Doctor> getListaDeDoctores() {
            return this.listaDoctores;
        }
        public void pacienteMuere(){

        }
}


