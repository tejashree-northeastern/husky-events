package edu.neu.csye6200.huskyevents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.neu.csye6200.huskyevents.Services.EventServices;
import edu.neu.csye6200.huskyevents.Services.UserServices;

@Configuration
public class AppConfig {
       
    @Bean    
    public EventServices eventServies() {
        return EventServices.getInstance();
    }  
    
    @Bean    
    public UserServices userServices() {         
        return UserServices.getInstance();     
    }  

}