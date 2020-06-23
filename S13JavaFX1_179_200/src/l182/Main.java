package l182;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /* This uses the MVC and it corresponds with the main, the fxml and the controller
      The Application superclass is the entry point, this class has three very important methods
      for the lifecycle: init-start-stop.

      the start():
      takes a stage parameter. Stage is a top level javaFX contianer that extends windows class

     */

    @Override
    public void start(Stage primaryStage) throws Exception{
        /* 182. Not using the FXML file
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER); // Positiion
        root.setVgap(10);
        root.setHgap(10);
        // Adding a label
        Label greeting = new Label("Welcome to JavaFX!"); // Creating the label
        greeting.setTextFill(Color.GREEN); // Font color
        greeting.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 48));// change font
        root.getChildren().add(greeting); // Adding to the layout
        */

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello Home");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
