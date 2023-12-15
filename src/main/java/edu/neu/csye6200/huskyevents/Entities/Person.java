package edu.neu.csye6200.huskyevents.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


// Sort using comparable
@Data
public class Person implements Comparable<Person> {

    @Id
    String _id;

    String nuId;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    @Indexed(unique = true)
    String email;

    public Person() {
    }

    public Person(String nuId, String firstName, String lastName, String email) {
        this.nuId = nuId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    @Override
    public String toString() {
        return  
        "nuId=" + nuId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email;
    }

    @Override
    public int compareTo(Person o) {
        return this.nuId.compareTo(o.nuId);
    }
}
