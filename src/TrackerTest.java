import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CPSC 233 W25 Project TrackerTest Class
 * A class for testing the Tracker, Team, and Pokemon classes.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 2.0 - March 18, 2025
 */
public class TrackerTest extends Tracker {

    /**
     * Tests done by Jade Torres.
     */

    @Test
    void getName() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        String expected = "Pikachu";
        String actual = pikachu.getName();
        assertEquals(expected, actual);
    }

    @Test
    void getHP() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);

        int expected = 10;
        int actual = pikachu.getHP();
        assertEquals(expected, actual);
    }

    @Test
    void getAttack() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);

        int expected = 20;
        int actual = pikachu.getAttack();
        assertEquals(expected, actual);
    }

    @Test
    void getTypeOne() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        Type expected = Type.ELECTRIC;
        Type actual = pikachu.getTypeOne();
        assertEquals(expected, actual);
    }

    @Test
    void getTypeTwo() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        Type expected = Type.NONE;
        Type actual = pikachu.getTypeTwo();
        assertEquals(expected, actual);
    }

    @Test
    void getMove() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addMove("Tackle");
        pikachu.addMove("Charge");

        String expected = "Charge";
        String actual = pikachu.getMove();
        assertEquals(expected, actual);
    }

    @Test
    void getItem() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addItem("Big Root");
        pikachu.addItem("Bug Gem");

        String expected = "Bug Gem";
        String actual = pikachu.getItem();
        assertEquals(expected, actual);
    }

    @Test
    void getWins() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addWin();
        pikachu.addWin();
        pikachu.addWin();

        int expected = 3;
        int actual = pikachu.getWins();
        assertEquals(expected, actual);
    }

    @Test
    void getLosses() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addLoss();
        pikachu.addLoss();

        int expected = 2;
        int actual = pikachu.getLosses();
        assertEquals(expected, actual);
    }

    @Test
    void pokemonToString() {
        Pokemon pikachu = new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);
        pikachu.addMove("Charge");
        pikachu.addItem("Bug Gem");
        pikachu.addWin();
        pikachu.addWin();

        String expected = """
                Pokemon: Pikachu
                HP: 10
                Attack: 20
                Type: ELECTRIC
                Second Type: NONE
                Move: Charge
                Item: Bug Gem
                Wins: 2
                Losses: 0""";
        String actual = pikachu.toString();
        assertEquals(expected, actual);
    }

    /**
     * Tests done by Jordan Tran.
     */

    //TODO: ADD TESTS

    /**
     * Tests done by Hasan Salhi.
     */

    //TODO: ADD TESTS
}