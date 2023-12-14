package edu.neu.csye6200.huskyevents.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.huskyevents.Entities.Event;
import edu.neu.csye6200.huskyevents.Services.EventServies;

@RestController
@RequestMapping("/event")
public class EventControllers {

    @Autowired
    EventServies eventServices;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Event> CreateEvent(@RequestBody Event event){
        return new ResponseEntity<>(eventServices.createEvent(event), HttpStatus.OK);
    }
    
    @GetMapping("/findEvent/{eventID}")
    public ResponseEntity<Event> FindEvent(@PathVariable String eventID){
        return new ResponseEntity<>(eventServices.findEvent(eventID), HttpStatus.OK);
    }

    @PostMapping("/updateEvent/{eventID}")
    public ResponseEntity<Event> UpdateEvent(@PathVariable String eventID, @RequestBody Event event){
        return new ResponseEntity<>(eventServices.updateEvent(eventID, event), HttpStatus.OK);
    }   

} 






