import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;


public class TrackerTest extends Tracker{
    //private static ArrayList<ArrayList<Object>> statistics = new ArrayList<>();
    private static ArrayList<Integer> teams = new ArrayList<>();

    @Test
    /**
     * Testing the getAllType method
     * Ensure that it returns only Pokemon of the specified type, regardless of primary or secondary typing
     */
    public void testgetAllType(){
        Tracker.addTeam();
        ArrayList<Object> valid1 = new ArrayList<>(Arrays.asList(1,"good",0,0,"normal","none","","",0,0)); //making test pokemon
        ArrayList<Object> valid2 = new ArrayList<>(Arrays.asList(1,"good2",0,0,"none","normal","","",0,0)); //normal as secondary typing
        ArrayList<Object> valid3 = new ArrayList<>(Arrays.asList(1,"good3",0,0,"Normal","none","","",0,0)); //normal (capital edition)
        ArrayList<Object> invalid1 = new ArrayList<>(Arrays.asList(1,"invalid",0,0,"Fighting","Steel","","",0,0)); //NOT a normal type
        statistics.add(valid1);
        statistics.add(valid2);
        statistics.add(valid3);
        statistics.add(invalid1);

        String testString = ("\nPokemon with normal as a primary or secondary type:\ngood\ngood2\ngood3\n");
        assertEquals(testString, Tracker.getAllType("normal"));
    }
}
