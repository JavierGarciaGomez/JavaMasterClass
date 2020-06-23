package S09InnerAbstractClassInterfacesL122_134.L131_134Challenge;

public class Node extends ListItem {

    // Constructor
    public Node(Object value) {
        super(value);
    }

    // Methods implementation
    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        rightLink=item;
        return rightLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        leftLink=item;
        return leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if(item!=null){
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else  {
            return -1;
        }
    }
}
