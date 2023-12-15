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
        try {
            if (userRepository.findById(event.getOrganizer()).isPresent()) {
                User user = userRepository.findById(event.getOrganizer()).get();
                user.getYourEvents()
                        .add(event.get_id());
                userRepository.save(user);
            }
            return eventRepository.save(event);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating event: " + e.getMessage());
        }

    }

    public Event findEvent(String eventID) {
        try {
            if (eventRepository.findById(eventID).isPresent()) {
                return eventRepository.findById(eventID).get();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding event: " + e.getMessage());
        }

    }

    public List<Event> getAllEvents() {
        try {
            Iterable<Event> allEvents = eventRepository.findAll();
            List<Event> events = new ArrayList<>();
            allEvents.forEach(events::add);
            return events;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all events: " + e.getMessage());
        }
    }

    public Event updateEvent(String eventID, Event event) {
        try {
            event.set_id(eventID);
            return eventRepository.save(event);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating event: " + e.getMessage());
        }

    }

    public List<String> getRegisteredUserNames(String _id) {
        try {
            if (eventRepository.findById(_id).isEmpty()) {
                return null;
            }
            Event event = eventRepository.findById(_id).get();
            List<String> registeredUserNames = new ArrayList<>();
            event.getAttendees().forEach(attendee -> {
                User user = userRepository.findById(attendee).get();
                registeredUserNames.add(user.getFirstName() + " " + user.getLastName());
            });
            return registeredUserNames;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting registered user names: " + e.getMessage());
        }

    }

    public String deleteEvent(String eventID) {
        try {
            eventRepository.deleteById(eventID);

            if (eventRepository.existsById(eventID)) {
                return "Event not deleted";
            }
            return "Event deleted";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting event: " + e.getMessage());
        }

    }
}
