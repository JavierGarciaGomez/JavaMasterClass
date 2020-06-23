package S09InnerAbstractClassInterfacesL122_134.L131_134Challenge;

public abstract class ListItem {
    // Protected instead of private, because we need access in the subclass
    protected ListItem rightLink = null;
    protected ListItem leftLink =null;

    // The abstract class will also need to hold a value - try to be as flexible as possible
    protected Object value;

    // Constructor
    public ListItem(Object value){
        this.value=value;
    }

    //Getter and setter
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    // The class will also need methods to move to the next item and back to the previous item,
    // and methods to set the next and previous items.
    abstract ListItem next();
    abstract ListItem previous();
    abstract ListItem setNext(ListItem item);
    abstract ListItem setPrevious(ListItem item);

    // You should also specify a compareTo() method that takes a parameter of the same type as the
    // class and returns 0 if the values are equal, greater than zero if the value sorts greater than
    // the parameter and less than zero if it sorts less than the parameter.
    abstract int compareTo(ListItem listItem);

}
