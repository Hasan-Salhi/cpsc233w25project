import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CPSC 233 W25 Project Tracker Class
 * A class for tracking Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.2 - February 25, 2025
 */
public class Tracker {
    private static ArrayList<Integer> teams = new ArrayList<>();
    private static ArrayList<ArrayList<String>> statistics = new ArrayList<>();

    /**
     * Adds a new team number to the teams ArrayList.
     * Done by Hasan Salhi
     */
    public static void addTeam() {
        //WIP
        int teamNumber = teams.size() + 1;
        teams.add(teamNumber);
    }

    /**
     * Adds a new Pokemon to the statistics ArrayList.
     * Pokemon are represented by an ArrayList containing their
     * team, name, HP, attack, type, and second type.
     * Two empty Strings are added for holding a move and item
     * (elements 6 and 7).
     * Two ints (set to zero) are added for holding the Pokemon's
     * wins and losses (elements 8 and 9).
     *
     * @param team, an int representing the Pokemon's team number.
     * @param name, a String representing the Pokemon's name.
     * @param hp, an int representing the Pokemon's hit points.
     * @param attack, an int representing the Pokemon's Attack.
     * @param typeOne, a String representing the Pokemon's type.
     * @param typeTwo, a String representing the Pokemon's second type,
     *                 "none" if not applicable.
     */
    public static void addPokemon(int team, String name, int hp, int attack, String typeOne, String typeTwo) {
        //WIP
        ArrayList<Object> pokemon = new ArrayList<>(Arrays.asList(team,name,hp,attack,typeOne,typeTwo,"","",0,0));
        statistics.add(pokemon);
    }

    /**
     * Adds a new move to a Pokemon's ArrayList in statistics.
     * Replaces any preexisting moves in the same index.
     *
     * @param pokemon, a String representing the Pokemon getting a new move.
     * @param move, a String representing the Pokemon's move.
     */
    public static void addMove(String pokemon, String move) {
        //TODO
    }

    /**
     * Adds a new item to a Pokemon's ArrayList in statistics.
     * Replaces any preexisting items in the same index.
     *
     * @param pokemon, a String representing the Pokemon getting a new move.
     * @param item, a String representing the Pokemon's item.
     */
    public static void addItem(String pokemon, String item) {
        //TODO
    }

    /**
     * Increases the win count (by one) in a Pokemon's ArrayList in statistics.
     *
     * @param pokemon, a String representing the Pokemon getting a win.
     */
    public static void addWin(String pokemon) {
        //TODO
    }

    /**
     * Increases the loss count (by one) in a Pokemon's ArrayList in statistics.
     *
     * @param pokemon, a String representing the Pokemon getting a loss.
     */
    public static void addLoss(String pokemon) {
        //TODO
    }

    /**
     * Prints the data stored in the statistics ArrayList.
     */
    public static void getAllPokemon() {
        //TODO
    }

    /**
     * Prints the names/Attacks of the top 3 Pokemon with the highest Attack.
     */
    public static void getTopAttack () {
        //TODO
    }

    /**
     * Prints the names/HPs of the top 3 Pokemon with the highest HP.
     */
    public static void getTopHP () {
        //TODO
    }

    /**
     * Prints the average Attack of very Pokemon in statistics.
     */
    public static void getAverageAttack () {
        //TODO
    }

    /**
     * Prints every Pokemon with the same type in the statistics ArrayList.
     *
     * @param type, a String representing the type to search for.
     */
    public static void getAllType (String type) {
        //TODO
    }

    /**
     * Prints the menu of the tracker.
     */
    public static void getMenu() {
        System.out.println("\n********************\n" +
                "\n" +
                "Add Data\n" +
                "1) add a team\n" +
                "2) add a Pokemon to a team with a name, HP (Hit Points),\n" +
                "   Attack, type, and second type (optional)\n" +
                "\n" +
                "Add Pokemon Data\n" +
                "3) add a move to a Pokemon (max. 1)\n" +
                "4) add an item to a Pokemon (max. 1)\n" +
                "5) add a win to a Pokemon\n" +
                "6) add a loss to a Pokemon\n" +
                "\n" +
                "Output General\n" +
                "7) ask for all Pokemon to be printed\n" +
                "\n" +
                "Output Special\n" +
                "8) ask for the top 3 Pokemon with the highest Attack\n" +
                "9) ask for the top 3 Pokemon with the highest HP\n" +
                "10) ask for the average Attack of all Pokemon\n" +
                "11) list of all Pokemon of a certain type\n");
    }

    /**
     * Main method for running the tracker.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean trackerOn = true;

        while (trackerOn) {
            getMenu();

            System.out.println("Please select one of the options above (-1 to stop tracking):");
            int option = scan.nextInt();

            if (option == -1) {
                trackerOn = false;
            }
            else if (option == 1) {
                addTeam();
            }
            //Assumes the input for team and hp are valid integers.
            else if (option == 2) {
                System.out.println("\nEnter the Pokemon's team number:");
                int team = scan.nextInt();

                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("Enter the Pokemon's name:");
                String name = scan.nextLine();
                System.out.println("Enter the Pokemon's HP:");
                int hp = scan.nextInt();
                System.out.println("Enter the Pokemon's Attack:");
                int attack = scan.nextInt();

                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("Enter the Pokemon's type:");
                String typeOne = scan.nextLine();
                System.out.println("Enter the Pokemon's second type (if not applicable, enter \"none\"):");
                String typeTwo = scan.nextLine();

                addPokemon(team, name, hp, attack, typeOne, typeTwo);
            }
            else if (option == 3) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter a Pokemon:");
                String pokemon = scan.nextLine();
                System.out.println("\nEnter a move:");
                String move = scan.nextLine();

                addMove(pokemon, move);
            }
            else if (option == 4) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter a Pokemon:");
                String pokemon = scan.nextLine();
                System.out.println("\nEnter an item:");
                String item = scan.nextLine();

                addItem(pokemon, item);
            }
            else if (option == 5) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter a Pokemon:");
                String pokemon = scan.nextLine();

                addWin(pokemon);
            }
            else if (option == 6) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter a Pokemon:");
                String pokemon = scan.nextLine();

                addLoss(pokemon);
            }
            else if (option == 7) {
                getAllPokemon();
            }
            else if (option == 8) {
                getTopAttack();
            }
            else if (option == 9) {
                getTopHP();
            }
            else if (option == 10) {
                getAverageAttack();
            }
            else if (option == 11) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter the type:");
                String type = scan.nextLine();

                getAllType(type);
            }
            else {
                System.out.println("\nNot a valid option.");
            }
        }
    }
}