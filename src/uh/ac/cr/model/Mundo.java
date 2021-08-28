package uh.ac.cr.model;

import uh.ac.cr.model.persona.*;
import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Mundo {

    private String name;
    private Gobierno gobierno;
    private ArrayList<Doctor> listaDoctores;
    private ArrayList<Cocinero> listaCocineros;
    private ArrayList<Albañil> listaAlbaniles;
    private ArrayList<Herrero> listaHerreros;
    private ArrayList<Carpintero> listaCarpinteros;

    private int arboles;

    private int contadorCreacion;
    private int contadorOperaciones5;
    private int contadorOperaciones10;
    private int contadorOperaciones15;
    private int contadorOperaciones30;

    private int personasMuertas;

    public Mundo(String name, int arboles, int contadorCreacion, int contadorOperaciones5, int contadorOperaciones10, int contadorOperaciones15,
                 int contadorOperaciones30, int personasMuertas, Gobierno gobierno, ArrayList<Doctor> listaDoctores, ArrayList<Cocinero> listaCocineros,
                 ArrayList<Albañil> listaAlbaniles, ArrayList<Herrero> listaHerreros, ArrayList<Carpintero> listaCarpinteros) {
        this.name = name;
        this.gobierno = gobierno;
        this.listaDoctores = listaDoctores;
        this.listaCocineros = listaCocineros;
        this.listaAlbaniles = listaAlbaniles;
        this.listaHerreros = listaHerreros;
        this.listaCarpinteros = listaCarpinteros;
        this.arboles = arboles;
        this.contadorCreacion = contadorCreacion;
        this.contadorOperaciones5 = contadorOperaciones5;
        this.contadorOperaciones10 = contadorOperaciones10;
        this.contadorOperaciones15 = contadorOperaciones15;
        this.contadorOperaciones30 = contadorOperaciones30;
        this.personasMuertas = personasMuertas;
    }

    public String toFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mundo>\n");
        stringBuilder.append(name + "\n");
        stringBuilder.append(arboles + "\n");
        stringBuilder.append(contadorCreacion + "\n");
        stringBuilder.append(contadorOperaciones5 + "\n");
        stringBuilder.append(contadorOperaciones10 + "\n");
        stringBuilder.append(contadorOperaciones15 + "\n");
        stringBuilder.append(contadorOperaciones30 + "\n");
        stringBuilder.append(personasMuertas + "\n");
        stringBuilder.append("<gobierno>\n");
        stringBuilder.append(gobierno.toFile());
        stringBuilder.append("<gobierno>\n");
        stringBuilder.append("<doctores>\n");
        for (Doctor d : listaDoctores) {
            stringBuilder.append(d.toFile());
        }
        stringBuilder.append("<doctores>\n");
        stringBuilder.append("<cocineros>\n");
        for (Cocinero d : listaCocineros) {
            stringBuilder.append(d.toFile());
        }
        stringBuilder.append("<cocineros>\n");
        stringBuilder.append("<albañiles>\n");
        for (Albañil d : listaAlbaniles) {
            stringBuilder.append(d.toFile());
        }
        stringBuilder.append("<albañiles>\n");
        stringBuilder.append("<herreros>\n");
        for (Herrero d : listaHerreros) {
            stringBuilder.append(d.toFile());
        }
        stringBuilder.append("<herreros>\n");
        stringBuilder.append("<carpinteros>\n");
        for (Carpintero d : listaCarpinteros) {
            stringBuilder.append(d.toFile());
        }
        stringBuilder.append("<carpinteros>\n");
        stringBuilder.append("<mundo>\n");
        return stringBuilder.toString();
    }

    public Mundo(String nombre) {
        this.name = nombre;
        gobierno = new Gobierno(0, new ArrayList<>());
        listaDoctores = new ArrayList<>();
        listaCocineros = new ArrayList<>();
        listaAlbaniles = new ArrayList<>();
        listaHerreros = new ArrayList<>();
        listaCarpinteros = new ArrayList<>();

        arboles = 20;
    }

    public Gobierno getGobierno() {
        return gobierno;
    }

    public void setGobierno(Gobierno gobierno) {
        this.gobierno = gobierno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getListaDoctores() {
        return listaDoctores;
    }

    public void setListaDoctores(ArrayList<Doctor> listaDoctores) {
        this.listaDoctores = listaDoctores;
    }

    public ArrayList<Cocinero> getListaCocineros() {
        return listaCocineros;
    }

    public void setListaCocineros(ArrayList<Cocinero> listaCocineros) {
        this.listaCocineros = listaCocineros;
    }

    public ArrayList<Albañil> getListaAlbaniles() {
        return listaAlbaniles;
    }

    public void setListaAlbaniles(ArrayList<Albañil> listaAlbaniles) {
        this.listaAlbaniles = listaAlbaniles;
    }

    public ArrayList<Herrero> getListaHerreros() {
        return listaHerreros;
    }

    public void setListaHerreros(ArrayList<Herrero> listaHerreros) {
        this.listaHerreros = listaHerreros;
    }

    public ArrayList<Carpintero> getListaCarpinteros() {
        return listaCarpinteros;
    }

    public void setListaCarpinteros(ArrayList<Carpintero> listaCarpinteros) {
        this.listaCarpinteros = listaCarpinteros;
    }

    public int getContadorCreacion() {
        return contadorCreacion;
    }

    public void setContadorCreacion(int contadorCreacion) {
        this.contadorCreacion = contadorCreacion;
    }

    public int getArboles() {
        return arboles;
    }

    public void setArboles(int arboles) {
        this.arboles = arboles;
    }

    public int getContadorOperaciones5() {
        return contadorOperaciones5;
    }

    public void setContadorOperaciones5(int contadorOperaciones5) {
        this.contadorOperaciones5 = contadorOperaciones5;
    }

    public int getContadorOperaciones10() {
        return contadorOperaciones10;
    }

    public void setContadorOperaciones10(int contadorOperaciones10) {
        this.contadorOperaciones10 = contadorOperaciones10;
    }

    public int getContadorOperaciones15() {
        return contadorOperaciones15;
    }

    public void setContadorOperaciones15(int contadorOperaciones15) {
        this.contadorOperaciones15 = contadorOperaciones15;
    }

    public int getContadorOperaciones30() {
        return contadorOperaciones30;
    }

    public void setContadorOperaciones30(int contadorOperaciones30) {
        this.contadorOperaciones30 = contadorOperaciones30;
    }

    public int getPersonasMuertas() {
        return personasMuertas;
    }

    public void setPersonasMuertas(int personasMuertas) {
        this.personasMuertas = personasMuertas;
    }

    //Metodos contadores
    public void aumentarContadorCreacion() {
        contadorCreacion++;
    }

    public void resetCotnadorCreacion() {
        contadorCreacion = 0;
    }

    public void aumentarContador5() {
        contadorOperaciones5++;
    }

    public void resetContador5() {
        contadorOperaciones5 = 0;
    }

    public void aumentarContador10() {
        contadorOperaciones10++;
    }

    public void resetContador10() {
        contadorOperaciones10 = 0;
    }

    public void aumentarContador15() {
        contadorOperaciones15++;
    }

    public void resetContador15() {
        contadorOperaciones15 = 0;
    }

    public void aumentarContador30() {
        contadorOperaciones30++;
    }

    public void resetContador30() {
        contadorOperaciones30 = 0;
    }

    //Metodos generales
    public void muerteArboles(int cantidad) {
        arboles -= cantidad;
    }

    public void darDineroATodos(double dinero) {
        for (Doctor d : listaDoctores)
            d.setDinero(d.getDinero() + dinero);
        for (Cocinero c : listaCocineros)
            c.setDinero(c.getDinero() + dinero);
        for (Albañil a : listaAlbaniles)
            a.setDinero(a.getDinero() + dinero);
        for (Herrero h : listaHerreros)
            h.setDinero(h.getDinero() + dinero);
        for (Carpintero c : listaCarpinteros)
            c.setDinero(c.getDinero() + dinero);
    }

    public void sembrarArbol() {
        arboles++;
        gobierno.sembrarArbol();
    }

    public Persona buscarPersona(int idPersona) {

        Persona p = null;

        p = this.buscarDoctor(idPersona);
        if (p != null)
            return p;
        p = this.buscarCocinero(idPersona);
        if (p != null)
            return p;
        p = this.buscarAlbanil(idPersona);
        if (p != null)
            return p;
        p = this.buscarHerrero(idPersona);
        if (p != null)
            return p;
        p = this.buscarCarpintero(idPersona);
        if (p != null)
            return p;
        return p;
    }

    public Boolean conducirBicicleta(Persona p) {
        return p.conducirBicicleta();
    }

    public void enfermarPersona(Persona p) {
        p.cambiarEstadoSalud(false);
    }

    public void curarPersona(Persona p) {
        p.cambiarEstadoSalud(true);
    }

    public int contarPersonas() {
        int contador = 0;

        for (Persona p : this.getListaDoctores())
            contador++;
        for (Persona p : this.getListaCocineros())
            contador++;
        for (Persona p : this.getListaAlbaniles())
            contador++;
        for (Persona p : this.getListaHerreros())
            contador++;
        for (Persona p : this.getListaCocineros())
            contador++;

        return contador;
    }

    public int getRandom1and2() {
        Random rand = new Random();
        int numero = rand.nextInt(2);
        return numero;
    }


    //Gobierno
    public void pagarAGobierno(double cantidad) {
        this.gobierno.recibirDinero(cantidad);
    }

    public void gobiernoDarDinero(double cantidad) {
        this.gobierno.darDinero(cantidad);
    }

    //Vehiculos
    public void agregarAutomovil(Persona p) {
        /**
         * Agrega un automovil a la persona
         */
        p.agregarAutomovil();
    }


    //Doctores
    public void crearDoctor(Doctor d) {
        listaDoctores.add(d);
    }

    public Doctor buscarDoctor(int idDoctor) {
        for (Doctor d : listaDoctores) {
            if (d.getId() == idDoctor)
                return d;
        }
        return null;
    }


    //Concineros
    public void crearCocinero(Cocinero c) {
        listaCocineros.add(c);
    }

    public void cocineroGanarDinero(Cocinero c, double cantidad) {
        c.ganarDinero(cantidad);
    }

    public void cocineroAgregarReceta(Cocinero c, String r) {
        c.agregarReceta(r);
    }

    public ArrayList<String> cocineroGetRecetas(Cocinero c) {
        return c.getRecetas();
    }

    public Cocinero buscarCocinero(int idCocinero) {
        for (Cocinero c : listaCocineros) {
            if (c.getId() == idCocinero)
                return c;
        }
        return null;
    }


    //Albaniles
    public void crearAlbanil(Albañil a) {
        listaAlbaniles.add(a);
    }

    public void pagarConstruccionAlbanil(Albañil a, double cantidad) {
        a.ganarDinero(cantidad);
    }

    public Albañil buscarAlbanil(int idAlbanil) {
        for (Albañil a : listaAlbaniles) {
            if (a.getId() == idAlbanil)
                return a;
        }
        return null;
    }

    //Herreros
    public void crearHerrero(Herrero h) {
        listaHerreros.add(h);
    }

    public void pagarConstruccionHerreros(Herrero h, double cantidad) {
        h.ganarDinero(cantidad);
    }

    public Herrero buscarHerrero(int idHerrero) {
        for (Herrero h : listaHerreros) {
            if (h.getId() == idHerrero)
                return h;
        }
        return null;
    }

    public void construirBicicleta(Herrero h, double precio) {
        h.construirBicicleta(precio);
    }


    //Carpinteros
    public void crearCarpintero(Carpintero c) {
        listaCarpinteros.add(c);
    }

    public void pagarConstruccionCarpintero(Carpintero c, double cantidad) {
        c.ganarDinero(cantidad);
    }

    public Carpintero buscarCarpintero(int idCarpintero) {
        for (Carpintero c : listaCarpinteros) {
            if (c.getId() == idCarpintero)
                return c;
        }
        return null;
    }

}

