package edu.neu.csye6200.huskyevents.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Services.UserServices;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserServices userServices;

    // Create
    @PostMapping("/create")
    public ResponseEntity<User> Createuser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userServices.createUser(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> GetAllusers() {
        try {
            return new ResponseEntity<>(userServices.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get User
    @GetMapping("/get/{userID}")
    public ResponseEntity<User> Finduser(@PathVariable String userID) {
        try {
            return new ResponseEntity<>(userServices.findUser(userID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update
    @PutMapping("/edit/{userID}")
    public ResponseEntity<User> Updateuser(@PathVariable String userID, @RequestBody User user) {
        try {
            return new ResponseEntity<>(userServices.updateUser(userID, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete
    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<String> Deleteuser(@PathVariable String userID) {
        try {
            return new ResponseEntity<>(userServices.deleteUser(userID), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
