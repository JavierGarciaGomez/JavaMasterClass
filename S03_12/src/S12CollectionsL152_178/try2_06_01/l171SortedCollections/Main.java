package S12CollectionsL152_178.try2_06_01.l171SortedCollections;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockList stockList = new StockList();
        stockList.addStock(new StockItem("bread", 0.86, 10));
        stockList.addStock(new StockItem("bread", 0.86, -20));
        stockList.sellItem("bread", 5);

        System.out.println(stockList.toString());
    }

}

