package edu.neu.csye6200.huskyevents.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.neu.csye6200.huskyevents.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    
}

