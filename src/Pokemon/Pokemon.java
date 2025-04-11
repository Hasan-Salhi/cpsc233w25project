package Pokemon;

import Type.Type;
import java.awt.*;

/**
 * CPSC 233 W25 Project Pokemon.Pokemon Class
 * A class for holding Pokemon.Pokemon objects.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.2 - March 24, 2025
 */
public abstract class Pokemon {
    protected String name;
    protected int hp;
    protected int attack;
    protected Type typeOne;
    protected Type typeTwo;
    protected String move;
    protected String item;
    protected int wins = 0;
    protected int losses = 0;

    /**
     * Constructs a new Pokemon.Pokemon object.
     * Done by Jade Torres.
     *
     * @param name, the name of the Pokemon.Pokemon.
     * @param hp, the HP of the Pokemon.Pokemon.
     * @param attack, the attack value of the Pokemon.Pokemon.
     * @param typeOne, the type of the Pokemon.Pokemon.
     * @param typeTwo, the second type of the Pokemon.Pokemon (null if none).
     */
    public Pokemon(String name, int hp, int attack, Type typeOne, Type typeTwo) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }

    /**
     * Assigns a new value to field move.
     * Done by Hasan Salhi.
     *
     * @param move, the new value of field move.
     */
    public void addMove(String move) {
        this.move = move;
    }

    /**
     * Assigns a new value to field item.
     * Done by Hasan Salhi.
     *
     * @param item, the new value of field item.
     */
    public void addItem(String item) {
        this.item = item;
    }

    /**
     * Increases the value of field wins by one.
     * Done by Hasan Salhi.
     */
    public void addWin() {
        this.wins++;
    }

    /**
     * Increases the value of field losses by one.
     * Done by Hasan Salhi.
     */
    public void addLoss() {
        this.losses++;
    }

    /**
     * Set wins in case of file reading.
     * Done by Jordan Tran.
     *
     * @param wins is the recorded number of wins/
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Set losses in case of file reading.
     * Done by Jordan Tran.
     *
     * @param losses is the recorded number of losses.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Returns the name a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the HP a Pokemon.Pokemon has.
     * Done by Hasan SaLhi.
     *
     * @return field hp.
     */
    public int getHP() {
        return this.hp;
    }

    /**
     * Returns the attack value a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field attack.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Returns the first Type.Type a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field typeOne.
     */
    public Type getTypeOne() {
        return this.typeOne;
    }

    /**
     * Returns the second Type.Type a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field typeTwo.
     */
    public Type getTypeTwo() {
        return this.typeTwo;
    }

    /**
     * Returns the move a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field move.
     */
    public String getMove() {
        if(this.move == null){
            return "NO MOVE";
        }
        return this.move;
    }

    /**
     * Returns the item a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field item.
     */
    public String getItem() {
        if(this.item == null){
            return "NO ITEM";
        }
        return this.item;
    }

    /**
     * Returns the number of wins a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field wins.
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Returns the number of losses a Pokemon.Pokemon has.
     * Done by Hasan Salhi.
     *
     * @return field losses.
     */
    public int getLosses() {return this.losses;}

    /**
     * Converts any given Pokemon.Pokemon object into CSV format for file writing
     * Done by Jordan Tran.
     */
    public String getPokemon(){
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(this.getName()).append(","); // appending data as well as a comma
        toReturn.append(this.getHP()).append(",");
        toReturn.append(this.getAttack()).append(",");
        toReturn.append(this.getTypeOne()).append(",");
        toReturn.append(this.getTypeTwo()).append(",");
        toReturn.append(this.getMove()).append(",");
        toReturn.append(this.getItem()).append(",");
        toReturn.append(this.getWins()).append(",");
        toReturn.append(this.getLosses()); // don't need comma here as it is the last element

        return toReturn.toString();
    }

    /**
     * Returns a String representation of a Pokemon.Pokemon.
     * Done by Jade Torres.
     *
     * @return a String containing all fields in a Pokemon.Pokemon object.
     */
    @Override
    public String toString() {
        StringBuilder statistics = new StringBuilder();

        statistics.append("Pokemon: ").append(name);
        statistics.append("\nHP: ").append(hp);
        statistics.append("\nAttack: ").append(attack);
        statistics.append("\nType: ").append(typeOne);
        statistics.append("\nSecond Type: ").append(typeTwo);
        statistics.append("\nMove: ").append(move);
        statistics.append("\nItem: ").append(item);
        statistics.append("\nWins: ").append(wins);
        statistics.append("\nLosses: ").append(losses);

        return statistics.toString();
    }

    /**
     * description of the Pokemons attack
     */
    public abstract void useMove();

    /**
     * effectiveness of moves based on typing
     * @return a string signifying the boost moves of a certain type get
     */
    public abstract String getSTAB();

    /**
     * types that said pokemon are weak to
     * @return a string with pokemon weaknesses
     */
    public abstract String getTypeWeakness();

    /**
     * passive of each pokemon type
     * @return the passive of each pokemon type
     */
    public abstract String typePassive();
}