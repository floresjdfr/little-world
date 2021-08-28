package uh.ac.cr.logic;

import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.Gobierno;
import uh.ac.cr.model.persona.*;
import uh.ac.cr.model.prestamo.Prestamo;
import uh.ac.cr.model.vehiculo.Automovil;
import uh.ac.cr.model.vehiculo.Bicicleta;
import uh.ac.cr.model.vehiculo.Vehiculo;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdministradorArchivo {

    private Mundo mundo;

    public AdministradorArchivo(Mundo mundo) {
        this.mundo = mundo;
    }

    public void saveFile(String nombre) {

        String worldToSave = mundo.toFile();
        FileWriter fileWriter = null;
        File file = new File(nombre + ".txt");
        if (file != null)
            file.delete();
        try {
            fileWriter = new FileWriter(nombre + ".txt");
            fileWriter.write(worldToSave);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error closing the file.");
                    e.printStackTrace();
                }
            }
        }
    }

    public Mundo readFile(String nombre) {
        nombre += ".txt";
        Mundo mundo = null;
        String[] nombreCompleto = nombre.split(" ");
        nombre = nombreCompleto[nombreCompleto.length-1];

        try {
            File file = new File(nombre);
            Scanner myReader = new Scanner(file);

             mundo = this.readMundo(myReader);

            myReader.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return mundo;
    }

    Mundo readMundo(Scanner reader) {

        String consulta = reader.nextLine();

        String name = reader.nextLine();
        int arboles = reader.nextInt();
        int contadorCreacion = reader.nextInt();
        int contadorOperaciones5 = reader.nextInt();
        int contadorOperaciones10 = reader.nextInt();
        int contadorOperaciones15 = reader.nextInt();
        int contadorOperaciones30 = reader.nextInt();
        int personasMuertas = reader.nextInt();
        reader.nextLine();

        consulta = reader.nextLine();//Empeza a leer <gobierno>
        Gobierno gobierno = this.readGobierno(reader);
        consulta = reader.nextLine();//Termina <gobierno>
        ArrayList<Doctor> listaDoctores = this.readDoctores(reader);
        ArrayList<Cocinero> listaCocineros = this.readCocineros(reader);
        ArrayList<Albañil> listaAlbaniles = this.readAlbaniles(reader);
        ArrayList<Herrero> listaHerreros = this.readHerreros(reader);
        ArrayList<Carpintero> listaCarpinteros = this.readCarpinteros(reader);

        return new Mundo(name, arboles, contadorCreacion, contadorOperaciones5, contadorOperaciones10,
                contadorOperaciones15, contadorOperaciones30, personasMuertas, gobierno,
                listaDoctores, listaCocineros, listaAlbaniles, listaHerreros, listaCarpinteros);
    }

    Gobierno readGobierno(Scanner scanner) {
        String aux = scanner.nextLine();
        double capital = Double.parseDouble(aux);
        ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);
        return new Gobierno(capital, prestamos);
    }

    Prestamo readPrestamo(Scanner scanner) {
        String consulta;
        String aux;
        int idPrestamista = scanner.nextInt();
        int idInteresado = scanner.nextInt();
        scanner.nextLine();
        aux = scanner.nextLine();
        double totalPrestamo = Double.parseDouble(aux);
        aux = scanner.nextLine();
        double pendientePago = Double.parseDouble(aux);
        boolean estado = scanner.nextBoolean();
        consulta = scanner.nextLine();
        return new Prestamo(idPrestamista, idInteresado, totalPrestamo, pendientePago, estado);
    }

    ArrayList<Prestamo> readPrestamos(Scanner scanner) {
        String inicio = scanner.nextLine();//<prestamos>
        String consulta;
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        while (!scanner.nextLine().equals(inicio)) {//Prestamo
            prestamos.add(this.readPrestamo(scanner));
            consulta = scanner.nextLine();
        }

        return prestamos;
    }

    ArrayList<Vehiculo> readVehiculos(Scanner scanner) {
        String inicio = scanner.nextLine();//Inicia lectura de <vehiculos>
        String consulta;
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        while (!scanner.nextLine().equals(inicio)) {//Inicia lectura de <vehiculo>
            int numeroLlantas = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            if (numeroLlantas == 2) {
                boolean puedeSerConducida = scanner.nextBoolean();
                vehiculos.add(new Bicicleta(numeroLlantas, nombre, puedeSerConducida));
            } else {
                boolean puedeGanarIntereses = scanner.nextBoolean();
                vehiculos.add(new Automovil(numeroLlantas, nombre, puedeGanarIntereses));
            }
            consulta = scanner.nextLine();
            consulta = scanner.nextLine();
        }

        return vehiculos;
    }

    ArrayList<Doctor> readDoctores(Scanner scanner) {
        String inicio = scanner.nextLine();//Inicia <doctores>
        String aux;
        String consulta;
        ArrayList<Doctor> doctores = new ArrayList<>();

        while (!scanner.nextLine().equals(inicio)) {//Inicia a leer cada <doctor>

            int id = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            aux = scanner.nextLine();
            double dinero = Double.parseDouble(aux);
            int casa = scanner.nextInt();
            Boolean personaSaludable = scanner.nextBoolean();
            int contadorOperaciones5 = scanner.nextInt();
            int contadorOperaciones10 = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Vehiculo> vehiculos = this.readVehiculos(scanner);
            ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);
            String especialidad = scanner.nextLine();
            doctores.add(new Doctor(id, nombre, apellidos, dinero, casa, personaSaludable,
                    contadorOperaciones5, contadorOperaciones10, vehiculos,
                    prestamos, especialidad));
            consulta = scanner.nextLine();

        }
        return doctores;
    }

    ArrayList<Cocinero> readCocineros(Scanner scanner) {
        String inicio = scanner.nextLine();//Inicia <cocineros>
        String aux;
        String consulta;
        ArrayList<Cocinero> cocineros = new ArrayList<>();

        while (!scanner.nextLine().equals(inicio)) {//Inicia a leer cada <doctor>
            int id = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            aux = scanner.nextLine();
            double dinero = Double.parseDouble(aux);
            int casa = scanner.nextInt();
            scanner.nextLine();
            Boolean personaSaludable = scanner.nextBoolean();
            int contadorOperaciones5 = scanner.nextInt();
            int contadorOperaciones10 = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Vehiculo> vehiculos = this.readVehiculos(scanner);
            ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);
            String recetas = scanner.nextLine();
            ArrayList<String> arrayRecetas = new ArrayList<>();
            arrayRecetas.addAll(Arrays.asList(recetas.split(",")));
            cocineros.add(new Cocinero(id, nombre, apellidos, dinero, casa, personaSaludable,
                    contadorOperaciones5, contadorOperaciones10, vehiculos,
                    prestamos, arrayRecetas));
            consulta = scanner.nextLine();
        }
        return cocineros;
    }

    ArrayList<Albañil> readAlbaniles(Scanner scanner) {
        String inicio = scanner.nextLine();//Inicia <albaniles>
        String aux;
        String consulta;
        ArrayList<Albañil> albaniles = new ArrayList<>();

        while (!scanner.nextLine().equals(inicio)) {//Inicia a leer cada <albanil>
            int id = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            aux = scanner.nextLine();
            double dinero = Double.parseDouble(aux);
            int casa = scanner.nextInt();
            scanner.nextLine();
            Boolean personaSaludable = scanner.nextBoolean();
            int contadorOperaciones5 = scanner.nextInt();
            int contadorOperaciones10 = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Vehiculo> vehiculos = this.readVehiculos(scanner);
            ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);

            albaniles.add(new Albañil(id, nombre, apellidos, dinero, casa, personaSaludable,
                    contadorOperaciones5, contadorOperaciones10, vehiculos,
                    prestamos));
            consulta = scanner.nextLine();
        }
        return albaniles;
    }

    ArrayList<Herrero> readHerreros(Scanner scanner) {

        String inicio = scanner.nextLine();//Inicia <Herreros>
        String aux;
        String consulta;
        ArrayList<Herrero> herreros = new ArrayList<>();

        while (!scanner.nextLine().equals(inicio)) {//Inicia a leer cada <herrero>
            int id = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            aux = scanner.nextLine();
            double dinero = Double.parseDouble(aux);
            int casa = scanner.nextInt();
            scanner.nextLine();
            Boolean personaSaludable = scanner.nextBoolean();
            int contadorOperaciones5 = scanner.nextInt();
            int contadorOperaciones10 = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Vehiculo> vehiculos = this.readVehiculos(scanner);
            ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);

            herreros.add(new Herrero(id, nombre, apellidos, dinero, casa, personaSaludable,
                    contadorOperaciones5, contadorOperaciones10, vehiculos,
                    prestamos));
            consulta = scanner.nextLine();
        }
        return herreros;
    }

    ArrayList<Carpintero> readCarpinteros(Scanner scanner) {

        String inicio = scanner.nextLine();//Inicia <Carpinteros>
        String aux;
        String consulta;

        ArrayList<Carpintero> carpinteros = new ArrayList<>();

        while (!scanner.nextLine().equals(inicio)) {//Inicia a leer cada <Carpintero>
            int id = scanner.nextInt();
            scanner.nextLine();
            String nombre = scanner.nextLine();
            String apellidos = scanner.nextLine();
            aux = scanner.nextLine();
            double dinero = Double.parseDouble(aux);
            int casa = scanner.nextInt();
            scanner.nextLine();
            Boolean personaSaludable = scanner.nextBoolean();
            int contadorOperaciones5 = scanner.nextInt();
            int contadorOperaciones10 = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Vehiculo> vehiculos = this.readVehiculos(scanner);
            ArrayList<Prestamo> prestamos = this.readPrestamos(scanner);

            carpinteros.add(new Carpintero(id, nombre, apellidos, dinero, casa, personaSaludable,
                    contadorOperaciones5, contadorOperaciones10, vehiculos,
                    prestamos));
            consulta = scanner.nextLine();
        }
        return carpinteros;
    }




}