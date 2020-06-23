package S12CollectionsL152_178.try2_06_01.l174SortedCollections4TreeMap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    // Getters
    // Collections.unmodifiableMap() returns a view of a map that cant be modified.
    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }

    public StockItem getStockItem(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
            System.out.println(item.getKey()+" "+item.getValue());
        }
        return Collections.unmodifiableMap(prices);
    }


    // Methods

    public void addStock(StockItem item) {
        if(item != null) {
            // getOrDefault(): get the item linked to the key if it already exits, if don't the item passed in the parameter
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if(inStock != item) {
                item.adjustStock(inStock.getQuantityInStock());
            }
            // Either way, put it on the list
            list.put(item.getName(), item);
            //return item.changeInStock();
        }
        //return 0;
    }




    public void sellItem(String item, int quantity){
        StockItem stockItem = list.getOrDefault(item, null);
        if(stockItem!=null && stockItem.getQuantityInStock()>=quantity && quantity>=0){
            System.out.println(stockItem.getName()+" sold: "+quantity);
            stockItem.adjustStock(-quantity);
        }

    }


/*    public int reserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if((inStock!= null) && quantity>0){
            //return inStock.reserveStock(quantity);
        }
        return 0;
    }*/

/*    public int unreserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if((inStock!= null) && quantity>0){
            //return inStock.unreserveStock(quantity);
        }
        return 0;
    }*/

/*



*/

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();
            s = s + stockItem + ". There are " + stockItem.getQuantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
