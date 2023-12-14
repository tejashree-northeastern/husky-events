package edu.neu.csye6200.huskyevents.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Person {

    @Id
    String id;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    @Indexed(unique = true)
    String email;
}
