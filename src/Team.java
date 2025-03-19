import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Team Class
 * A class for holding Team objects.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.0 - March 18, 2025
 */
public class Team {
    private static int number = 0;
    private ArrayList<Pokemon> pokemon;

    /**
     * Constructs a new Team object.
     * Done by Jade Torres.
     */
    public Team() {
        number += 1;
        pokemon = new ArrayList<>();
    }

    /**
     * Adds a Pokemon to a Team.
     * Done by (NAME).
     *
     * @param pokemon, the Pokemon to be added.
     */
    public void addPokemon(Pokemon pokemon) {
        //TODO
    }

    /**
     * Returns the number a Team has.
     * Done by (NAME).
     *
     * @return field number.
     */
    public int getNumber() {
        //TODO
        return 0;
    }
}