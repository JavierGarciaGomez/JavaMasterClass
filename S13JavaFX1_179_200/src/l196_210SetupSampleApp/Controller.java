package l196_210SetupSampleApp;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import l196_210SetupSampleApp.dataModel.TodoData;
import l196_210SetupSampleApp.dataModel.TodoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    //196
    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea textArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu; // 207
    @FXML
    private ToggleButton filterToggleButton; // 209

    // 210
    private FilteredList<TodoItem> filteredList;
    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;

    public void initialize(){
/* 201: COMMENTED BECAUSE NOW THE LOAD IS ON FILE
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2020, Month.JUNE,25));
        TodoItem item2 = new TodoItem("Doctor's Appointm ent", "See Dr. Smith ad 123 Main Street",
                LocalDate.of(2020, Month.AUGUST,31));
        TodoItem item3 = new TodoItem("Finish design proposal for cliente", "I promised Mike I'd email it",
                LocalDate.of(2020, Month.MAY,22));
        TodoItem item4 = new TodoItem("Pickup Doug at train station", "Pick that guy",
                LocalDate.of(2020, Month.JULY,25));

        todoItems = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);

        // Set the first list
        TodoData.getInstance().setTodoItems(todoItems);
*/

        // 207 Context Menu
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        // aadd the menuitem
        listContextMenu.getItems().addAll(deleteMenuItem);



        //198 ChangeListener
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if(newValue!=null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    textArea.setText(item.getDetails());
                    // 199 DateTimeFormatter

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        //210
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return true;
            }
        };

        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                return (todoItem.getDeadline().equals(LocalDate.now()));
            }
        };


/*
        Replaced in 205
        //197
        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
*/
        //210
        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), wantAllItems);
        //209 sortedList
        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList);

        // populate the list with the items of TodoData
        // todoListView.setItems(TodoData.getInstance().getTodoItems()); 209 commented
        todoListView.setItems(sortedList);

        // Select just one item: the first
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        //206 cell factories
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>(){
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty){
                            setText(null);
                        }
                        else {
                            setText(item.getShortDesc());
                            if(item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.RED);
                            } else if(item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BROWN);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(// 207, as a parameter has a lambda expression
                        (obs, wasEmpty, isNowEmpty) -> {
                            if(isNowEmpty){
                                cell.setContextMenu(null);
                            } else{
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );
                return cell;
            }
        });




    }

    //197
    @FXML
    public void handleClickListedView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
/*        textArea.setText(item.getDetails()+" "+item.getDeadline());
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        textArea.setText(sb.toString());*/
        textArea.setText(item.getDetails());
        deadlineLabel.setText("DUE: "+item.getDeadline().toString());

    }

    // 202 Open Dialog menu
    @FXML
    public void showNewItemDialog(){
        // this class wraps a DialogPane
        Dialog<ButtonType> dialog = new Dialog<>();
        // Specifies the owner of the dialog window
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        //203
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try{
/*
            // Loads the fxml
            Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
*/
            // Get the pane
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch(IOException e){        }
        // Generate the buttons of the Dialog and an if
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        // A container that can contains a null value
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            TodoItem todoItem = controller.processResults(); // changed in 204
            /*// 204 add to the todolist
            // 205 deleted because of the DataBinding
            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            */
            // Select the new TodoItem
            todoListView.getSelectionModel().select(todoItem);

        }
    }

    //207
    private void deleteItem(TodoItem item) {
        // Popup dialog
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete todo item");
        alert.setHeaderText("Delete item: "+ item.getShortDesc());
        alert.setContentText("Are you sure? Press OK to confirm, or cance to back out");
        Optional<ButtonType> result =alert.showAndWait();
        // If ok is pressed
        if(result.isPresent() && (result.get() == ButtonType.OK)){
            TodoData.getInstance().deleteTodoItem(item);
        }
    }

    // 208 Delete with keyboard
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem!=null){
            if(keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }

    // 209-210
    @FXML
    public void handleFilter() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToggleButton.isSelected()) {
            filteredList.setPredicate(wantTodaysItems);
            if(filteredList.isEmpty()) {
                textArea.clear();
                deadlineLabel.setText("");
            } else if(filteredList.contains(selectedItem)) {
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
        } else {
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }

    //210
    @FXML
    public void handleExit() {
        Platform.exit();

    }



}
