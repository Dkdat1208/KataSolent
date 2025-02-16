package solent;

import solent.kata.Parser;
import solent.kata.Pelouse;
import solent.kata.Simulation;
import solent.kata.Tondeuse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class KataSolentApp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar tondeuse.jar <fichier_d_entree>");
            return;
        }

        String cheminFichier = args[0];
        try {
            List<String> lignes = Files.readAllLines(Paths.get(cheminFichier));
            if (lignes.isEmpty()) {
                System.out.println("Fichier vide");
                return;
            }

            // Lecture des dimensions de la pelouse
            String[] dimensions = lignes.get(0).split(" ");
            int largeur = Integer.parseInt(dimensions[0]);
            int hauteur = Integer.parseInt(dimensions[1]);
            Pelouse pelouse = new Pelouse(largeur, hauteur);

            // Lecture et exécution des tondeuses
            List<Tondeuse> tondeuses = Parser.lireFichier(String.join("\n", lignes), pelouse);
            Simulation simulation = new Simulation(pelouse, tondeuses);
            simulation.executer();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
