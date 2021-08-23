package uh.ac.cr.model.persona;

import java.util.ArrayList;
public class Doctor extends Persona {

    private String especialidad;
    private int dinero;
    private String paciente;


    public ArrayList<Doctor> listaDoctor = new ArrayList<>();

    public Doctor(String nombre, String apellidos, int id) {
        super(nombre, apellidos, id);
    }


    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }
}
