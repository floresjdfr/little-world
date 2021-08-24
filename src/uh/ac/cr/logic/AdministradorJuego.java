package uh.ac.cr.logic;
import uh.ac.cr.logic.AdministradorArchivo;
import uh.ac.cr.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import uh.ac.cr.model.persona.Albañil;
import uh.ac.cr.model.persona.Carpintero;
import uh.ac.cr.model.persona.Doctor;
import uh.ac.cr.model.persona.Herrero;

public class AdministradorJuego extends Administrador{
    public AdministradorJuego(Mundo mundo) {
        super(mundo);
    }

    public String getNombreMundo(){
        return super.getMundo().getName();
    }
}