import java.util.Scanner;
import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Tracker Class
 * A class for tracking Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 2.0 - March 18, 2025
 */
public class Tracker {
    private  ArrayList<Team> teams;

    /**
     * Adds a Team to the Tracker.
     * Done by Hasan Salhi
     */
    public static void addTeam() {
        //TODO

    }

    /**
     * Returns all Pokemon from all Teams.
     * Done by (NAME).
     *
     * @return a String containing all Pokemon from all Teams.
     */
    public static String getAllPokemon() {
        //TODO
        return "";
    }

    /**
     * Returns the top 3 Pokemon with the highest HP.
     * Done by (NAME).
     *
     * @return a String containing the top 3 Pokemon with the highest HP.
     */
    public static String getTopHP() {
        //TODO
        return "";
    }

    /**
     * Returns the top 3 Pokemon with the highest attack.
     * Done by Hasan Salhi
     *
     * @return a String containing the top 3 Pokemon with the highest attack.
     */
    public static String getTopAttack() {
        //TODO
        return "";
    }

    /**
     * Returns all Pokemon with the same Type.
     * Done by (NAME).
     *
     * @param type, the Type to search for.
     * @return a String containing the all Pokemon with the same Type.
     */
    public static String getAllType(Type type) {
        //TODO
        return "";
    }

    /**
     * Returns the menu of the Tracker.
     * Done by Jade Torres.
     *
     * @return a String menu.
     */
    public static String getMenu() {
        return """
                
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
                11) list all Pokemon of a certain type""";
    }

    /**
     * The main method for running the Tracker.
     * Done by (NAME).
     */
    public static void main(String[] args) {
        //TODO
    }
}