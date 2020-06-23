package l196_210SetupSampleApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import l196_210SetupSampleApp.dataModel.TodoData;

import java.io.IOException;

public class Main extends Application {

    // 201
    @Override
    public void init() throws Exception {
        try{
            // Loading the files when the app is loaded
            TodoData.getInstance().loadTodoItems();
        }catch(IOException e){        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }



    //201
    @Override
    public void stop() throws Exception {
        try{
            // Saving the files when the app is stopped
            TodoData.getInstance().storeTodoItems();
        }catch(IOException e){        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
