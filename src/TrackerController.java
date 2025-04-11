import Pokemon.*;
import Type.Type;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class TrackerController extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Tracker.class.getResource("Tracker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 600);

        stage.setScene(scene);
        stage.setTitle("Pokemon Team Tracker");
        stage.show();
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
        alert.setHeaderText("About Pokemon Team Tracker"); // making alert details
        alert.setContentText("\nCreators: Jade Torres, Hasan Salhi, Jordan Tran\nTutorial 01" +
                "\nThis program allows you to track various teams of Pokemon, viewing information about each Pokemon.");
        alert.showAndWait(); // makes the popup and waits for the user to close it
    }
}
