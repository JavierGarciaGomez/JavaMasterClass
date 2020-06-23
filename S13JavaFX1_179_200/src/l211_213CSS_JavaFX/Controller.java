package l211_213CSS_JavaFX;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {
    @FXML
    private Label label;
    // 212
    @FXML
    private Button button4;
    @FXML
    private FlowPane flowPane;


    public void initialize(){
        // 212
        button4.setEffect(new DropShadow());
    }

    //212
    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    //212
    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    //212g
    public void handleClick(ActionEvent event) {
/*
        FileChooser chooser = new FileChooser();
        chooser.showOpenDialog(flowPane.getScene().getWindow());
*/
/*
        213 commented
        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(flowPane.getScene().getWindow());
*/
        FileChooser chooser=new FileChooser();
        chooser.setTitle("Save app file");
        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text", "*.txt"),
            new FileChooser.ExtensionFilter("PDF", "*.pdf"),
            new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
            new FileChooser.ExtensionFilter("All files", "*.*")
        );
        // showSaveDialog
        File file = chooser.showOpenDialog(flowPane.getScene().getWindow()); // It could be showMultipleOpenDialog
        if(file!=null){
            System.out.println(file.getPath());
        } else{
            System.out.println("Chooser was cancelled");
        }


    }

    // 213
    @FXML
    public void handleLinkClick(ActionEvent event) {
        try{
            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

