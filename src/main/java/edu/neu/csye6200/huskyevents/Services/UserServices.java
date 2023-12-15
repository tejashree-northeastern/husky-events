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
        try {
            User userSaved = userRepository.save(user);
            return userSaved;
        } catch (Exception e) {
            e.printStackTrace(); 
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        try {
            Iterable<User> allUsers = userRepository.findAll();
            List<User> users = new ArrayList<>();
            allUsers.forEach(users::add);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all users: " + e.getMessage());
        }
    }

    public User findUser(String userID) {
        try {
            User user = userRepository.findById(userID).get();
            return user;
            } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding user: " + e.getMessage());
        }
    }

    public User updateUser(String userID, User user) {
        try {
            User userUpdated = userRepository.save(user);
            return userUpdated;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }

    public String deleteUser(String userID) {
        try {
            userRepository.deleteById(userID);
            if(userRepository.existsById(userID)){
                return "User not deleted";
            }
            return "User deleted";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
}
