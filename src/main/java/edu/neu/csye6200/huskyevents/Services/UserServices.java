package edu.neu.csye6200.huskyevents.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Repositories.UserRepository;


public class UserServices {

    // lazy singleton
    private static UserServices userServices;     
    
    private UserServices() {         
    
    }     
    
    public static synchronized UserServices getInstance() {         
        if (userServices == null) {             
        userServices = new UserServices();         
        }         
        return userServices;    
    }

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        User userSaved = userRepository.save(user);
        return userSaved;
     
    }
    
    public List<User> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        List<User> users = new ArrayList<>();
        allUsers.forEach(users::add);
        return users;
    }

    public  User findUser(String userID) { 
        User user = userRepository.findById(userID).get();
        return user;
    }

    public User updateUser(String userID, User user) {
        user.setId(userID);
        User userUpdated = userRepository.save(user);
        return userUpdated;
    }

    public String deleteUser(String userID) {
        userRepository.deleteById(userID);
        if(userRepository.existsById(userID)){
            return "User not deleted";
        }
        return "User deleted";
    }
}
