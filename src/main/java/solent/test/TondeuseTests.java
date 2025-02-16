package solent.test;

import org.junit.jupiter.api.Test;
import solent.kata.Pelouse;
import solent.kata.Tondeuse;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TondeuseTests {
    @Test
   public void testRotationVersLaDroite() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        tondeuse.tournerADroite();
        assertEquals('E', tondeuse.getOrientation());
    }

    @Test
   public void testRotationVersLaGauche() {
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        tondeuse.tournerAGauche();
        assertEquals('W', tondeuse.getOrientation());
    }

    @Test
    public void  testAvancerDansLaPelouse() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        tondeuse.avancer(pelouse);
        assertEquals(1, tondeuse.getX());
        assertEquals(3, tondeuse.getY());
    }

    @Test
   public void testAvancerHorsLimite() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(0, 5, 'N');
        tondeuse.avancer(pelouse);
        assertEquals(0, tondeuse.getX());
        assertEquals(5, tondeuse.getY());
    }

    @Test
   public void testExecutionInstructions() {
        Pelouse pelouse = new Pelouse(5, 5);
        Tondeuse tondeuse = new Tondeuse(1, 2, 'N');
        tondeuse.executerInstructions("GAGAGAGAA", pelouse);
        assertEquals(1, tondeuse.getX());
        assertEquals(3, tondeuse.getY());
        assertEquals('N', tondeuse.getOrientation());
    }

    @Test
   public void testScenarioInitial() {
        Pelouse pelouse = new Pelouse(5, 5);

        Tondeuse tondeuse1 = new Tondeuse(1, 2, 'N');
        tondeuse1.executerInstructions("GAGAGAGAA", pelouse);
        assertEquals(1, tondeuse1.getX());
        assertEquals(3, tondeuse1.getY());
        assertEquals('N', tondeuse1.getOrientation());

        Tondeuse tondeuse2 = new Tondeuse(3, 3, 'E');
        tondeuse2.executerInstructions("AADAADADDA", pelouse);
        assertEquals(5, tondeuse2.getX());
        assertEquals(1, tondeuse2.getY());
        assertEquals('E', tondeuse2.getOrientation());
    }
}
