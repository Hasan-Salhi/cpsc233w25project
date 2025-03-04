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

    /**
     * Testing addTeam
     * Done by Hasan Salhi
     */
    @Test
    void testAddTeamFromEmpty() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0,1);
        teams.clear();

        //teams starts out empty before we add a new one
        Tracker.addTeam();
        ArrayList<Integer> actual = teams;
        assertEquals(expected,actual);

        teams.clear();
    }

    @Test
    void testAddTeamGeneral() {
        ArrayList<Integer> expected = new ArrayList<>();
        
        //Adds 5 teams to the expected
        for (int i = 0; i < 5; i++) {
            expected.add(i,i+1);
        }
        expected.add(6);
        
        //Adds 5 teams to the actual
        teams.clear();
        for (int i = 0; i < 5; i++) {
            teams.addTeam();
        }
        Tracker.addTeam();
        ArrayList<Integer> actual = teams;
        assertEquals(expected,actual);

        teams.clear();
    }

    /**
     * Testing addPokemon
     * Done by Hasan Salhi
     */
    @Test
    void testAddPokemonFromEmpty() {
        ArrayList<ArrayList<Object>> expected = new ArrayList<>;
        teams.clear();
        Tracker.addTeam();

        ArrayList<Object> pokemon = new ArrayList<>(Arrays.asList(1,"Ivysaur",1000,250,"","","","",0,0));
        expected.add(pokemon);

        Tracker.addPokemon(1,"Ivysaur",1000,50,"","","","",0,0);
        ArrayList<ArrayList<Object>> actual = statistics;
        assertEquals(expected, actual);

        teams.clear();
        statistics.clear();
    }

    @Test
    void testAddPokemonGeneral() {
        ArrayList<ArrayList<Object>> expected = new ArrayList<>;
        teams.clear();
        //Adds 3 teams for variation
        for(int i = 0; i < 2; i++) {
            Tracker.addTeam();
        }

        //Adds Pokemon to expected
        ArrayList<Object> pokemon = new ArrayList<>(Arrays.asList(1,"Pikachu",1000,250,"","",));
        expected.add(pokemon);

        ArrayList<Object> pokemon1 = new ArrayList<>(Arrays.asList(2,"Charizard",2000,300,"",""));
        expected.add(pokemon);

        ArrayList<Object> pokemon2 = new ArrayList<>(Arrays.asList(3,"Squirtle",1000,150,"",""));
        expected.add(pokemon);

        //Adds Pokemon to teams
        Tracker.addPokemon(1,"Pikachu",1000,250,"","");
        Tracker.addPokemon(2,"Charizard",2000,300,"","");
        Tracker.addPokemon(3,"Squirtle",1000,150,"","");

        ArrayList<ArrayList<Object>> actual = teams;
        assertEquals(expected,actual);

        teams.clear();
        statistics.clear();
    }

    /**
     * Testing addMove
     * Done by Hasan Salhi
     */
    @Test
    void testAddMove() {
        teams.clear();
        statistics.clear();

        Tracker.addTeam();
        Tracker.addPokemon(1,"Charmander",1250,175,"","");

        //Copies expected value into new ArrayList to be able to compare it with actually using addMove()
        statistics.get(0).add(6,"Move");
        ArrayList<Object> expected = new ArrayList<>(Arrays.asList(1,"Charmander",1250,175,"","","Move","",0,0));

        //Resets item index to test it with actual function
        statistics.get(0).add(6,"");
        Tracker.addMove("Charmander","Move");

        ArrayList<Object> actual = statistics.get(0);
        assertEquals(expected, actual);

        teams.clear();
        statistics.clear();
    }

    /**
     * Testing addItem
     * Done by Hasan Salhi
     */
    @Test
    void testAddItem() {
        teams.clear();
        statistics.clear();

        Tracker.addTeam();
        Tracker.addPokemon(1,"Charmander",1250,175,"","");

        //Copies expected value into new ArrayList to be able to compare it with actually using addItem()
        statistics.get(0).add(7,"Item");
        ArrayList<Object> expected = new ArrayList<>(Arrays.asList(1,"Charmander",1250,175,"","","","Item",0,0));

        //Resets item index to test it with actual function
        statistics.get(0).add(7,"");
        Tracker.addItem("Charmander","Item");

        ArrayList<Object> actual = statistics.get(0);
        assertEquals(expected, actual);

        teams.clear();
        statistics.clear();
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

    @Test
    void testGetTopAttack() {
    }

    @Test
    void testGetTopHP() {
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
        String testString = ("\nPokemon with normal as a primary or secondary type:\ngood\ngood2\ngood3\n");
        String actual = Tracker.getAllType("normal");
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
