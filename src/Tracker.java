import java.util.Collections;
import java.io.*;
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
    private static ArrayList<Team> teams = new ArrayList<>();

    /**
     * Adds a Team to the Tracker.
     * Done by Hasan Salhi.
     */
    public static void addTeam() {
        teams.add(new Team());
        // making a new Team object
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
     * Done by Hasan Salhi.
     *
     * @return a String containing the top 3 Pokemon with the highest HP.
     */
    public static String getTopHP() {
        StringBuilder top3 = new StringBuilder();
        ArrayList<ArrayList<Object>> allPokemonNameHP = new ArrayList<>();

        //Puts all Pokemon names and their attack into a 2D arraylist
        for (Team team : teams) {
            for (Pokemon pokemon : team.getPokemon()) {
                ArrayList<Object> currentPokemon = new ArrayList<>();
                currentPokemon.add(pokemon.getName());
                currentPokemon.add(pokemon.getHP());
                allPokemonNameHP.add(currentPokemon);
            }
        }

        if (allPokemonNameHP.size() == 1) {return "Highest: " + allPokemonNameHP.getFirst().getFirst() + " with " + allPokemonNameHP.getFirst().get(1) + " HP\n";}
        else if (allPokemonNameHP.size() == 2) {
            allPokemonNameHP.sort((o1, o2) -> (Integer) o1.get(1) - (Integer) o2.get(1));
            Collections.reverse(allPokemonNameHP);

            return "Highest: " + allPokemonNameHP.getFirst().getFirst() + " with " + allPokemonNameHP.getFirst().get(1) + " HP\n" + "Second: " + allPokemonNameHP.get(1).getFirst() + " with " + allPokemonNameHP.get(1).get(1) + " HP\n";
        } else {

            //Sorts them according to attack
            allPokemonNameHP.sort((o1, o2) -> (Integer) o1.get(1) - (Integer) o2.get(1));
            Collections.reverse(allPokemonNameHP);
            top3.append("Highest: ").append(allPokemonNameHP.get(0).get(0)).append(" with ").append(allPokemonNameHP.get(0).get(1)).append(" HP\n");
            top3.append("Second: ").append(allPokemonNameHP.get(1).get(0)).append(" with ").append(allPokemonNameHP.get(1).get(1)).append(" HP\n");
            top3.append("Third: ").append(allPokemonNameHP.get(2).get(0)).append(" with ").append(allPokemonNameHP.get(2).get(1)).append(" HP\n");

            return top3.toString();
        }
    }

    /**
     * Returns the top 3 Pokemon with the highest attack.
     * Done by Hasan Salhi.
     *
     * @return a String containing the top 3 Pokemon with the highest attack.
     */
    public static String getTopAttack() {
        StringBuilder top3 = new StringBuilder();
        ArrayList<ArrayList<Object>> allPokemonNameAttack = new ArrayList<>();

        //Puts all Pokemon names and their attack into a 2D arraylist
        for (Team team : teams) {
            for (Pokemon pokemon : team.getPokemon()) {
                ArrayList<Object> currentPokemon = new ArrayList<>();
                currentPokemon.add(pokemon.getName());
                currentPokemon.add(pokemon.getAttack());
                allPokemonNameAttack.add(currentPokemon);
            }
        }

        if (allPokemonNameAttack.size() == 1) {return "Highest: " + allPokemonNameAttack.getFirst().getFirst() + " with " + allPokemonNameAttack.getFirst().get(1) + " Attack\n";}
        else if (allPokemonNameAttack.size() == 2) {
            allPokemonNameAttack.sort((o1, o2) -> (Integer) o1.get(1) - (Integer) o2.get(1));
            Collections.reverse(allPokemonNameAttack);

            return "Highest: " + allPokemonNameAttack.getFirst().getFirst() + " with " + allPokemonNameAttack.getFirst().get(1) + " Attack\n" + "Second: " + allPokemonNameAttack.get(1).getFirst() + " with " + allPokemonNameAttack.get(1).get(1) + " Attack\n";
        } else {

            //Sorts them according to attack
            allPokemonNameAttack.sort((o1, o2) -> (Integer) o1.get(1) - (Integer) o2.get(1));
            Collections.reverse(allPokemonNameAttack);
            top3.append("Highest: ").append(allPokemonNameAttack.get(0).get(0)).append(" with ").append(allPokemonNameAttack.get(0).get(1)).append(" Attack\n");
            top3.append("Second: ").append(allPokemonNameAttack.get(1).get(0)).append(" with ").append(allPokemonNameAttack.get(1).get(1)).append(" Attack\n");
            top3.append("Third: ").append(allPokemonNameAttack.get(2).get(0)).append(" with ").append(allPokemonNameAttack.get(2).get(1)).append(" Attack\n");

            return top3.toString();
        }
    }

    /**
     * Returns all Pokemon with the same Type.
     * Done by Hasan Salhi.
     *
     * @param type, the Type to search for.
     * @return a String containing the all Pokemon with the same Type.
     */
    public static String getAllType(Type type) {
        StringBuilder pokemonCommonType = new StringBuilder();
        ArrayList<String> allPokemonNameType = new ArrayList<>();

        //Adds Pokemon name to arraylist of name if one of types is matching
        for (Team team : teams) {
            for (Pokemon pokemon : team.getPokemon()) {
                if (pokemon.getTypeOne().equals(type) || pokemon.getTypeTwo().equals(type)) {
                    allPokemonNameType.add(pokemon.getName());
                }
            }
        }

        //Appends all names to StringBuilder in a list manner
        for (String pokemonName : allPokemonNameType) {
            pokemonCommonType.append(pokemonName).append("\n");
        }

        return pokemonCommonType.toString();
    }

    /**
     * Returns average attack of all Pokemon.
     * Done by Hasan Salhi.
     *
     * @return average attack value for all pokemon.
     */
    public static int getAvgAtk(){
        ArrayList<Integer> allAtk = new ArrayList<>();

        //Adds attack of all pokemon to one arraylist
        for (Team team : teams) {
            for (Pokemon pokemon : team.getPokemon()) {
                allAtk.add(pokemon.getAttack());
            }
        }

        //calculates average
        int mean = 0;
        for (Integer attack : allAtk) {
            mean += attack;
        }
        mean /= allAtk.size();

        return mean;
    }

    /**
     * Helper method to determine if an entered type is valid.
     * Done by Jordan Tran.
     *
     * @param input, the input of the user.
     * @return true for valid type false for invalid.
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
                11) list all Pokemon of a certain type
                
                Data Handling
                12) Import data from a file
                13) Write data to a file
                """;

    }

    /**
     * Reads a file.
     * Done by Jordan Tran.
     *
     * @param fileName, the file name of the file to be read.
     */
    public static void readFile(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/" + fileName));

            String line; // line to temporarily store data from reader
            ArrayList<String[]> lineValues = new ArrayList<>(); // arraylist to store string list values

            while((line = br.readLine()) != null){
                String[] values = line.split(","); // split line into a list to read
                lineValues.add(values); // add to arraylist
            }

            int teamCount = Integer.parseInt((lineValues.getLast())[0]); // integer to count number of team for team number variable
            // obtained by getting the team number of the last team in the list
            for(int i = 0; i < teamCount; i++){
                addTeam(); //adding teams to the arraylist
            }

            for(String[] currentLine : lineValues){ // looping through arraylist of data
                for (Team team : teams) {
                    if (team.getNumber() == Integer.parseInt(currentLine[0])) {
                        String name = currentLine[1]; // turning data into Pokemon attributes
                        int hp = Integer.parseInt(currentLine[2]);
                        int atk = Integer.parseInt(currentLine[3]);
                        Type typeOne = Type.valueOf(currentLine[4]);
                        Type typeTwo = Type.valueOf(currentLine[5]);

                        Pokemon toAdd = new Pokemon(name, hp, atk, typeOne, typeTwo); // making pokemon
                        toAdd.addMove(currentLine[6]);
                        toAdd.addItem(currentLine[7]);
                        toAdd.setWins(Integer.parseInt(currentLine[8])); // setting secondary parameters
                        toAdd.setLosses(Integer.parseInt(currentLine[9]));

                        team.addPokemon(toAdd); // add said pokemon
                    }
                }
            }
            System.out.println("Data imported successfully");
        }catch (IOException e){
            System.out.println("Error reading file " + e);
        }
    }

    /**
     * Writes current data to a file.
     * Done by Jordan Tran.
     */
    public static void writeFile(String fileName){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName))); // making a bufferedWriter
            for(Team team : teams){ // looping through teams list
                ArrayList<Pokemon> pokemon = team.getPokemon(); // get arraylist of Pokemon
                int teamNumber = team.getNumber(); // get teamNumber integer

                for(Pokemon toWrite : pokemon){
                    bw.write(teamNumber + ","); // convert to string to be written
                    bw.write(toWrite.getPokemon()); // using the humble for loop to write all pokemon in a team
                    bw.newLine(); // new line for each pokemon
                }

            }
            System.out.println("File written successfully.");
        }catch(IOException e){
            System.out.println("Error writing file " + e);

        }

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
                    System.out.println("\nTeam added.");
                    break;
                case 2: {
                    if (teams.isEmpty()) { // make sure teams is not empty
                        System.out.println("\nThere are no teams to add a Pokemon to!");
                    } else {
                        System.out.println("\nWhat team number would you like to add a Pokemon to?");
                        int teamChoice = scan.nextInt();
                        if (teamChoice > teams.size() || teamChoice < 1) { // account for teams starting at 1
                            System.out.println("\nThat team does not exist!");
                        } else {
                            //actual process of adding a pokemon starts here
                            scan.nextLine(); //"Fake" input to parse out the extra \n when the user presses enter.

                            System.out.println("\nEnter the Pokemon's name:");
                            String name = scan.nextLine();
                            System.out.println("\nEnter the Pokemon's HP:");
                            int hp = scan.nextInt();
                            System.out.println("\nEnter the Pokemon's Attack value:");
                            int attack = scan.nextInt();

                            //"Fake" input to parse out the extra \n when the user presses enter.
                            scan.nextLine();

                            System.out.println("\nEnter the Pokemon's type:");
                            String testOne = scan.nextLine();
                            System.out.println("\nEnter the Pokemon's second type (if not applicable, enter \"none\"):");
                            String testTwo = scan.nextLine(); // grabbing string inputs to check

                            if(checkEnum(testOne) && checkEnum(testTwo)){ // checking valid type input
                                Type typeOne = Type.valueOf(testOne.toUpperCase()); // .valueOf is case-sensitive so we need to turn input to uppercase
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
                        System.out.println("\nPokemon does not exist!");
                    }
                    break;
                }


                case 4: {// same as for 3)
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
                        System.out.println("\nPokemon does not exist!");
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
                        System.out.println("\nPokemon does not exist!");
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
                        System.out.println("\nPokemon does not exist!");
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
                    System.out.println("\nThe average attack value of all Pokemon in the Tracker is: " + getAvgAtk() + " ATK.");
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

                case 12: {
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nPlease enter the name of the .csv file you would like to import.");
                    String fileName = scan.nextLine(); // getting name of the file

                    readFile(fileName);
                    break;
                }

                case 13: {
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();
                    System.out.println("\nPlease enter the name of the .csv file you would like to write to.");
                    String fileName = scan.nextLine();

                    writeFile(fileName);
                    break;
                }
            }

        }while(choice != -1); // do while to loop through menu
        System.out.println("\nTracker closed.");
    }
}