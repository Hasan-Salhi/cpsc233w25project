import Pokemon.*;
import Type.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * CPSC 233 W25 Project TrackerTest Class
 * A class for testing the Tracker, Team, and Pokemon.Pokemon classes.
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
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        String expected = "Pikachu";
        String actual = pikachu.getName();
        assertEquals(expected, actual);
    }

    @Test
    void getHP() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);

        int expected = 10;
        int actual = pikachu.getHP();
        assertEquals(expected, actual);
    }

    @Test
    void getAttack() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);

        int expected = 20;
        int actual = pikachu.getAttack();
        assertEquals(expected, actual);
    }

    @Test
    void getTypeOne() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        Type expected = Type.ELECTRIC;
        Type actual = pikachu.getTypeOne();
        assertEquals(expected, actual);
    }

    @Test
    void getTypeTwo() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);

        Type expected = Type.NONE;
        Type actual = pikachu.getTypeTwo();
        assertEquals(expected, actual);
    }

    @Test
    void getMove() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addMove("Tackle");
        pikachu.addMove("Charge");

        String expected = "Charge";
        String actual = pikachu.getMove();
        assertEquals(expected, actual);
    }

    @Test
    void getItem() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addItem("Big Root");
        pikachu.addItem("Bug Gem");

        String expected = "Bug Gem";
        String actual = pikachu.getItem();
        assertEquals(expected, actual);
    }

    @Test
    void getWins() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addWin();
        pikachu.addWin();
        pikachu.addWin();

        int expected = 3;
        int actual = pikachu.getWins();
        assertEquals(expected, actual);
    }

    @Test
    void getLosses() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        pikachu.addLoss();
        pikachu.addLoss();

        int expected = 2;
        int actual = pikachu.getLosses();
        assertEquals(expected, actual);
    }

    @Test
    void pokemonToString() {
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);
        pikachu.addMove("Charge");
        pikachu.addItem("Bug Gem");
        pikachu.addWin();
        pikachu.addWin();

        String expected = """
                Pokemon.Pokemon: Pikachu
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
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 10, Type.ELECTRIC, Type.NONE);
        Pokemon squirtle = new WaterPokemon("Squirtle", 10, 10, Type.WATER, Type.NONE);
        Pokemon charmander = new FirePokemon("Charmander", 10, 10, Type.FIRE, Type.NONE);
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
        Pokemon pikachu = new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE);
        Pokemon squirtle = new WaterPokemon("Squirtle", 20, 10, Type.WATER, Type.NONE);
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
                
                Pokemon.Pokemon: Pikachu
                HP: 10
                Attack: 20
                Type: ELECTRIC
                Second Type: NONE
                Move: Charge
                Item: Bug Gem
                Wins: 2
                Losses: 0
                
                Pokemon.Pokemon: Squirtle
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
        Pokemon aron = new SteelPokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new NormalPokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

        team.addPokemon(aron);
        teamTwo.addPokemon(pidgey);

        Tracker.teams.add(team);
        Tracker.teams.add(teamTwo);

        String expected = """
                
                ********************
                
                \tTEAM #1
                
                Pokemon.Pokemon: Aron
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
                
                Pokemon.Pokemon: Pidgey
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
                2) add a Pokemon.Pokemon to a team with a name, HP (Hit Points),
                   Attack value, type, and second type (optional)
                
                Add Pokemon.Pokemon Data
                3) add a move to a Pokemon.Pokemon (max. 1)
                4) add an item to a Pokemon.Pokemon (max. 1)
                5) add a win to a Pokemon.Pokemon
                6) add a loss to a Pokemon.Pokemon
                
                Output General
                7) list all Pokemon.Pokemon
                
                Output Special
                8) list the top 3 Pokemon.Pokemon with the highest Attack
                9) list the top 3 Pokemon.Pokemon with the highest HP
                10) get the average Attack of all Pokemon.Pokemon
                11) list all Pokemon.Pokemon of a certain type
                
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
        Pokemon aron = new SteelPokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new NormalPokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

        team.addPokemon(aron);
        teamTwo.addPokemon(pidgey);

        Tracker.teams.add(team);
        Tracker.teams.add(teamTwo);

        String expected = "\nThe average attack value of all Pokemon.Pokemon in the Tracker is: " + 25 + " ATK.";
        String actual = "\nThe average attack value of all Pokemon.Pokemon in the Tracker is: " + getAvgAtk() + " ATK.";

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
        Pokemon aron = new SteelPokemon("Aron", 50, 30, Type.STEEL, Type.ROCK);
        Pokemon pidgey = new NormalPokemon("Pidgey", 50, 20, Type.NORMAL, Type.FLYING);

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
        Tracker.teams.getFirst().addPokemon(new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new WaterPokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Highest: Charizard with 40 HP\nSecond: Squirtle with 25 HP\nThird: Charmander with 20 HP";
        String actual = Tracker.getTopHP();
        assertEquals(expected, actual);
    }

    @Test
    void testTopAtk() {
        Tracker.addTeam();
        Tracker.teams.getFirst().addPokemon(new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new WaterPokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Highest: Charizard with 20 Attack\nSecond: Pikachu with 20 Attack\nThird: Charmander with 10 Attack";
        String actual = Tracker.getTopAttack();
        assertEquals(expected, actual);
    }

    @Test
    void testAllType() {
        Tracker.addTeam();
        Tracker.teams.getFirst().addPokemon(new ElectricPokemon("Pikachu", 10, 20, Type.ELECTRIC, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new WaterPokemon("Squirtle", 25, 10, Type.WATER, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charmander", 20, 10, Type.FIRE, Type.NONE));
        Tracker.teams.getFirst().addPokemon(new FirePokemon("Charizard",40,20,Type.FIRE,Type.DRAGON));

        String expected = "Charmander\nCharizard\n";
        String actual = Tracker.getAllType(Type.FIRE);
        assertEquals(expected, actual);
    }


}