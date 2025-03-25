import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

    //TODO: ADD TESTS

    /**
     * Tests done by Hasan Salhi.
     */

    @Test
    void addTeamTest() {
        ArrayList<Team> expectedList = new ArrayList<>();
        expectedList.add(new Team());
        int expected = expectedList.getFirst().getNumber();
        Team.resetTotal();
        Tracker.addTeam();
        int actual = Tracker.teams.getFirst().getNumber();
        assertEquals(expected,actual);
    }

    @Test
    void testTopHP() {
        Tracker.addTeam();
        Tracker.teams.getFirst().addPokemon(new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Highest: Charizard with 40 HP\nSecond: Squirtle with 25 HP\nThird: Charmander with 20 HP";
        String actual = Tracker.getTopHP();
        assertEquals(expected, actual);
    }

    @Test
    void testTopAtk() {
        Tracker.addTeam();
        Tracker.teams.getFirst().addPokemon(new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Highest: Charizard with 20 Attack\nSecond: Pikachu with 20 Attack\nThird: Charmander with 10 Attack";
        String actual = Tracker.getTopAttack();
        assertEquals(expected, actual);
    }

    @Test
    void testAllType() {
        Tracker.addTeam();
        Tracker.teams.getFirst().addPokemon(new Pokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new Pokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Charmander\nCharizard\n";
        String actual = Tracker.getAllType(Type.FIRE);
        assertEquals(expected, actual);
    }


}