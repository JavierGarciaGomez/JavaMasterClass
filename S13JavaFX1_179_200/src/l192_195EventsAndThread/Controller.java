package l192_195EventsAndThread;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField nameTextField;
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label ourLabel;

    //193 initialize
    @FXML
    public void initialize(){
        button1.setDisable(true);
        button2.setDisable(true);
    }

    //192 public void onButtonClicked(){
    //193
    // we can get information about the source
    public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(button1)){
            System.out.println("Hello "+nameTextField.getText());
        } else if(e.getSource().equals(button2)){
            System.out.println("BYE "+nameTextField.getText());
        }
        // 195 runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread()?"UI Thread":"Background Thread";
                    System.out.println("Im going to sleep on the: "+s);
                    Thread.sleep(5000);
                    // runLater() Receives a runnable as a parameter
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread()?"UI Thread":"Background Thread";
                            System.out.println("Im updating the label on the: "+s);
                            ourLabel.setText("We did something");
                        }
                    });
                } catch(InterruptedException exception){
                    exception.printStackTrace();
                }
            }
        };
        new Thread(task).start();

        if(checkBox.isSelected()){
            nameTextField.clear();
            button1.setDisable(true);
            button2.setDisable(true);
        }
    }

    // 193
    // if the text is empty disable buttons
    @FXML
    public void handleKeyReleased(){
        String text=nameTextField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        button1.setDisable(disableButtons);
        button2.setDisable(disableButtons);
    }

    // 194
    public void handleChange(){
        System.out.println("the checkbox is "+(checkBox.isSelected()?"checked":"not checked"));

    }


}
