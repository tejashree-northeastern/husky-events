package edu.neu.csye6200.huskyevents.Entities;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
 
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 
@Data
@Document(collection = "users")
public class User extends Person{
 
    @NotNull
    String password;
 
    @NotNull
    String phone;
 
    @NotNull
    String role;
 
    String profileImg;
 
    List<String> registeredEvents = new ArrayList<>();
 
    List<String> yourEvents = new ArrayList<>();
}
 