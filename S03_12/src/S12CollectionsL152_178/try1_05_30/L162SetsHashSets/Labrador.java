package S12CollectionsL152_178.try1_05_30.L162SetsHashSets;

public class Labrador extends Dog{
    public Labrador(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(o instanceof  Labrador){
            String objName=((Labrador)o).getName();
            return this.getName().equals(objName);
        }
        return false;
    }
}
