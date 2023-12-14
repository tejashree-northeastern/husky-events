package edu.neu.csye6200.huskyevents.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Repositories.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        User userSaved = userRepository.save(user);
        return userSaved;
    }
}
