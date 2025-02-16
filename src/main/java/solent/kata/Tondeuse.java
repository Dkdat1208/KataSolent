package solent.kata;

public class Tondeuse {
    private int x, y;
    private char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void tournerADroite() {
        switch (orientation) {
            case 'N': orientation = 'E'; break;
            case 'E': orientation = 'S'; break;
            case 'S': orientation = 'W'; break;
            case 'W': orientation = 'N'; break;
            default : throw new IllegalArgumentException("Erreur cette direction n'existe pas: " +  orientation);

        }
    }

    public void tournerAGauche() {
        switch (orientation) {
            case 'N': orientation = 'W'; break;
            case 'W': orientation = 'S'; break;
            case 'S': orientation = 'E'; break;
            case 'E': orientation = 'N'; break;
            default : throw new IllegalArgumentException("Erreur cette direction n'existe pas: " +  orientation);

        }
    }

    public void avancer(Pelouse pelouse) {
        int newX = x, newY = y;
        switch (orientation) {
            case 'N': newY++; break;
            case 'E': newX++; break;
            case 'S': newY--; break;
            case 'W': newX--; break;
            default : throw new IllegalArgumentException("Erreur cette direction n'existe pas: " +  orientation);

        }
        if (pelouse.estDansLesLimites(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void executerInstructions(String instructions, Pelouse pelouse) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G': tournerAGauche(); break;
                case 'D': tournerADroite(); break;
                case 'A': avancer(pelouse); break;
            }
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public char getOrientation() { return orientation; }
}
