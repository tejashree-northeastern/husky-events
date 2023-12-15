package edu.neu.csye6200.huskyevents;

import edu.neu.csye6200.huskyevents.Entities.Person;

public class PersonItemFactory extends AbstractPersonFactory

{
    private static final PersonItemFactory personItemFactoryInstance = new PersonItemFactory();

    private PersonItemFactory() {
    }

    
    @Override
    public Person createPerson(String [] values) {
        return new Person(values[0], values[1], values[2], values[3]);
    }

    public static PersonItemFactory getInstance() {
        return personItemFactoryInstance;
    }
    
}
