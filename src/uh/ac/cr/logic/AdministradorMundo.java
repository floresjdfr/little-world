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

public class AdministradorMundo {
    public ArrayList<uh.ac.cr.model.persona.Doctor> listaDoctor = new ArrayList<>();



    private static Object Gobierno;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Object Albañil;
    private static Object Doctor;
    private static Object Cocinero;
    private static Object Carpintero;
    private static Object Herrero;
    private static int listaAlbañil;
    private static int listaCarpintero;
    private static int listaHerrero;

    AdministradorArchivo administradorArchivo = new AdministradorArchivo();
    static Mundo mundo = null;

    public AdministradorMundo() {
    }

    public static void handleCommand(String currentCommand) {
            String NombreAlbañil= "";
            String ApellidoAlbañil= "";
            String IdAlbañil;

           String NombreDoctor= "";
           String ApellidoDoctor= "";
           String IdDoctor;

           String NombreCocinero= "";
           String ApellidoCocinero= "";
           String IdCocinero;

        String NombreCarpintero= "";
        String ApellidoCarpintero= "";
        String IdCarpintero;

        String NombreHerrero= "";
        String ApellidoHerrero= "";
        String IdHerrero;


        try {
            switch (currentCommand) {
                case "Crear mundo":
                    System.out.println("Crear mundo.");
                    if (mundo == null) {
                        System.out.println("Por favor escriba el nombre del nuevo mundo");
                        String worldName = reader.readLine();
                        //mundo = new Mundo(worldName);

                        mundo.setGobierno((uh.ac.cr.model.Gobierno) Gobierno);
                    } else {
                        System.out.println("You are on a world right now.");
                    }
                    break;
                case "Crear albañil":
                    if (mundo != null) {
                        listaAlbañil=listaAlbañil+1;
                        System.out.println("Please write the name of the albañil.");
                        NombreAlbañil = reader.readLine();
                        //Albañil = new Albañil(NombreAlbañil);
                        System.out.println("Please write the apellido of the albañil.");
                        ApellidoAlbañil = reader.readLine();
                        //Albañil = new Albañil(ApellidoAlbañil);
                        System.out.println("Please write the Id of the albañil.");
                        IdAlbañil = reader.readLine();
                        //Albañil = new Albañil(IdAlbañil);
                        boolean found = true;
                        if(Albañil == ""){


                            /*ico() >= 100000) (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } }else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }*/}
                    } else {
                        System.out.println("Creó el albañil.");
                    }
                    break;

                case "Crear doctor":
                    if (mundo != null) {
                        System.out.println("Please write the name of the doctor.");
                        NombreDoctor = reader.readLine();
                        //Doctor = new Doctor(NombreDoctor);
                        System.out.println("Please write the apellido of the doctor.");
                        ApellidoDoctor = reader.readLine();
                        //Doctor = new Doctor(ApellidoDoctor);
                        System.out.println("Please write the Id of the doctor.");
                        IdDoctor = reader.readLine();
                        //Doctor = new Doctor(IdDoctor);
                        if(Doctor == ""){
                                /*ico() >= 100000) (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } }else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }*/}
                    } else {
                        System.out.println("Creó el Doctor.");
                    }
                    break;
                case "Crear cocinero":
                    if (mundo != null) {
                        System.out.println("Please write the name of the Cocinero.");
                        NombreCocinero = reader.readLine();
                        //Cocinero = new Doctor(NombreCocinero);
                        System.out.println("Please write the apellido of the Cocinero.");
                        ApellidoCocinero = reader.readLine();
                        //Cocinero = new Doctor(ApellidoCocinero);
                        System.out.println("Please write the Id of the Cocinero.");
                        IdCocinero = reader.readLine();
                        //Doctor = new Doctor(IdCocinero);
                        if(Cocinero == ""){
                                /*ico() >= 100000) (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } }else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }*/}
                    } else {
                        System.out.println("Creó el Cocinero.");
                    }
                    break;
                case "Crear carpintero":
                    if (mundo != null) {
                        listaCarpintero=listaCarpintero+1;
                        System.out.println("Please write the name of the carpintero.");
                        NombreCarpintero = reader.readLine();
                        //Carpintero = new Carpintero(NombreCarpintero);
                        System.out.println("Please write the apellido of the carpintero.");
                        ApellidoCarpintero = reader.readLine();
                        //Carpintero = new Carpintero(ApellidoCarpintero);
                        System.out.println("Please write the Id of the carpintero.");
                        IdCarpintero = reader.readLine();
                        //Carpintero = new Carpintero(IdCarpintero);
                        if(Carpintero == ""){
                                /*ico() >= 100000) (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } }else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }*/}
                    } else {
                        System.out.println("Creó el Carpintero.");
                    }
                    break;

                case "Crear herrero":
                    if (mundo != null) {
                        listaHerrero=listaHerrero+1;
                        System.out.println("Please write the name of the herrero.");
                        NombreHerrero = reader.readLine();
                        //Herrero = new Herrero(NombreHerrero);
                        System.out.println("Please write the apellido of the herrero.");
                        ApellidoHerrero = reader.readLine();
                        //Herrero = new Herrero(ApellidoCarpintero);
                        System.out.println("Please write the Id of the herrero.");
                        IdHerrero = reader.readLine();
                        //Herrero = new Herrero(IdHerrero);
                        if(Herrero == ""){
                                /*ico() >= 100000) (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } }else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }*/}
                    } else {
                        System.out.println("Creó el Herrero.");
                    }
                    break;

                case "Crear casa":
                    if (listaAlbañil >= 3 & listaCarpintero >= 2 & listaHerrero >= 1) {

                    /*if (listaCarpintero >= 2) {

                    if (listaHerrero >= 1) {
                        System.out.println("se puede crear la casa.");
                    }}*/System.out.println("se puede crear la casa.");}

                    else {
                        System.out.println("NO se puede crear la casa.");

                    }
                    break;



              /*
                case "Create street":
                    if (world != null) {
                        System.out.println("Please write the name of the street.");
                        streetName = reader.readLine();
                        street = new Street(streetName);
                        if (world.getLocalGovernment().getEconomicCapital() >= 500) {
                            //Creating street.
                            world.addStreet(street);
                            //Reducing cost of street.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 500);
                            System.out.println("Street successfully created.");
                        } else {
                            System.out.println("Local government does not have enough money to build an street.");
                        }
                    } else {
                        System.out.println("You should create a world first.");
                    }
                    break;
                case "Create avenue":
                    if (world != null) {
                        System.out.println("Please write the name of the avenue.");
                        avenueName = reader.readLine();
                        avenue = new Avenue(avenueName);
                        if (world.getLocalGovernment().getEconomicCapital() >= 1000) {
                            //Creating avenue.
                            world.addAvenue(avenue);
                            //Reducing cost of avenue.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 1000);
                            System.out.println("Avenue successfully created.");
                        } else {
                            System.out.println("Local government does not have enough money to build an avenue.");
                        }
                    } else {
                        System.out.println("You should create a world first.");
                    }
                    break;
                case "Create intersection":
                    System.out.println("Create intersection.");
                    System.out.println("Please write the name of the street.");
                    streetName = reader.readLine();
                    System.out.println("Please write the name of the avenue.");
                    avenueName = reader.readLine();

                    //todo create intersection.

                    break;
                case "Create world":
                    System.out.println("Create world.");
                    if (world == null) {
                        System.out.println("Please write the name of the new world");
                        String worldName = reader.readLine();
                        world = new World(worldName);
                        LocalGovernment localGovernment = new LocalGovernment(50000);
                        world.setLocalGovernment(localGovernment);
                    } else {
                        System.out.println("You are on a world right now.");
                    }
                    break;
                case "Print world statistics":
                    if (world != null) {
                        System.out.println("World name: " + world.getName() + "\n");
                        System.out.println("World government president: " + world.getLocalGovernment().getPresident());
                        System.out.println("World government capital: " + world.getLocalGovernment().getEconomicCapital());
                        System.out.println("\nStreets:\n");
                        world.printStreets();
                        System.out.println("\nAvenues:\n");
                        world.printAvenues();
                        System.out.println("\nIntersections:\n");
                        world.printIntersections();
                    } else {
                        System.out.println("You should create a world first.");
                    }
                    break;
                case "Set president":
                    System.out.println("Set president");
                    if (world != null) {
                        if (world.getLocalGovernment().getEconomicCapital() >= 2000) {
                            System.out.println("Please write the name of the new president");
                            String presidentName = reader.readLine();
                            //Defining a new president.
                            world.getLocalGovernment().setPresident(presidentName);
                            //Reducing cost of setting a new president.
                            world.getLocalGovernment().setEconomicCapital(world.getLocalGovernment().getEconomicCapital() - 2000);
                            System.out.println("President successfully defined.");
                        }else{
                            System.out.println("Local government does not have enough money to set a new president.");
                        }
                    } else {
                        System.out.println("You should create a world first.");
                    }
                    break;
                case "Save world":
                    if(world != null){
                        fileHandler.saveFile(world);
                        System.out.println("World saved");
                    }else {
                        System.out.println("You should create a world first.");
                    }
                    break;
                case "Load world":
                    if(world == null){
                        fileHandler.readFile();
                    }else {
                        System.out.println("You are in a world right now.");
                    }
                    break;
                    */
                default:
                    System.out.println("No commands matched.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


            }
        }