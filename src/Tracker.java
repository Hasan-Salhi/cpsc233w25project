import java.util.Scanner;
import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Tracker Class
 * A class for tracking Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 2.1 - March 22, 2025
 */
public class Tracker {
    private static ArrayList<Team> teams = new ArrayList<Team>();

    /**
     * Adds a Team to the Tracker.
     * Done by Hasan Salhi
     */
    public static void addTeam() {
        //TODO

    }

    /**
     * Returns all Pokemon from all Teams.
     * Done by Jordan Tran.
     *
     * @return a String containing all Pokemon from all Teams.
     */
    public static String getAllPokemon() {
        StringBuilder toReturn = new StringBuilder();
        for(Team team : teams){
            toReturn.append(team); // use the team toString() function to print out every team
        }
        return String.valueOf(toReturn); // convert StringBuilder to a string and return
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
     * Done by Jordan Tran.
     *
     * @param type, the Type to search for.
     * @return a String containing the all Pokemon with the same Type.
     */
    public static String getAllType(Type type) {
        //TODO
        return "";
    }

    /**
     * Returns average attack of all pokemon
     * Done by Jordan Tran
     *
     * @return average attack value for all pokemon
     */
    public static int getAvgAtk(){
        //TODO
        return 5;
    }

    /**
     * Helper method to determine if an entered type is valid
     * @param input, the input of the user
     * @return true for valid type false for invalid
     */
    public static boolean checkEnum(String input){
        try{
            Type type = Type.valueOf(input.toUpperCase()); // see if this throws an exception or not
            return true; // if it does not throw an exception, we can assume it is valid.
        }catch(IllegalArgumentException e){
            System.out.println("Invalid type."); // will only ever be used to check if it is a valid type
            return false;
        }
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
     * Done by Jordan Tran.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // make scanner
        int choice;

        do{
            System.out.println(getMenu()); // print menu
            System.out.println("Please select one of the options above (-1 to stop tracking):");
            choice = scan.nextInt();

            switch(choice){ // switch to handle numbers as well as inputs greater than 12 or less than 1
                case 1:
                    addTeam();
                    break;
                case 2: {
                    if (teams.isEmpty()) { // make sure teams is not empty
                        System.out.println("\nThere are no teams to add a Pokemon to!");
                    } else {
                        System.out.println("What team number would you like to add a Pokemon to?\n");
                        int teamChoice = scan.nextInt();
                        if (teamChoice > teams.size() || teamChoice < 1) { // account for teams starting at 1
                            System.out.println("That team does not exist!;");
                        } else {
                            //actual process of adding a pokemon starts here
                            scan.nextLine(); //"Fake" input to parse out the extra \n when the user presses enter.

                            System.out.println("Enter the Pokemon's name:");
                            String name = scan.nextLine();
                            System.out.println("Enter the Pokemon's HP:");
                            int hp = scan.nextInt();
                            System.out.println("Enter the Pokemon's Attack value:");
                            int attack = scan.nextInt();

                            //"Fake" input to parse out the extra \n when the user presses enter.
                            scan.nextLine();

                            System.out.println("Enter the Pokemon's type:");
                            String testOne = scan.nextLine();
                            System.out.println("Enter the Pokemon's second type (if not applicable, enter \"none\"):");
                            String testTwo = scan.nextLine(); // grabbing string inputs to check

                            if(checkEnum(testOne) && checkEnum(testTwo)){ // checking valid type input
                                Type typeOne = Type.valueOf(testOne.toUpperCase()); // .valueOf is case sensitive so we need to turn input to uppercase
                                Type typeTwo = Type.valueOf(testTwo.toUpperCase());
                                // grab pokemon info and turn it into a pokemon
                                Pokemon toAdd = new Pokemon(name, hp, attack, typeOne, typeTwo);

                                for (Team team : teams) {
                                    if (team.getNumber() == teamChoice) {
                                        // loop through team list to get desired team
                                        team.addPokemon(toAdd); // add said pokemon
                                    }
                                }
                            }
                        }

                    }
                    break;
                }


                case 3: {
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon:");
                    String pokemon = scan.nextLine();
                    System.out.println("\nEnter a move:");
                    String move = scan.nextLine();
                    boolean addMove = false; // boolean to check if a move was added
                    for (Team team : teams) {
                        // get arraylist of pokemon for each team
                        for (Pokemon member : team.getPokemon()) { // looping through that arraylist
                            if (member.getName().equalsIgnoreCase(pokemon)) {
                                member.addMove(move); // if that pokemon is found add a move to it
                                addMove = true;
                            }
                        }
                    }
                    if (!addMove) {
                        System.out.println("Pokemon does not exist!");
                    }
                    break;
                }


                case 4: {// same same as for 3)
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon:");
                    String pokemonItem = scan.nextLine();
                    System.out.println("\nEnter a move:");
                    String item = scan.nextLine();
                    boolean addItem = false; // boolean to check if a move was added

                    for (Team team : teams) {
                        // get arraylist of pokemon for each team
                        for (Pokemon member : team.getPokemon()) { // looping through that arraylist
                            if (member.getName().equalsIgnoreCase(pokemonItem)) {
                                member.addItem(item); // if that pokemon is found add item to it
                                addItem = true;
                            }
                        }
                    }
                    if (!addItem) {
                        System.out.println("Pokemon does not exist!");
                    }
                    break;
                }


                case 5 :{ // same as 6
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon:");
                    String pokemon = scan.nextLine();

                    boolean addWin = false; // boolean to check if a move was added

                    for (Team team : teams) {
                        // get arraylist of pokemon for each team
                        for (Pokemon member : team.getPokemon()) { // looping through that arraylist
                            if (member.getName().equalsIgnoreCase(pokemon)) {
                                member.addWin(); // if that pokemon is found add item to it
                                addWin = true;
                            }
                        }
                    }
                    if (!addWin) {
                        System.out.println("Pokemon does not exist!");
                    }

                    break;
                }


                case 6:{ // identical to 5
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon:");
                    String pokemon = scan.nextLine();

                    boolean addLoss = false; // boolean to check if a move was added

                    for (Team team : teams) {
                        // get arraylist of pokemon for each team
                        for (Pokemon member : team.getPokemon()) { // looping through that arraylist
                            if (member.getName().equalsIgnoreCase(pokemon)) {
                                member.addLoss(); // if that pokemon is found add item to it
                                addLoss = true;
                            }
                        }
                    }
                    if (!addLoss) {
                        System.out.println("Pokemon does not exist!");
                    }
                    break;
                }


                case 7: {
                    System.out.println(getAllPokemon());
                    break;
                }

                case 8: {
                    System.out.println(getTopAttack());
                    break;
                }

                case 9: {
                    System.out.println(getTopHP());
                    break;
                }

                case 10: {
                    System.out.println("The average attack value of all Pokemon in the Tracker is: " + getAvgAtk() + " ATK.");
                    break;
                }

                case 11: {
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter the type:");
                    String type = scan.nextLine();

                    if(checkEnum(type)){
                        Type toFind = Type.valueOf(type.toUpperCase()); // convert type into a valid enum
                        System.out.println(getAllType(toFind));
                    }
                    break;
                }
            }

        }while(choice != -1); // do while to loop through menu
        System.out.println("Tracker closed.");
    }
}