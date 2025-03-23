import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Team Class
 * A class for holding Team objects.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.1 - March 21, 2025
 */
public class Team {
    private static int number = 0;
    private int teamNum; // unique number for each team
    private ArrayList<Pokemon> pokemon;

    /**
     * Constructs a new Team object.
     * Done by Jade Torres.
     */
    public Team() {
        teamNum = ++number;
        pokemon = new ArrayList<>();
    }

    /**
     * Adds a Pokemon to a Team.
     * Done by Hasan Salhi
     *
     * @param pokemon, the Pokemon to be added.
     */
    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    /**
     * Returns the number a Team has.
     * Done by Jordan Tran.
     *
     * @return field number.
     */
    public int getNumber() {
        return teamNum;
    }

    /**
     * Returns the arraylist of a certain teams Pokemon
     * Done by Jordan Tran
     * @return list of pokemon
     */
    public ArrayList<Pokemon> getPokemon(){return pokemon;}

    /**
     * Returns a String representation of a Team.
     * Done by Jade Torres.
     *
     * @return a String containing all elements in field pokemon.
     */
    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();

        statistics.append("********************");
        statistics.append("\n\n\tTEAM #").append(teamNum);

        //Iterates through the elements in field pokemon.
        for (Pokemon p : pokemon) {
            statistics.append("\n\n");
            statistics.append(p.toString());
        }

        statistics.append("\n\n");
        return statistics.toString().stripTrailing();
    }
}