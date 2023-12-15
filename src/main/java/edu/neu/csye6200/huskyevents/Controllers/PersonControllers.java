package edu.neu.csye6200.huskyevents.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.huskyevents.PersonItemFactory;
import edu.neu.csye6200.huskyevents.Entities.Person;
import edu.neu.csye6200.huskyevents.utilities.fileUtils;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class PersonControllers {

    @GetMapping("/persons")
    public String persons(Model model) {

        String filePath = "src/main/java/edu/neu/csye6200/huskyevents/Data/teammates.txt";

        List<String> csvContent = fileUtils.readFile(filePath);
        List<Person> persons = new ArrayList<>();

        for (String row : csvContent) {
            String[] values = row.split(",");
            System.out.println("values"+values);
            persons.add(PersonItemFactory.getInstance().createPerson(values));
        }


        model.addAttribute("persons", persons);

        return "persons";
    }
    
}
