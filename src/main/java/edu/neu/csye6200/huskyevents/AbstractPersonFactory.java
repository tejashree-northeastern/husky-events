package edu.neu.csye6200.huskyevents;
import edu.neu.csye6200.huskyevents.Entities.Person;

public abstract class AbstractPersonFactory {
    public abstract Person createPerson(String [] values);
}
