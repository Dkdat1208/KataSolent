package solent.kata;

import java.util.List;

public class Simulation {
    private final Pelouse pelouse;
    private final List<Tondeuse> tondeuses;

    public Simulation(Pelouse pelouse, List<Tondeuse> tondeuses) {
        this.pelouse = pelouse;
        this.tondeuses = tondeuses;
    }

    public void executer() {
        for (Tondeuse tondeuse : tondeuses) {
            System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
        }
    }
}
