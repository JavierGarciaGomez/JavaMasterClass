package l211_213CSS_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // Use a theme
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        primaryStage.setTitle("Hello Home");
        primaryStage.setScene(new Scene(root, 600, 250));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
