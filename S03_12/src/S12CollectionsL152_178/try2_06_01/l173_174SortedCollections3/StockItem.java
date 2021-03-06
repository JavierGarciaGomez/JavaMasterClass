package S12CollectionsL152_178.try2_06_01.l173_174SortedCollections3;

/**
 * Created by dev on 16/02/2016.
 */
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock = 0;
    //private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;  // or here (but you wouldn't normally do both).
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if(newQuantity >=0) {
            this.quantityInStock = newQuantity;
        }
        System.out.println("Trying to add "+quantity+ " of "+this.name+
                ". The new quantity is "+this.quantityInStock);
    }

//    public void reserve(int quantity) {
//        if (getQuantityInStock()-quantity>=0){
//            this.reserved=reserved+quantity;
//            this.quantityInStock=getQuantityInStock()-quantity;
//        }
//    }

//    public int reserveStock(int quantity){
//        if(quantity<= changeInStock()){
//            reserved+=quantity;
//            return quantity;
//        }
//        return 0;
//    }

//    public int unreserveStock(int quantity){
//        if(quantity<=reserved){
//            reserved-=quantity;
//            return quantity;
//        }
//        return 0;
//    }

//    public int finaliceStock(int quantity){
//        if(quantity<= reserved){
//            quantityInStock-=quantity;
//            reserved-=quantity;
//            return quantity;
//        }
//        return 0;
//    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }
        // Comparison based on String
        if(o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

}
