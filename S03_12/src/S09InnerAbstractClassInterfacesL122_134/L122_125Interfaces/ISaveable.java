package S09InnerAbstractClassInterfacesL122_134.L122_125Interfaces;

import java.util.List;

public interface ISaveable {

    //The interface will just specify two methods, one to return an ArrayList of values to be saved
    public List<String> write();

    // and the other to populate the object's fields from an ArrayList (parameter).
    public void read(List<String> savedValues);

}
