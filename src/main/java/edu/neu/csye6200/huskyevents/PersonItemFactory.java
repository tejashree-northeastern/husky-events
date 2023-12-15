package edu.neu.csye6200.huskyevents;

import edu.neu.csye6200.huskyevents.Entities.Person;

public class PersonItemFactory extends AbstractPersonFactory

{
    private static final PersonItemFactory personItemFactoryInstance = new PersonItemFactory();

    private PersonItemFactory() {
    }

    @Override
    public Person createPerson(String[] values) {
        try {
            if (values.length >= 4) {
                return new Person(values[0], values[1], values[2], values[3]);
            } else {
                throw new IllegalArgumentException("Insufficient values to create a person");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating person: " + e.getMessage());
        }
    }

    public static PersonItemFactory getInstance() {
        return personItemFactoryInstance;
    }

}
