package edu.neu.csye6200.huskyevents;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.neu.csye6200.huskyevents.Services.EventServies;

@Configuration
public class AppConfig {
       
    @Bean    
    public EventServies eventServices() {         
        return EventServies.getInstance();     
    }     

}