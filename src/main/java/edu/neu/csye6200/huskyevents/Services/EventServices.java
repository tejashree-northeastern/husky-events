package edu.neu.csye6200.huskyevents.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.neu.csye6200.huskyevents.Entities.Event;
import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Repositories.EventRepository;
import edu.neu.csye6200.huskyevents.Repositories.UserRepository;


/**
 * EventServices
 */
public class EventServices {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    // eager singleton
    private static final EventServices eventServices = new EventServices();

    private EventServices() {
    }

    public static EventServices getInstance() {
        return eventServices;
    }

    public Event createEvent(Event event) {
        if (userRepository.findById(event.getOrganizer()).isPresent()) {
            User user = userRepository.findById(event.getOrganizer()).get();
            user.getYourEvents()
                    .add(event.get_id());
            userRepository.save(user);
        }
        return eventRepository.save(event);
    }

    public Event findEvent(String eventID) {
        if (eventRepository.findById(eventID).isPresent()) {
            return eventRepository.findById(eventID).get();
        }
        return null;
    }

    public List<Event> getAllEvents() {
        Iterable<Event> allEvents = eventRepository.findAll();
        List<Event> events = new ArrayList<>();
        allEvents.forEach(events::add);
        return events;
    }

    public Event updateEvent(String eventID, Event event) {
        event.set_id(eventID);
        return eventRepository.save(event);
    }

    public List<String> getRegisteredUserNames(String _id) {

        if(eventRepository.findById(_id).isEmpty()){
            return null;
        }
        Event event = eventRepository.findById(_id).get();
        List<String> registeredUserNames = new ArrayList<>();
        event.getAttendees().forEach(attendee -> {
            User user = userRepository.findById(attendee).get();
            registeredUserNames.add(user.getFirstName() + " " + user.getLastName());
        });
        return registeredUserNames;
    }

    public String deleteEvent(String eventID) {
        eventRepository.deleteById(eventID);

        if (eventRepository.existsById(eventID)) {
            return "Event not deleted";
        }
        return "Event deleted";
    }
}
