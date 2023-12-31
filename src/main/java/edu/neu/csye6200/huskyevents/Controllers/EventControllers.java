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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.csye6200.huskyevents.Entities.Event;
import edu.neu.csye6200.huskyevents.Services.EventServices;

@RestController
@CrossOrigin
@RequestMapping("/event")
public class EventControllers {

    @Autowired
    EventServices eventServices;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Event> CreateEvent(@RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventServices.createEvent(event), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getevent")
    public ResponseEntity<Event> FindEvent(@RequestParam(name = "_id") String _id) {
        try {
            return new ResponseEntity<>(eventServices.findEvent(_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{eventID}")
    public ResponseEntity<Event> UpdateEvent(@PathVariable String eventID, @RequestBody Event event) {
        try {
            return new ResponseEntity<>(eventServices.updateEvent(eventID, event), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> GetAllEvents() {
        try {
            return new ResponseEntity<>(eventServices.getAllEvents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> GetAllEvents(@RequestParam(name = "_id") String _id) {
        try {
            return new ResponseEntity<>(eventServices.deleteEvent(_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getregisteredusernames")
    public ResponseEntity<List<String>> GetRegisteredUserNames(@RequestParam(name = "eventID") String _id) {
        try {
            return new ResponseEntity<>(eventServices.getRegisteredUserNames(_id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
