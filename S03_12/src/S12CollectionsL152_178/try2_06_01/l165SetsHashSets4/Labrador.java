package S12CollectionsL152_178.try2_06_01.l165SetsHashSets4;

public class Labrador extends Dog {
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
