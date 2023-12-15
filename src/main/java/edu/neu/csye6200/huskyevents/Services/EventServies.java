package edu.neu.csye6200.huskyevents.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.neu.csye6200.huskyevents.Entities.Event;
import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Repositories.EventRepository;
import edu.neu.csye6200.huskyevents.Repositories.UserRepository;

public class EventServies {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    // eager singleton
    private static final EventServies eventServices = new EventServies();

    private EventServies() {
    }

    public static EventServies getInstance() {
        return eventServices;
    }

    public Event createEvent(Event event) {
        User user = userRepository.findById(event.getOrganizer()).get();
        Event eventSaved = eventRepository.save(event);
        user.getYourEvents()
                .add(eventSaved.get_id());
        userRepository.save(user);
        return eventSaved;
    }

    public Event findEvent(String eventID) {
        Event event = eventRepository.findById(eventID).get();
        return event;
    }

    public List<Event> getAllEvents() {
        Iterable<Event> allEvents = eventRepository.findAll();
        List<Event> events = new ArrayList<>();
        allEvents.forEach(events::add);
        return events;
    }

    public Event updateEvent(String eventID, Event event) {
        event.set_id(eventID);
        Event eventUpdated = eventRepository.save(event);
        return eventUpdated;
    }
}
