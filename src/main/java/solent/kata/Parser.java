package solent.kata;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Tondeuse> lireFichier(String contenu, Pelouse pelouse) {
        String[] lignes = contenu.split("\\n");
        List<Tondeuse> tondeuses = new ArrayList<>();

        for (int i = 1; i < lignes.length; i += 2) {
            String[] position = lignes[i].split(" ");
            int x = Integer.parseInt(position[0]);
            int y = Integer.parseInt(position[1]);
            char orientation = position[2].charAt(0);

            Tondeuse tondeuse = new Tondeuse(x, y, orientation);
            tondeuse.executerInstructions(lignes[i + 1], pelouse);
            tondeuses.add(tondeuse);
        }
        return tondeuses;
    }
}
