package S12CollectionsL152_178.try2_06_01.l175_178Challenge;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 10);
        stockList.addStock(temp);
        temp = new StockItem("bread", 0.89, 20);
        stockList.addStock(temp);
        temp = new StockItem("car", 100, 10);
        stockList.addStock(temp);


        //////
        Basket basket = new Basket("Basket1");
        addToBasket(basket, "bread", 5);
        addToBasket(basket, "car", 12);
        addToBasket(basket, "car", 1);
        addToBasket(basket, "Television", 2);

        System.out.println(basket);
        System.out.println(stockList.toString());

    }

    public static void sellItem(Basket basket, String itemName, int quantity){
        StockItem stockItem = stockList.getStockItem(itemName);
        if(stockItem==null){
            System.out.println("We don't sell "+itemName);
        }
        else{
            // check if there is enough quantity
            if (stockItem.getQuantityInStock()>=quantity){
                System.out.println("SOLD!");
                basket.addToBasket(stockItem, quantity);
            }
            else{
                System.out.println("Sorry, We just have "+stockItem.getQuantityInStock()+" "+itemName);
            }
        }
    }

    public static void addToBasket(Basket basket, String itemName, int quantity){
        StockItem stockItem = stockList.getStockItem(itemName);
        if(stockItem==null){
            System.out.println("We don't sell "+itemName);
        }
        else{
            // check if there is enough quantity
            if (stockItem.getQuantityInStock()>=quantity){
                basket.addToBasket(stockItem, quantity);
            }
            else{
                System.out.println("Sorry, We just have "+stockItem.getQuantityInStock()+" "+itemName);
            }
        }
    }


}


