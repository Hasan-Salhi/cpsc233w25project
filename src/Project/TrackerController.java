package Project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import Pokemon.*;
import Type.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

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
    private TextField pokeMove; // pokemon add detail parameters
    @FXML
    private TextField pokeItem;
    @FXML
    private TextField pokeWins;
    @FXML
    private TextField pokeLosses;


    @FXML
    ObservableList<String> options = FXCollections.observableArrayList(); // updates the teams choicebox over time
    @FXML
    ChoiceBox<String> teamsChoiceBox = new ChoiceBox<>(options);

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

        teamNum.setTextFormatter(new TextFormatter<>(intFilter));
        pokeHp.setTextFormatter(new TextFormatter<>(intFilter)); // set filter to integer textfields
        pokeAtk.setTextFormatter(new TextFormatter<>(intFilter));

        // Set the ChoiceBox items to the observable list
        teamsChoiceBox.setItems(options);
        primType.setItems(types);
        seconType.setItems(types);
        primType.setValue(Type.NORMAL);
        seconType.setValue(Type.NONE); // set default types

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
        options.add("Team " + Team.getNumber()); // add new team to choicebox options

    }

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
                if(num > Team.getNumber()){
                    leftStatus.setText("That team does not exist!");
                }
            }
        }catch(NumberFormatException e){ // catches having no integer value
            leftStatus.setText("Missing integer parameter.");
        }
    }
}
