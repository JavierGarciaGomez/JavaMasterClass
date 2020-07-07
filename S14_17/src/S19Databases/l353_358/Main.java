package S19Databases.l353_358;

import S19Databases.l353_358.Controller.MainController;
import S19Databases.l353_358.Model.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.listArtists();

        primaryStage.setTitle("Music database");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!Datasource.getInstance().connect()) {
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().disconnect();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
