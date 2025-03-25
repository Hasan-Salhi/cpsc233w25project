import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.io.*;

/**
 * CPSC 233 W25 Project TrackerTest Class
 * A class for testing the Tracker, Team, and Pokemon classes.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 2.0 - March 18, 2025
 */
public class TrackerTest extends Tracker {
    /**
     * Resets the tracker before each test.
     */
    @BeforeEach
    void clearTracker() {
        Team.resetTotal();
        Tracker.emptyTeams();
    }

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

    @Test
    void getNumber() {
        Team teamOne = new Team();
        Team teamTwo = new Team();
        Team teamThree = new Team();

        int expected = 2;
        int actual = teamTwo.getNumber();
        assertEquals(expected, actual);
    }

    @Test
    void getPokemon() {
        Team team = new Team();
        Pokemon pikachu = new Pokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        Pokemon squirtle = new Pokemon("Squirtle", 10, 10, Type.WATER, Type.NONE);
        Pokemon charmander = new Pokemon("Charmander", 10, 10, Type.FIRE, Type.NONE);
        team.addPokemon(pikachu);
        team.addPokemon(squirtle);
        team.addPokemon(charmander);

        ArrayList<Pokemon> expected = new ArrayList<>();
        expected.add(pikachu);
        expected.add(squirtle);
        expected.add(charmander);
        ArrayList<Pokemon> actual = team.getPokemon();
        assertEquals(expected, actual);
    }

    @Test
    void teamToString() {
        Team team = new Team();
        Pokemon pikachu = new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);
        Pokemon squirtle = new Pokemon("Squirtle", 20, 10, Type.WATER, Type.NONE);
        team.addPokemon(pikachu);
        team.addPokemon(squirtle);
        pikachu.addMove("Charge");
        pikachu.addItem("Bug Gem");
        pikachu.addWin();
        pikachu.addWin();
        squirtle.addMove("Aqua Jet");
        squirtle.addItem("Big Root");
        squirtle.addWin();

        String expected = """
                ********************
                
                \tTEAM #1
                
                Pokemon: Pikachu
                HP: 10
                Attack: 20
                Type: ELECTRIC
                Second Type: NONE
                Move: Charge
                Item: Bug Gem
                Wins: 2
                Losses: 0
                
                Pokemon: Squirtle
                HP: 20
                Attack: 10
                Type: WATER
                Second Type: NONE
                Move: Aqua Jet
                Item: Big Root
                Wins: 1
                Losses: 0""";
        String actual = team.toString();
        assertEquals(expected, actual);
    }

    /**
     * Tests done by Jordan Tran.
     */

    @Test
    void testGetAllPokemon(){
        Team team = new Team();
        Team teamTwo = new Team();
        Pokemon aron = new Pokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new Pokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

        team.addPokemon(aron);
        teamTwo.addPokemon(pidgey);

        Tracker.teams.add(team);
        Tracker.teams.add(teamTwo);

        String expected = """
                
                ********************
                
                \tTEAM #1
                
                Pokemon: Aron
                HP: 50
                Attack: 30
                Type: STEEL
                Second Type: ROCK
                Move: null
                Item: null
                Wins: 0
                Losses: 0
                ********************
                
                \tTEAM #2
                
                Pokemon: Pidgey
                HP: 50
                Attack: 20
                Type: NORMAL
                Second Type: FLYING
                Move: null
                Item: null
                Wins: 0
                Losses: 0""";

        assertEquals(expected, getAllPokemon());
    }

    @Test
    void testPrintMenu(){
        String expected = """
                
                ********************
                
                \tPOKEMON TRACKER
                
                Add Data
                1) add a team
                2) add a Pokemon to a team with a name, HP (Hit Points),
                   Attack value, type, and second type (optional)
                
                Add Pokemon Data
                3) add a move to a Pokemon (max. 1)
                4) add an item to a Pokemon (max. 1)
                5) add a win to a Pokemon
                6) add a loss to a Pokemon
                
                Output General
                7) list all Pokemon
                
                Output Special
                8) list the top 3 Pokemon with the highest Attack
                9) list the top 3 Pokemon with the highest HP
                10) get the average Attack of all Pokemon
                11) list all Pokemon of a certain type
                
                Save Data
                12) Load data from a file
                13) Write data to a file
                """;
        assertEquals(expected, getMenu());
    }

    @Test
    void testGetAvgAtk(){
        Team team = new Team();
        Team teamTwo = new Team();
        Pokemon aron = new Pokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new Pokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

        team.addPokemon(aron);
        teamTwo.addPokemon(pidgey);

        Tracker.teams.add(team);
        Tracker.teams.add(teamTwo);

        String expected = "\nThe average attack value of all Pokemon in the Tracker is: " + 25 + " ATK.";
        String actual = "\nThe average attack value of all Pokemon in the Tracker is: " + getAvgAtk() + " ATK.";

        assertEquals(expected,actual);
    }

    @Test
    void testReadFile(){
        //simply need to test that something exists when reading the file
        // for a more accurate test, run Tracker.java and then try importing
        Tracker.readFile("Tracker.csv");
        assertNotEquals(null, Tracker.teams);
    }

    @Test
    void testWriteFile(){
        Team team = new Team();
        Team teamTwo = new Team();
        Pokemon aron = new Pokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new Pokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

        team.addPokemon(aron);
        teamTwo.addPokemon(pidgey);
        //testing team
        Tracker.teams.add(team);
        Tracker.teams.add(teamTwo);

        Tracker.writeFile("testing.csv");
        Tracker.readFile("testing.csv"); // write file then read said file to make sure it is not empty
        assertNotEquals(null, Tracker.teams);
    }

    /**
     * Tests done by Hasan Salhi.
     */

    //TODO: ADD TESTS
}