import java.io.*;
import java.util.*;

public class Person implements Serializable {
    protected String name;
    protected String ID;

    public Person(String name, String email) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }
}



