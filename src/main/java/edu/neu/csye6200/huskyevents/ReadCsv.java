package edu.neu.csye6200.huskyevents;
import edu.neu.csye6200.huskyevents.Entities.Person;
import edu.neu.csye6200.huskyevents.utilities.fileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {

    public void demo() {
        String filePath = "src/main/java/edu/neu/csye6200/huskyevents/Data/teammates.txt";

        // Read the CSV file into a string
        List<String> csvContent = new ArrayList<>();
        csvContent = fileUtils.readFile(filePath);
        List<Person> persons = new ArrayList<>();

        // Iterate over the rows and print the values
        for (String row : csvContent) {
            try {
                String[] values = row.split(",");
                persons.add(PersonItemFactory.getInstance().createPerson(values));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Error creating person: " + e.getMessage());
            }

        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("Husky Events:\n" + "Developed By\n");
        // Sort the persons using stream, comparable and lambda
        persons.stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");

    }

}
