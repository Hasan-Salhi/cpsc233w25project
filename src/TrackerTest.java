import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CPSC 233 W25 Project TrackerTest Class
 * A class for testing the Tracker class.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.3 - March 3, 2025
 */
public class TrackerTest extends Tracker {
    private static ArrayList<Integer> teams = new ArrayList<>();
    private static ArrayList<ArrayList<Object>> statistics = new ArrayList<>();

    @Test
    void testAddTeam() {
    }

    @Test
    void testAddPokemon() {
    }

    @Test
    void testAddMove() {
    }

    @Test
    void testAddItem() {
    }

    /**
     * Done by Jade Torres.
     */
    @Test
    void testAddWin() {
        Tracker.addTeam();

        //Adds 2 Pokemon to a team.
        Tracker.addPokemon(1, "Pikachu", 0, 0, "", "");
        Tracker.addPokemon(1, "Bulbasaur", 0, 0, "", "");

        //Adds 2 wins to Pikachu and 1 win to Bulbasaur.
        Tracker.addWin("Pikachu");
        Tracker.addWin("Pikachu");
        Tracker.addWin("Bulbasaur");

        String expected = """
                
                ********************
                
                Team Number: 1
                Pokemon: Pikachu
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 2
                Losses: 0
                
                ********************
                
                Team Number: 1
                Pokemon: Bulbasaur
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 1
                Losses: 0""";
        String actual = Tracker.getAllPokemon();
        assertEquals(expected, actual);
    }

    /**
     * Done by Jade Torres.
     */
    @Test
    void testAddLoss() {
        Tracker.addTeam();

        //Adds 2 Pokemon to a team.
        Tracker.addPokemon(1, "Pikachu", 0, 0, "", "");
        Tracker.addPokemon(1, "Bulbasaur", 0, 0, "", "");

        //Adds 2 losses to Pikachu and 1 loss to Bulbasaur.
        Tracker.addLoss("Pikachu");
        Tracker.addLoss("Pikachu");
        Tracker.addLoss("Bulbasaur");

        String expected = """
                
                ********************
                
                Team Number: 1
                Pokemon: Pikachu
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 0
                Losses: 2
                
                ********************
                
                Team Number: 1
                Pokemon: Bulbasaur
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 0
                Losses: 1""";
        String actual = Tracker.getAllPokemon();
        assertEquals(expected, actual);
    }

    /**
     * Done by Jade Torres.
     */
    @Test
    void testGetAllPokemon() {
        Tracker.addTeam();

        //Adds 2 Pokemon to a team.
        Tracker.addPokemon(1, "Charizard", 0, 0, "", "");
        Tracker.addPokemon(1, "Totodile", 0, 0, "", "");

        String expected = """
                
                ********************
                
                Team Number: 1
                Pokemon: Charizard
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 0
                Losses: 0
                
                ********************
                
                Team Number: 1
                Pokemon: Totodile
                HP: 0
                Attack: 0
                Type:\s
                Second Type:\s
                Move:\s
                Item:\s
                Wins: 0
                Losses: 0""";
        String actual = Tracker.getAllPokemon();
        assertEquals(expected, actual);
    }

    /**
     * Testing getTopAttack
     * Done by Jordan Tran
     */
    @Test
    void testGetTopAttack() {
        Tracker.addTeam();
        Tracker.addPokemon(1, "good",83,50,"normal","none"); //normal primary
        Tracker.addPokemon(1, "good2",100,70,"none","normal"); // normal secondary
        Tracker.addPokemon(1, "good3",25,100,"Normal","none"); // normal (capital edition)
        Tracker.addPokemon(1, "invalid",70,20,"Fighting","Steel"); // non-normal type
        // copied from getTopHP.
        String testString = "\nThe Pokemon with the highest Attack are: good3, good2, good";
        String actual = Tracker.getTopAttack();
        assertEquals(testString, actual);
    }

    /**
     * Testing getTopHP
     * Done by Jordan Tran
     */
    @Test
    void testGetTopHP() {
        Tracker.addTeam();
        Tracker.addPokemon(1, "good",83,50,"normal","none"); //normal primary
        Tracker.addPokemon(1, "good2",100,70,"none","normal"); // normal secondary
        Tracker.addPokemon(1, "good3",25,100,"Normal","none"); // normal (capital edition)
        Tracker.addPokemon(1, "invalid",70,20,"Fighting","Steel"); // non-normal type
        // copied from averageAttack test, but with changed hp.
        String testString = "\nThe Pokemon with the highest HP are: good2, good, invalid";
        String actual = Tracker.getTopHP();
        assertEquals(testString, actual);
    }

    /**
     * Testing getAverageAttack
     * Done by Jordan Tran
     */
    @Test
    void testGetAverageAttack() {
        Tracker.addTeam();
        Tracker.addPokemon(1, "good",0,50,"normal","none"); //normal primary
        Tracker.addPokemon(1, "good2",0,70,"none","normal"); // normal secondary
        Tracker.addPokemon(1, "good3",0,100,"Normal","none"); // normal (capital edition)
        Tracker.addPokemon(1, "invalid",0,20,"Fighting","Steel"); // non-normal type
        // copied from getAllType test, but with changed attack.
        String testString = ("\nThe average Attack value of all Pokemon is: 60 Attack.");
        String actual = Tracker.getAverageAttack();
        assertEquals(testString, actual);
    }

    /**
     * Testing the getAllType method.
     * Ensure that it returns only Pokemon of the specified type, regardless of primary or secondary typing.
     * Done by Jordan Tran.
     */
    @Test
     void testGetAllType(){
        Tracker.addTeam();
        Tracker.addPokemon(1, "good",0,0,"normal","none"); //normal primary
        Tracker.addPokemon(1, "good2",0,0,"none","normal"); // normal secondary
        Tracker.addPokemon(1, "good3",0,0,"Normal","none"); // normal (capital edition)
        Tracker.addPokemon(1, "invalid",0,0,"Fighting","Steel"); // non-normal type

        String testString = ("\nPokemon with normal as a primary or secondary type:\ngood\ngood2\ngood3\n");
        String actual = Tracker.getAllType("normal");
        assertEquals(testString, actual);
    }
}
