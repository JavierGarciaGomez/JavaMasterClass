package S12CollectionsL152_178.try1_05_30.L171_178SortedCollections;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("new basket");
        sellItem(basket, "car", 1);
        System.out.println(basket);

        sellItem(basket,"car",1);
        System.out.println(basket);

        stockList.Items().get("car").adjustStock(2000);
        stockList.Items().get("car").adjustStock(-2000);
        System.out.println(stockList);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey()+" costs" + price.getValue());
        }

        System.out.println("*************NEW BASKET**************");
        Basket basket1 = new Basket("customer");
        sellItem(basket1, "cup", 100);
        sellItem(basket1, "juice", 5);
        removeItem(basket1, "cup",1);
        sellItem(basket1, "cup", 1);

        System.out.println(basket1);
        removeItem(basket, "car",1);
        removeItem(basket, "cup",9);
        removeItem(basket, "car",1);
        System.out.println("cars removed "+ removeItem(basket, "car", 1)); // should not remove any
        System.out.println(basket);

        // remove all items first basket
        removeItem(basket, "bread", 1);
        removeItem(basket, "cup", 3);
        removeItem(basket, "juice", 4);
        removeItem(basket, "cup", 4);
        System.out.println(basket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket1);
        System.out.println(stockList);
        checkOut(basket1);
        System.out.println(basket1);
        System.out.println(stockList);

        checkOut(basket);
        System.out.println(basket);
        checkOut(basket1);
        System.out.println(basket1);



    }

    public static int sellItem(Basket basket, String item, int quantity){
        // retrieve the item from strock list;
        StockItem stockItem = stockList.get(item);
        if(stockItem==null){
            System.out.println("We don't sell "+item);
            return 0;
        }
        if(stockList.sellStock(item, quantity)!=0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        // retrieve the item from strock list;
        StockItem stockItem = stockList.get(item);
        if(stockItem==null){
            System.out.println("We don't sell "+item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity)!=quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem, Integer> item: basket.Items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }


}

