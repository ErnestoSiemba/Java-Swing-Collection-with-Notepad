package AdvancedConcepts;

import java.io.File;
import java.io.Serializable;

public class SerializableClass implements Serializable {
    String name;
    String email;
    String gender;
    File myFile;
    public SerializableClass() {
        name = "";
        myFile = null;
    }

}
