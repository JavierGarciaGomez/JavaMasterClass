package S12CollectionsL152_178.try1_05_30.L162SetsHashSets;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Dog){
            String objName=((Dog) o).getName();
            return this.name.equals(objName);
        }
        return false;

    }
}
