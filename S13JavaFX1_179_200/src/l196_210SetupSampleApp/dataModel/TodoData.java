package l196_210SetupSampleApp.dataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;


        /*
        199-200 Singleton
        Its a class with just one instance
        the constructor is private
        it contains a static method to get the instance: getInstance

        We use a singleton we just want an instance for the entire run of the app
        */

public class TodoData {
    // FIELDS
    // the instance
    private static TodoData instance = new TodoData();
    // the file where the items are gonna be save
    private static String fileName = "TodoListItems.txt";
    /*
    * 205
    * DataBinding: when the controller is populated is going to react the changes
    * changing List to ObservableList
    * */
    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formatter;


    // CONSTRUCTOR, but as a Singleton is private
    private TodoData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
    }

    // GETTERS AND SETTERS
    // the getter of the instance
    public static TodoData getInstance(){
        return instance;
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    } // change 205

/* 201 commented, because now the data is obtained with the file
    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
*/

    // METHODS

    public void loadTodoItems() throws IOException {

        todoItems= FXCollections.observableArrayList();
        Path path = Paths.get(fileName);

        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try{
            while((input=br.readLine())!=null){
                // for each line: create a String array, store the elements and with those instantiate a new todoItem, and add it to the todoItem class
                String[] itemPieces = input.split("\t");
                String shortDesc = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                // format the date
                LocalDate date = LocalDate.parse(dateString, formatter);
                TodoItem todoItem = new TodoItem(shortDesc, details, date);
                todoItems.add(todoItem);
            }
        } finally{
            if(br != null){
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException{
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try{
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext()){
                TodoItem item =iter.next();
                bw.write(String.format("%s\t%s\t%s", item.getShortDesc(), item.getDetails(), item.getDeadline().format(formatter)));
                bw.newLine();
            }
        }finally{
            if(bw != null){
                bw.close();
            }
        }
    }

    // 203
    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    //207
    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }
}
