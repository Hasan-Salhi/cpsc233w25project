package Project;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TrackerController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Tracker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 900);
        stage.sizeToScene(); // Force the stage to match the scene's preferred size

        stage.setScene(scene);
        stage.setTitle("Pokemon Team Tracker");
        stage.show();
    }

    @FXML
    private Label leftStatus = new Label("");

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
}
