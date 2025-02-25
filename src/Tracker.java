import java.util.Scanner;
import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Tracker Class
 * A class for tracking Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.0 - February 25, 2025
 */
public class Tracker {
    public static void addTeam() {
        //TODO
    }

    public static void addPokemon(String name, int hp, String typeOne, String typeTwo) {
        //TODO
    }

    public static void addMove(String move) {
        //TODO
    }

    public static void addItem(String item) {
        //TODO
    }

    public static void addWin() {
        //TODO
    }

    public static void addLoss() {
        //TODO
    }

    public static void getAllPokemon() {
        //TODO
    }

    public static void getTopAttack () {
        //TODO
    }

    public static void getTopHP () {
        //TODO
    }

    public static void getAverageAttack () {
        //TODO
    }

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
                "   type, and second type (optional)\n" +
                "\n" +
                "Add Pokemon Data\n" +
                "3) add a move to a Pokemon\n" +
                "4) add an item to a Pokemon\n" +
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
            else if (option == 2) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter the Pokemon's name:");
                String name = scan.nextLine();

                System.out.println("Enter the Pokemon's HP:");
                int hp = scan.nextInt();

                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("Enter the Pokemon's type:");
                String typeOne = scan.nextLine();
                System.out.println("Enter the Pokemon's second type (if not applicable, enter \"none\"):");
                String typeTwo = scan.nextLine();

                addPokemon(name, hp, typeOne, typeTwo);
            }
            else if (option == 3) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter a move:");
                String move = scan.nextLine();

                addMove(move);
            }
            else if (option == 4) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter an item:");
                String item = scan.nextLine();

                addItem(item);
            }
            else if (option == 5) {
                addWin();
            }
            else if (option == 6) {
                addLoss();
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