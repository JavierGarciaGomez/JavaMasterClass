package S08ArraysListsBoxingL98_121.l104_ArrayList;

import java.util.ArrayList;

public class GroceryList {
    // 104
    private int[] myNumbers = new int[50];
    private ArrayList <String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item){
        groceryList.add(item);

    }

    public void printGroceryList(){
        System.out.println("You have "+groceryList.size()+ " items in yout grocery list");
        for(int i=0; i<groceryList.size();i++){
            System.out.println(groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String item){
        groceryList.set(position, item);
    }

    public void removeGroceryItem(String object){
        groceryList.remove(object);
    }

    /* 105. ArrayList part 2*/
//    public String findItem(String searchedItem){
//        boolean exists = groceryList.contains(searchedItem);
//        String answer;
//        if (exists==true) answer=searchedItem + " is in the list";
//        else answer=searchedItem+" is not in the list";
//
//        return answer;
//    }

    // 106. ArrayList part 3
    public int findItem(String searchedItem){
        return groceryList.indexOf(searchedItem);
    }

    public void modifyGroceryItem(String oldItem, String newItem){
        int position=findItem(oldItem);
        modifyGroceryItem(position, newItem);
    }

    public boolean onFile(String searchItem){
        if (findItem(searchItem)>0) return true;
        else return false;
    }

    public ArrayList<String> getGroceryList() {
        return this.groceryList;
    }
}
