package Project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import Pokemon.*;
import Type.Type;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import static Project.Tracker.readFile;
import static Project.Tracker.teams;

public class TrackerController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tracker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 625);
        stage.sizeToScene(); // Force the stage to match the scene's preferred size

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Pokemon Team Tracker");
        stage.show();
    }

    @FXML
    private Label leftStatus = new Label(""); // status label

    @FXML
    ObservableList<Type> types = FXCollections.observableArrayList(Type.getTypes()); //grabbing the list of types, needed to convert to an observable list.

    @FXML
    private TextField teamNum; // pokemon parameters
    @FXML
    private TextField pokeName;
    @FXML
    private TextField pokeHp;
    @FXML
    private TextField pokeAtk;
    @FXML
    private ChoiceBox<Type> primType;
    @FXML
    private ChoiceBox<Type> seconType;
    @FXML
    private ChoiceBox<Type> findTypes;

    @FXML
    private TextField pokeMove; // pokemon add detail parameters
    @FXML
    private TextField pokeItem;
    @FXML
    private TextField pokeWins;
    @FXML
    private TextField pokeLosses;

    @FXML
    static ObservableList<String> options = FXCollections.observableArrayList(); // updates the teams choicebox over time
    @FXML
    ChoiceBox<String> teamsChoiceBox = new ChoiceBox<>(options);

    @FXML
    ChoiceBox<Pokemon> infoPokemon; // choiceboxes for the pokemon lists
    @FXML
    ChoiceBox<Pokemon> teamPokemon;
    @FXML
    TextArea pokeInfo;
    @FXML
    TextArea findBox;

     // observable arraylist of team based pokemon
    @FXML
    ObservableList<Pokemon> tempPokemon = FXCollections.observableArrayList();


    // This initialize method is automatically called after the FXML is loaded
    public void initialize() {
        Pattern validIntegerPattern = Pattern.compile("\\d*");
        //this code was ripped straight from my Assignment 3
        UnaryOperator<TextFormatter.Change> intFilter = change -> { //only allow positive integers to be input into specified textfiel
            // a unary operator makes a text change, and then decides if the change should be kept.
            if (validIntegerPattern.matcher(change.getControlNewText()).matches()) {
                return change; // allows the textfield to change if it matches a positive integer
            }
            return null; // if not, it blocks the user from entering anything.
        };
        Tracker.addTeam(); // add a team to begin
        options.add("Team " + Team.getTotalTeams());
        teamsChoiceBox.setValue(options.getFirst());
        teamBoxListener(teamsChoiceBox);

        teamPokemon.setItems(tempPokemon);
        infoPokemon.setItems(tempPokemon); // basically making these two the same

        pokemonBoxListener(teamPokemon);

        teamNum.setTextFormatter(new TextFormatter<>(intFilter));
        pokeHp.setTextFormatter(new TextFormatter<>(intFilter)); // set filter to integer textfields
        pokeAtk.setTextFormatter(new TextFormatter<>(intFilter));
        pokeWins.setTextFormatter(new TextFormatter<>(intFilter));
        pokeLosses.setTextFormatter(new TextFormatter<>(intFilter));

        // Set the ChoiceBox items to the observable list
        teamsChoiceBox.setItems(options);
        primType.setItems(types);
        seconType.setItems(types);
        primType.setValue(Type.NORMAL);
        seconType.setValue(Type.NONE); // set default types

        findTypes.setItems(types); // findTypes does not need a default type
    }

    /**
     * closes the application
     * @param event is the user clicking on the quit button
     */
    public void closeApp(ActionEvent event){
        System.out.println("Program closed.");
        Platform.exit();
    }

    public void showAbout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Program");
        alert.setHeaderText("About Pokemon Project.Team Project.Tracker"); // making alert details
        alert.setContentText("\nCreators: Jade Torres, Hasan Salhi, Jordan Tran\nTutorial 01" +
                "\nThis program allows you to track various teams of Pokemon, viewing information about each Pokemon.");
        alert.showAndWait(); // makes the popup and waits for the user to close it
    }

    public void makeTeam(ActionEvent event){
        Tracker.addTeam();
        options.add("Team " + Team.getTotalTeams()); // add new team to choicebox options
    }

    /**
     * creates a pokemon when all the requirements are met
     * @param event is the button being pressed
     */
    public void makePokemon(ActionEvent event){
        try{
            int num = Integer.parseInt(teamNum.getText());
            int atk = Integer.parseInt(pokeAtk.getText());
            int hp = Integer.parseInt(pokeHp.getText());
            String name = pokeName.getText();
            if(num == 0){
                leftStatus.setText("Team number cannot be 0!"); // filter doesn't catch 0 so we need to account for that
                return;
            }

            if(name.isEmpty()){ // calling getText() on an empty textfield returns an empty string
                leftStatus.setText("Missing Pokemon Name!");
            }else if(String.valueOf(primType).equals("NONE")){
                leftStatus.setText("Must have a Primary Type!"); // make sure primary type even exists
            }else {
                leftStatus.setText(""); // clear leftStatus so user knows it worked
                // making Pokemon
                Pokemon toAdd = Tracker.createPokemon(name, hp, atk, String.valueOf(primType.getValue()), String.valueOf(seconType.getValue()));
                // now we check that the team exists
                if(num > Team.getTotalTeams()){
                    leftStatus.setText("That team does not exist!");
                }else{
                    for (Team team : teams) {
                        if (team.getNumber() == num) {
                            // loop through team list to get desired team
                            team.addPokemon(toAdd); // add said pokemon

                            teamPokemon.getItems().add(toAdd);
                            return;
                        }
                    }
                }
            }

        }catch(NumberFormatException e){ // catches having no integer value
            leftStatus.setText("Missing integer parameter.");
        }
    }

    /**
     * function to add details to a Pokemon
     */
    public void addDetails(ActionEvent event){
        try{
            if(infoPokemon.getValue() == null){
                leftStatus.setText("No Pokemon selected!");
                return;
            } //handling missing parameters
            if(pokeMove.getText().isEmpty()){
                leftStatus.setText("No move entered!");
                return;
            }
            if(pokeItem.getText().isEmpty()){
                leftStatus.setText("No item entered!");
            }
            //this will only execute if every variable is present

            Pokemon toAdd = infoPokemon.getValue();
            String move = pokeMove.getText();
            String item = pokeItem.getText();
            int wins = Integer.parseInt(pokeWins.getText());
            int losses = Integer.parseInt(pokeLosses.getText());

            toAdd.addMove(move);
            toAdd.addItem(item);
            toAdd.setWins(wins);
            toAdd.setLosses(losses); // setting parameters
            leftStatus.setText(""); // clear status

            StringBuilder toSet = new StringBuilder();
            toSet.append(toAdd.stringVer()).append("\n\n")
                    .append(toAdd.getTypeWeakness()).append("\n\n")
                    .append(toAdd.getSTAB()).append("\n")
                    .append(toAdd.useMove()).append("\n\n")
                    .append(toAdd.typePassive());

            pokeInfo.setText(toSet.toString());

        }catch(NumberFormatException e){
            leftStatus.setText("Missing integer parameter.");
        }
    }

    /**
     * function to tell whenever the team choicebox changes value
     */
    public void teamBoxListener(ChoiceBox<String> choiceBox) {
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            // If the selection is cleared, newValue will be null
            if (newValue == null) {
                tempPokemon.clear();
                teamPokemon.setItems(tempPokemon);
                infoPokemon.setItems(tempPokemon);
                return;
            }

            // Clear the display list
            tempPokemon.clear();

            // Extract team number (assumes "Team X" format)
            int newTeam = Integer.parseInt(newValue.substring(5).trim());

            // Copy only that team’s pokemon into the display list
            for (Team team : Tracker.teams) {
                if (team.getNumber() == newTeam) {
                    tempPokemon.addAll(team.getPokemon());
                    break;
                }
            }

            // Update your ChoiceBoxes (or ListViews)
            teamPokemon.setItems(tempPokemon);
            infoPokemon.setItems(tempPokemon);
        });
    }

    /**
     * gets all the pokemon of a specific type
     * @param event is a button being pressed
     */
    public void allType(ActionEvent event){
        Type type = findTypes.getValue();
        String typeList = Tracker.getAllType(type);

        if(type == null){
            leftStatus.setText("Select a typing first!");
            return;
        }
        findBox.setText("All the Pokemon of " + type + " typing are:\n" + typeList);
        leftStatus.setText("");
    }

    /**
     * gets all the pokemon in general
     * @param event is a button being pressed
     */
    public void allPokemon(ActionEvent event){
        findBox.setText(Tracker.getAllPokemon());
        leftStatus.setText("");
    }

    /**
     * gets the Pokemon with the top 3 attack
     * @param event is a button being pressed
     */
    public void topAttack(ActionEvent event){
        findBox.setText(Tracker.getTopAttack());
        leftStatus.setText("");
    }

    /**
     * gets the Pokemon with the top 3 hp
     * @param event is a button being pressed
     */
    public void topHp(ActionEvent event){
        findBox.setText(Tracker.getTopHP());
        leftStatus.setText("");
    }

    /**
     * gets the average attack of all pokemon
     * @param event is a button being pressed
     */
    public void averageAttack(ActionEvent event){
        findBox.setText("The average attack value of all Pokemon in the Tracker is: " + Tracker.getAvgAtk() + " ATK.");
        leftStatus.setText("");
    }

    /**
     * Handles choosing a .csv file from the users device
     */
    @FXML
    public void handleOpenFile(ActionEvent event){
        options.clear(); // clear everything
        tempPokemon.clear();
        final FileChooser fileChooser = new FileChooser(); // allows user to choose a file
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setInitialFileName("Tracker.csv");

        fileChooser.setTitle("Select a .csv File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv", "*.CSV")); // limiting to .csv files

        File toOpen = fileChooser.showOpenDialog(new Stage());

        if(toOpen != null){
            leftStatus.setText("File Loaded!");
            Tracker.readFile(toOpen); //runs battle loader on the file
        }else{
            leftStatus.setText("No file was loaded!");
        }
    }

    /**
     * Handles saving a .csv file to the users device (equivalent to handleOpenFile)
     */
    @FXML
    public void handleSaveFile(ActionEvent event){
        final FileChooser fileChooser = new FileChooser(); // allows user to choose a file
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.setInitialFileName("Test.csv");

        fileChooser.setTitle("Select a save file name");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv", "*.CSV"));

        File toOpen = fileChooser.showSaveDialog(new Stage());
        if(toOpen != null){
            leftStatus.setText("File saved!");

            Tracker.writeFile(toOpen);
        }else{ // setting left status to match what happens
            leftStatus.setText("Nothing was saved!");
        }
    }
    /**
     * displays the information for a selected pokemon
     * @param choiceBox is the choicebox of pokemon associated with a team
     */
    public void pokemonBoxListener(ChoiceBox<Pokemon> choiceBox) {
        choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            // If the selection is cleared, newValue will be null
            if (newValue == null) {
                pokeInfo.clear();
                return;
            }

            // Build and show the info for the newly selected Pokemon
            StringBuilder toSet = new StringBuilder();
            toSet.append(newValue.stringVer()).append("\n\n")
                    .append(newValue.getTypeWeakness()).append("\n\n")
                    .append(newValue.getSTAB()).append("\n")
                    .append(newValue.useMove()).append("\n\n")
                    .append(newValue.typePassive());

            pokeInfo.setText(toSet.toString());
        });
    }

}
