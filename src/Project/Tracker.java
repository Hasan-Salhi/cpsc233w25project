package Project;

import Pokemon.*;

import Type.Type;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.media.Track;
import javafx.stage.Stage;

import java.util.Comparator;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * CPSC 233 W25 Project Project.Tracker Class
 * A class for tracking Pokemon.Pokemon statistics.
 *
 * @author Jade Torres, Jordan Tran, Hasan Salhi T01
 * @version 2.1 - March 22, 2025
 */
public class Tracker{
    protected static ArrayList<Team> teams = new ArrayList<>();

    /**
     * Adds a Project.Team to the Project.Tracker.
     * Done by Hasan Salhi.
     */
    public static void addTeam() {
        teams.add(new Team());
        // making a new Project.Team object
    }

    /**
     * Compares two Pokemon, returning the one with the highest ATK
     * parameters are simply two Pokemon
     */
    public static class AtkComparator implements Comparator<Pokemon>{
        @Override
        public int compare(Pokemon p1, Pokemon p2){
            if((p1 != null) && (p2 != null)) { //ensure not null
                return Integer.compare(p2.getAttack(), p1.getAttack());
            }
            return 0;
        }
    }

    /**
     * Class for comparing the HP of Pokemon.
     */
    public static class HpComparator implements Comparator<Pokemon>{
        @Override
        public int compare(Pokemon p1, Pokemon p2){
            if((p1 != null) && (p2 != null)) { //ensure not null
                return Integer.compare(p2.getHP(), p1.getHP()); // 2nd pokemon goes first to indicate it should go first
            }
            return 0; // return 0 as a base because it should theoretically never be a null case
        }
    }


    /**
     * Returns all Pokemon.Pokemon from all Teams.
     * Done by Jordan Tran.
     *
     * @return a String containing all Pokemon.Pokemon from all Teams.
     */
    public static String getAllPokemon() {
        StringBuilder toReturn = new StringBuilder();
        for(Team team : teams){
            toReturn.append("\n");
            toReturn.append(team); // use the team toString() function to print out every team
        }
        return String.valueOf(toReturn); // convert StringBuilder to a string and return
    }

    /**
     * Returns the top 3 Pokemon.Pokemon with the highest HP.
     * Done by Hasan Salhi.
     *
     * @return a String containing the top 3 Pokemon.Pokemon with the highest HP.
     */
    public static String getTopHP() {
        StringBuilder top3 = new StringBuilder();
        ArrayList<Pokemon> allPokemon = new ArrayList<>();

        //Puts all Pokemon.Pokemon names and their attack into a 2D arraylist
        for (Team team : teams) {
            allPokemon.addAll(team.getPokemon());
        }

        allPokemon.sort(new HpComparator()); // makes a new hp Comparator

        if(!allPokemon.isEmpty()){ // ensures not empty
            top3.append("\nHighest: ").append(allPokemon.getFirst().getName()).append(" with ").append(allPokemon.getFirst().getHP()).append(" HP.");
        }
        if(allPokemon.size() > 1){ //ensures at least 2 pokemon
            top3.append("\nSecond: ").append(allPokemon.get(1).getName()).append(" with ").append(allPokemon.get(1).getHP()).append(" HP.");
        }
        if(allPokemon.size() > 2){ //ensures all 3 needed pokemon exist
            top3.append("\nThird: ").append(allPokemon.get(1).getName()).append(" with ").append(allPokemon.get(1).getHP()).append(" HP.");
        }
        return top3.toString();
    }

    /**
     * Returns the top 3 Pokemon.Pokemon with the highest attack.
     * Done by Hasan Salhi.
     *
     * @return a String containing the top 3 Pokemon.Pokemon with the highest attack.
     */
    public static String getTopAttack() {
        StringBuilder top3 = new StringBuilder();
        ArrayList<Pokemon> allPokemonNameAttack = new ArrayList<>();

        //Puts all Pokemon.Pokemon names and their attack into a 2D arraylist
        for (Team team : teams) {
            allPokemonNameAttack.addAll(team.getPokemon());
        }

        allPokemonNameAttack.sort(new AtkComparator()); // makes a new Atk Comparator

        if(!allPokemonNameAttack.isEmpty()){ // only returns 1 if there is a single Pokemon
            top3.append("\nHighest: ").append(allPokemonNameAttack.getFirst().getName()).append(" with ").append(allPokemonNameAttack.getFirst().getAttack()).append(" ATK.");
        }
        if(allPokemonNameAttack.size() > 1){
            top3.append("\nSecond: ").append(allPokemonNameAttack.get(1).getName()).append(" with ").append(allPokemonNameAttack.get(1).getAttack()).append(" ATK.");
        } // basically just making sure the proper amount of Pokemon exist.
        if(allPokemonNameAttack.size() > 2){
            top3.append("\nThird: ").append(allPokemonNameAttack.get(1).getName()).append(" with ").append(allPokemonNameAttack.get(1).getAttack()).append(" ATK.");
        }
        return top3.toString();
    }

    /**
     * Returns all Pokemon.Pokemon with the same Type.Type.
     * Done by Hasan Salhi.
     *
     * @param type, the Type.Type to search for.
     * @return a String containing the all Pokemon.Pokemon with the same Type.Type.
     */
    public static String getAllType(Type type) {
        StringBuilder pokemonCommonType = new StringBuilder();
        ArrayList<String> allPokemonNameType = new ArrayList<>();

        //Adds Pokemon.Pokemon name to arraylist of name if one of types is matching
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
     * Returns average attack of all Pokemon.Pokemon.
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
     * Returns the menu of the Project.Tracker.
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
                
                Save Data
                12) Load data from a file
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
                        String name = currentLine[1]; // turning data into Pokemon.Pokemon attributes
                        int hp = Integer.parseInt(currentLine[2]);
                        int atk = Integer.parseInt(currentLine[3]);
                        String typeOne = (currentLine[4]);
                        String typeTwo = (currentLine[5]);

                        Pokemon toAdd = createPokemon(name, hp, atk, typeOne, typeTwo); // making pokemon

                        if(toAdd != null) {
                            toAdd.addMove(currentLine[6]);
                            toAdd.addItem(currentLine[7]);
                            toAdd.setWins(Integer.parseInt(currentLine[8])); // setting secondary parameters
                            toAdd.setLosses(Integer.parseInt(currentLine[9]));
                        }
                        team.addPokemon(toAdd); // add said pokemon
                    }
                }
            }
            br.close();
            System.out.println("\nData imported successfully.");
        }catch (IOException e){
            System.out.println("\nError reading file " + e);
        }
    }

    /**
     * Writes current data to a file.
     * Done by Jordan Tran.
     */
    public static void writeFile(String fileName){
        String srcPath = new File("src").getAbsolutePath();
        String filePath = srcPath + "/" + fileName; // Ensure correct path
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath))); // making a bufferedWriter
            for(Team team : teams){ // looping through teams list
                ArrayList<Pokemon> pokemon = team.getPokemon(); // get arraylist of Pokemon.Pokemon
                int teamNumber = team.getNumber(); // get teamNumber integer

                for(Pokemon toWrite : pokemon){
                    bw.write(teamNumber + ","); // convert to string to be written
                    bw.write(toWrite.getPokemon()); // using the humble for loop to write all pokemon in a team
                    bw.newLine(); // new line for each pokemon
                }
            }
            bw.close();
            System.out.println("\nFile written successfully.");
        }catch(IOException e){
            System.out.println("\nError writing file " + e);

        }

    }

    /**
     * Empties field teams.
     * Used in the TrackerTest class.
     * Done by Jade Torres.
     */
    public static void emptyTeams() {
        teams.clear();
    }


    /**
     * makes a pokemon of certain child class of Pokemon
     * @param name name
     * @param hp hp
     * @param atk atk
     * @param primType primary and prioritized type for the subclass
     * @param secType secondary typing
     * @return
     */
    public static Pokemon createPokemon(String name, int hp, int atk, String primType, String secType){
        Type typeOne = Type.valueOf(primType.toUpperCase()); // .valueOf is case-sensitive so we need to turn input to uppercase
        Type typeTwo = Type.valueOf(secType.toUpperCase());
        Pokemon toAdd = new BugPokemon(name,hp,atk,typeOne,typeTwo);

        //switch case for the very very many pokemon types
        switch(typeOne){
            case BUG -> {
                return new BugPokemon(name,hp,atk,typeOne,typeTwo);
            }case DARK ->{
                return new DarkPokemon(name,hp,atk,typeOne,typeTwo);
            }case DRAGON ->{
                return new DragonPokemon(name,hp,atk,typeOne,typeTwo);
            }case ELECTRIC -> {
                return new ElectricPokemon(name,hp,atk,typeOne,typeTwo);
            }case FAIRY ->{
                return new FairyPokemon(name,hp,atk,typeOne,typeTwo);
            }case FIGHTING ->{
                return new FightingPokemon(name,hp,atk,typeOne,typeTwo);
            }case FIRE -> {
                return new FirePokemon(name,hp,atk,typeOne,typeTwo);
            }case FLYING ->{
                return new FlyingPokemon(name,hp,atk,typeOne,typeTwo);
            }case GHOST ->{
                return new GhostPokemon(name,hp,atk,typeOne,typeTwo);
            }case GRASS -> {
                return new GrassPokemon(name,hp,atk,typeOne,typeTwo);
            }case GROUND ->{
                return new GroundPokemon(name,hp,atk,typeOne,typeTwo);
            }case ICE ->{
                return new IcePokemon(name,hp,atk,typeOne,typeTwo);
            }case NORMAL -> {
                return new NormalPokemon(name,hp,atk,typeOne,typeTwo);
            }case PSYCHIC ->{
                return new PsychicPokemon(name,hp,atk,typeOne,typeTwo);
            }case ROCK ->{
                return new RockPokemon(name,hp,atk,typeOne,typeTwo);
            }case STEEL ->{
                return new SteelPokemon(name,hp,atk,typeOne,typeTwo);
            }
        }

        return null;
    }


    /**
     * The main method for running the Project.Tracker.
     * Done by Jordan Tran.
     */
    /*
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in); // make scanner
        int choice;

        do{
            System.out.println(getMenu()); // print menu
            System.out.println("Please select one of the options above (-1 to stop tracking):");
            choice = scan.nextInt();

            switch(choice){ // switch to handle numbers as well as inputs greater than 12 or less than 1
                case 1:
                    addTeam();
                    System.out.println("\nProject.Team added.");
                    break;
                case 2: {
                    if (teams.isEmpty()) { // make sure teams is not empty
                        System.out.println("\nThere are no teams to add a Pokemon.Pokemon to!");
                    } else {
                        System.out.println("\nWhat team number would you like to add a Pokemon.Pokemon to?");
                        int teamChoice = scan.nextInt();
                        if (teamChoice > teams.size() || teamChoice < 1) { // account for teams starting at 1
                            System.out.println("\nThat team does not exist!");
                        } else {
                            //actual process of adding a pokemon starts here
                            scan.nextLine(); //"Fake" input to parse out the extra \n when the user presses enter.

                            System.out.println("\nEnter the Pokemon.Pokemon's name:");
                            String name = scan.nextLine();
                            System.out.println("\nEnter the Pokemon.Pokemon's HP:");
                            int hp = scan.nextInt();
                            System.out.println("\nEnter the Pokemon.Pokemon's Attack value:");
                            int attack = scan.nextInt();

                            //"Fake" input to parse out the extra \n when the user presses enter.
                            scan.nextLine();

                            System.out.println("\nEnter the Pokemon.Pokemon's type:");
                            String testOne = scan.nextLine();
                            System.out.println("\nEnter the Pokemon.Pokemon's second type (if not applicable, enter \"none\"):");
                            String testTwo = scan.nextLine(); // grabbing string inputs to check

                            if(checkEnum(testOne) && checkEnum(testTwo)){ // checking valid type input

                                // grab pokemon info and turn it into a pokemon
                                Pokemon toAdd = createPokemon(name, hp, attack, testOne, testTwo);

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

                    System.out.println("\nEnter a Pokemon.Pokemon:");
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
                        System.out.println("\nPokemon.Pokemon does not exist!");
                    }
                    break;
                }


                case 4: {// same as for 3)
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon.Pokemon:");
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
                        System.out.println("\nPokemon.Pokemon does not exist!");
                    }
                    break;
                }


                case 5 :{ // same as 6
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon.Pokemon:");
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
                        System.out.println("\nPokemon.Pokemon does not exist!");
                    }

                    break;
                }


                case 6:{ // identical to 5
                    //"Fake" input to parse out the extra \n when the user presses enter.
                    scan.nextLine();

                    System.out.println("\nEnter a Pokemon.Pokemon:");
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
                        System.out.println("\nPokemon.Pokemon does not exist!");
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
                    System.out.println("\nThe average attack value of all Pokemon.Pokemon in the Project.Tracker is: " + getAvgAtk() + " ATK.");
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
        System.out.println("\nProject.Tracker closed.");
    }*/
}