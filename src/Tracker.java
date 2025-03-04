import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * CPSC 233 W25 Project Tracker Class
 * A class for tracking Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 1.6 - March 3, 2025
 */
public class Tracker {
    private static ArrayList<Integer> teams = new ArrayList<>();
    private static ArrayList<ArrayList<Object>> statistics = new ArrayList<>();

    /**
     * Adds a new team number to the teams ArrayList.
     * Done by Hasan Salhi.
     */
    public static void addTeam() {
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
     * Done by Hasan Salhi.
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
        ArrayList<Object> pokemon = new ArrayList<>(Arrays.asList(team,name,hp,attack,typeOne,typeTwo,"","",0,0));
        statistics.add(pokemon);
    }

    /**
     * Adds a new move to a Pokemon's ArrayList in statistics.
     * Replaces any preexisting moves in the same index.
     * Done by Hasan Salhi.
     *
     * @param pokemon, a String representing the Pokemon getting a new move.
     * @param move, a String representing the Pokemon's move.
     */
    public static void addMove(String pokemon, String move) {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            for (ArrayList<Object> aPokemon : statistics) {
                //Checks every arrayList in statistics for the corresponding pokemon
                if (aPokemon.get(1).equals(pokemon)) {
                    aPokemon.set(6,move);
                }
            }
        }
        else {
            System.out.println("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Adds a new item to a Pokemon's ArrayList in statistics.
     * Replaces any preexisting items in the same index.
     * Done by Hasan Salhi.
     *
     * @param pokemon, a String representing the Pokemon getting a new move.
     * @param item, a String representing the Pokemon's item.
     */
    public static void addItem(String pokemon, String item) {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            for (ArrayList<Object> aPokemon : statistics) {
                //Checks every arrayList in statistics for the corresponding pokemon
                if (aPokemon.get(1).equals(pokemon)) {
                    aPokemon.set(7,item);
                }
            }

        }
        else {
            System.out.println("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Increases the win count (by one) in a Pokemon's ArrayList in statistics.
     * Applies to all Pokemon with the same name.
     * Done by Jade Torres.
     *
     * @param pokemon, a String representing the Pokemon getting a win.
     */
    public static void addWin(String pokemon) {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            //Iterates through the ArrayLists in statistics.
            for (ArrayList<Object> list : statistics) {
                //Checks if the name of a Pokemon matches the pokemon parameter.
                if (list.get(1).equals(pokemon)) {
                    //Increases the win count by one.
                    int wins = ((int) list.get(8)) + 1;
                    list.set(8, wins);
                }
            }
        }
        else {
            System.out.println("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Increases the loss count (by one) in a Pokemon's ArrayList in statistics.
     * Applies to all Pokemon with the same name.
     * Done by Jade Torres.
     *
     * @param pokemon, a String representing the Pokemon getting a loss.
     */
    public static void addLoss(String pokemon) {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            //Iterates through the ArrayLists in statistics.
            for (ArrayList<Object> list : statistics) {
                //Checks if the name of a Pokemon matches the pokemon parameter.
                if (list.get(1).equals(pokemon)) {
                    //Increases the win count by one.
                    int losses = ((int) list.get(9)) + 1;
                    list.set(9, losses);
                }
            }
        }
        else {
            System.out.println("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Returns the data stored in the statistics ArrayList.
     * Done by Jade Torres.
     *
     * @return a String representation of the data stored
     */
    public static String getAllPokemon() {
        StringBuilder data = new StringBuilder();

        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            for (ArrayList<Object> list : statistics) {
                data.append("\n********************\n");
                data.append("\nTeam Number: ").append(list.getFirst());
                data.append("\nPokemon: ").append(list.get(1));
                data.append("\nHP: ").append(list.get(2));
                data.append("\nAttack: ").append(list.get(3));
                data.append("\nType: ").append(list.get(4));
                data.append("\nSecond Type: ").append(list.get(5));
                data.append("\nMove: ").append(list.get(6));
                data.append("\nItem: ").append(list.get(7));
                data.append("\nWins: ").append(list.get(8));
                data.append("\nLosses: ").append(list.get(9)).append("\n");
            }
            return data.toString().stripTrailing();
        }
        else {
            return "\nThere are no Pokemon in the Database!";
        }
    }

    /**
     * Prints the names/Attacks of the top 3 Pokemon with the highest Attack.
     * Essentially same as getTopHP function, read JavaDoc comments for that.
     * But basically, put all ATK in an array, sort array from highest to lowest, and find those 3 Pokemon.
     * Done by Jordan Tran.
     */
    public static String getTopAttack() {
        if(statistics.size() < 3){
            return ("\nThere are less than 3 Pokemon in the Database!"); // boots out of the method if there aren't 3 Pokemon minimum
        }

        ArrayList<int[]> atkList = new ArrayList<int[]>(); // arraylist of arrays to store attack values and index numbers

        for(int pokemon = 0; pokemon < statistics.size(); pokemon++){
            int atk = (int)((statistics.get(pokemon)).get(3)); // cast to an int, since technically an object
            int[] toAdd = {atk,pokemon};
            atkList.add(toAdd); // add array to arraylist
        }

        // sort the arraylist through a simple bubble sort
        atkList = bubbleSort(atkList, atkList.size());

        String highestAtk = (statistics.get((atkList.get(0))[1]).get(1)).toString(); // get the name of the Pokemon in statistics with the highest ATK
        String secondHighest = (statistics.get((atkList.get(1))[1]).get(1)).toString();
        String thirdHighest = (statistics.get((atkList.get(2))[1]).get(1)).toString(); // pulls index number from atkList, gets the name from that index, then turns that to a string.

        return("\nThe Pokemon with the highest Attack are: " + highestAtk + ", " + secondHighest + ", " + thirdHighest);
    }

    /**
     * Prints the names/HPs of the top 3 Pokemon with the highest HP.
     * Done by storing all HP values along with index number in an arraylist of arrays.
     * Next the arraylist will be sorted from largest to smallest.
     * Finally, print the Pokemon whose index numbers match the top 3.
     * Done by Jordan Tran.
     */
    public static String getTopHP() {
        if(statistics.size() < 3){
            return("\nThere are less than 3 Pokemon in the Database!"); // boots out of the method if there aren't 3 Pokemon minimum
        }

        ArrayList<int[]> hpList = new ArrayList<int[]>(); // arraylist of arrays to store hp values and index numbers

        for(int pokemon = 0; pokemon < statistics.size(); pokemon++){
            int hp = (int)((statistics.get(pokemon)).get(2)); // cast to an int, since technically an object
            int[] toAdd = {hp,pokemon};
            hpList.add(toAdd); // add array to arraylist
        }

        // sort the arraylist through a simple bubble sort
        hpList = bubbleSort(hpList,hpList.size());

        String highestHp = (statistics.get((hpList.get(0))[1]).get(1)).toString(); // get the name of the Pokemon in statistics with the highest hp
        String secondHighest = (statistics.get((hpList.get(1))[1]).get(1)).toString();
        String thirdHighest = (statistics.get((hpList.get(2))[1]).get(1)).toString(); // pulls index number from hplist, gets the name from that index, then turns that to a string.

        return("\nThe Pokemon with the highest HP are: " + highestHp + ", " + secondHighest + ", " + thirdHighest);
    }

    /**
     * Bubble sort function for getTopHP and getTopAttack
     * The Following Code is from
     * https://www.geeksforgeeks.org/bubble-sort-algorithm/
     * As my initial bubble sort code did not work as intended.
     * @param arr Is the array to be sorted
     * @param n Is the size of the array
     * @return a 3 length int array
     */
    public static ArrayList<int[]> bubbleSort(ArrayList<int[]> arr, int n){
        ArrayList<int[]> toReturn = new ArrayList<int[]>();
        toReturn = arr;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                int[] array1 = toReturn.get(j);
                int[] array2 = toReturn.get(j + 1);

                // Compare the first element of the arrays
                if (array1[0] < array2[0] || (array1[0] == array2[0] && array1[1] < array2[1])) {
                    // Swap the arrays
                    toReturn.set(j, array2);
                    toReturn.set(j + 1, array1);
                    swapped = true;
                }
            }
            // If no elements were swapped, the list is already sorted
            if (!swapped) {
                break;
            }
        }

        return toReturn;
    }
    /**
     * Prints the average Attack of very Pokemon in statistics.
     * Track all attack statistics in an integer and then divide by number of Pokemon.
     * Done by Jordan Tran.
     */
    public static String getAverageAttack() {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            int track = 0; // tracker variable
            int toDivide = 0;
            for(int pokemon = 0; pokemon < statistics.size(); pokemon++){
                int num = (int)((statistics.get(pokemon)).get(3)); // cast to an int, since technically an object
                track += num; // add to track
                toDivide += 1; // for division at the end
            }

            return("\nThe average Attack value of all Pokemon is: " + (track/toDivide) + " Attack."); // print average
        }
        else {
            return("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Returns every Pokemon with the same type in the statistics ArrayList.
     * For every element in every arraylist in statistics, check for the specified type.
     * If it matches the type, adds the name to a new arraylist to return.
     * Since we have an object arraylist we have to turn every element we want to compare into a string.
     * Done by Jordan Tran.
     *
     * @param type, a String representing the type to search for.
     */
    public static String getAllType(String type) {
        //Checks if there are Pokemon in statistics.
        if (!statistics.isEmpty()) {
            ArrayList<String> matchingPokemon = new ArrayList<String>();
            String temp = type.toLowerCase(); // lowercase version of the string parameter for checks

            for(int pokeNumber = 0; pokeNumber < statistics.size(); pokeNumber++){ //loops through the list
                String pokemon = ((statistics.get(pokeNumber)).get(1)).toString();
                String pokeType = ((statistics.get(pokeNumber)).get(4)).toString(); // we can do hard numbers here as all pokemon entries follow the same structure
                String secondaryType = ((statistics.get(pokeNumber)).get(5)).toString();
                // do these operations here as it would get convoluted in an if statement.
                if(temp.equals(pokeType.toLowerCase()) || temp.equals(secondaryType.toLowerCase())){
                    matchingPokemon.add(pokemon); //compare lowercase of temp to primary and secondary types
                }
            }

            String toReturn = ("\nPokemon with " + type + " as a primary or secondary type:\n");
            for(int i = 0; i < matchingPokemon.size(); i++){
                toReturn = toReturn.concat(matchingPokemon.get(i) + "\n"); // concatenate pokemon and a new line to the return string
            }

            return toReturn;
        }
        else {
            return ("\nThere are no Pokemon in the Database!");
        }
    }

    /**
     * Prints the menu of the tracker.
     * Done by Jade Torres.
     */
    public static void getMenu() {
        System.out.println("""
                
                ********************
                
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
                7) ask for all Pokemon to be printed
                
                Output Special
                8) ask for the top 3 Pokemon with the highest Attack
                9) ask for the top 3 Pokemon with the highest HP
                10) ask for the average Attack of all Pokemon
                11) list of all Pokemon of a certain type
                """);
    }

    /**
     * Main method for running the tracker.
     * Done by Jade Torres.
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
            //Assumes the input for team, hp, and attack are integers.
            else if (option == 2) {
                System.out.println("\nEnter the Pokemon's team number:");
                int team = scan.nextInt();

                //Checks if input is a valid team number.
                if (!teams.contains(team)) {
                    System.out.println("\nNot a valid option.");
                }
                else {
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("Enter the Pokemon's name:");
                    String name = scan.nextLine();
                    System.out.println("Enter the Pokemon's HP:");
                    int hp = scan.nextInt();
                    System.out.println("Enter the Pokemon's Attack value:");
                    int attack = scan.nextInt();

                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("Enter the Pokemon's type:");
                    String typeOne = scan.nextLine();
                    System.out.println("Enter the Pokemon's second type (if not applicable, enter \"none\"):");
                    String typeTwo = scan.nextLine();

                    addPokemon(team, name, hp, attack, typeOne, typeTwo);
                }
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
                System.out.println(getAllPokemon());
            }
            else if (option == 8) {
                System.out.println(getTopAttack());
            }
            else if (option == 9) {
                System.out.println(getTopHP());
            }
            else if (option == 10) {
                System.out.println(getAverageAttack());
            }
            else if (option == 11) {
                //"Fake" input to parse out the extra \n when the user presses enter.
                scan.nextLine();

                System.out.println("\nEnter the type:");
                String type = scan.nextLine();

                System.out.println(getAllType(type));
            }
            else {
                System.out.println("\nNot a valid option.");
            }
        }
    }
}