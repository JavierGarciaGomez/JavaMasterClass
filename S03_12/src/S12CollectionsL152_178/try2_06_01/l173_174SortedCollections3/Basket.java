package S12CollectionsL152_178.try2_06_01.l173_174SortedCollections3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    // StockItem and the quantity
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new HashMap<>();
    }

    public void addToBasket(StockItem item, int quantity){
        if((item!=null) && (quantity>0)){
            // if exists get the quantity, if not 0
            int inBasket = basketList.getOrDefault(item,0);
            item.adjustStock(-quantity);
            basketList.put(item, quantity+inBasket);
        }
    }

    public Map<StockItem, Integer> getItems(){
        return Collections.unmodifiableMap(basketList);
    }

    private double getTotalCost(){
        double totalCost=0;
        for(Map.Entry<StockItem, Integer> entry: basketList.entrySet()){
            totalCost+=entry.getKey().getPrice()*entry.getValue();
        }
        return totalCost;
    }

    @Override
    public String toString() {
        String s = "\n Shopping basket: "+this.name+ "cointains ";
        for(Map.Entry entry: basketList.entrySet()){
            StockItem stockItem = (StockItem)entry.getKey();
            s=s+"\n"+entry.getValue()+" units of "+stockItem.getName();
        }
        s=s+"\n Total cost:"+getTotalCost();
        return s;
    }
}
