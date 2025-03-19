/**
 * CPSC 233 W25 Project Pokemon Class
 * A class for holding Pokemon objects.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.0 - March 18, 2025
 */
public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private Type typeOne;
    private Type typeTwo;
    private String move;
    private String item;
    private int wins = 0;
    private int losses = 0;

    /**
     * Constructs a new Pokemon object.
     * Done by Jade Torres.
     *
     * @param name, the name of the Pokemon.
     * @param hp, the HP of the Pokemon.
     * @param attack, the attack value of the Pokemon.
     * @param typeOne, the type of the Pokemon.
     * @param typeTwo, the second type of the Pokemon (null if none).
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
     * Done by (NAME).
     *
     * @param move, the new value of field move.
     */
    public void addMove(String move) {
        //TODO
    }

    /**
     * Assigns a new value to field item.
     * Done by (NAME).
     *
     * @param item, the new value of field item.
     */
    public void addItem(String item) {
        //TODO
    }

    /**
     * Increases the value of field wins by one.
     * Done by (NAME).
     */
    public void addWin() {
        //TODO
    }

    /**
     * Increases the value of field losses by one.
     * Done by (NAME).
     */
    public void addLoss() {
        //TODO
    }

    /**
     * Returns the name a Pokemon has.
     * Done by (NAME).
     *
     * @return field name.
     */
    public String getName() {
        //TODO
        return "";
    }

    /**
     * Returns the HP a Pokemon has.
     * Done by (NAME).
     *
     * @return field hp.
     */
    public int getHP() {
        //TODO
        return 0;
    }

    /**
     * Returns the attack value a Pokemon has.
     * Done by (NAME).
     *
     * @return field attack.
     */
    public int getAttack() {
        //TODO
        return 0;
    }

    /**
     * Returns the first Type a Pokemon has.
     * Done by (NAME).
     *
     * @return field typeOne.
     */
    public Type getTypeOne() {
        //TODO
        return null;
    }

    /**
     * Returns the second Type a Pokemon has.
     * Done by (NAME).
     *
     * @return field typeTwo.
     */
    public Type getTypeTwo() {
        //TODO
        return null;
    }

    /**
     * Returns the move a Pokemon has.
     * Done by (NAME).
     *
     * @return field move.
     */
    public String getMove() {
        //TODO
        return "";
    }

    /**
     * Returns the item a Pokemon has.
     * Done by (NAME).
     *
     * @return field item.
     */
    public String getItem() {
        //TODO
        return "";
    }

    /**
     * Returns the number of wins a Pokemon has.
     * Done by (NAME).
     *
     * @return field wins.
     */
    public int getWins() {
        //TODO
        return 0;
    }

    /**
     * Returns the number of losses a Pokemon has.
     * Done by (NAME).
     *
     * @return field losses.
     */
    public int getLosses() {
        //TODO
        return 0;
    }

    /**
     * Returns a String representation of a Pokemon.
     * Done by Jade Torres.
     *
     * @return a String containing all fields in a Pokemon object.
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

        return statistics.toString().stripTrailing();
    }
}