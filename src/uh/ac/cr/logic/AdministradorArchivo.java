package uh.ac.cr.logic;

import uh.ac.cr.model.Mundo;
import uh.ac.cr.model.Gobierno;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdministradorArchivo {


    public AdministradorArchivo() {

    }
    public void saveFile(Mundo world) {

        String worldToSave = "" +
                "<world-name>\n" +
                world.getName() + "\n" +
                "<GovernmentCapital>\n" +
                world.g
        world.getGobierno().getCapitalEconomico() + "\n" +
                "<GovernmentPresident>\n" +
                world.getLocalGovernment().getPresident() + "\n" +
                "<Streets>" +
                world.streetsToText() +
                "</Streets>\n" +
                "<Avenues>" +
                world.avenuesToText() +
                "</Avenues>\n" +
                "<Intersections>" +
                "</Intersections>";
        try {
            fileWriter = new FileWriter(world.getName() + ".txt");
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

    public void readFile() {
        //todo
    }

}