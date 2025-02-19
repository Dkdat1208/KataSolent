package solent.kata;

public class Pelouse {
    private final int largeur;
    private final int hauteur;

    public Pelouse(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public boolean estDansLesLimites(int x, int y) {
        return x >= 0 && x <= largeur && y >= 0 && y <= hauteur;
    }
}
