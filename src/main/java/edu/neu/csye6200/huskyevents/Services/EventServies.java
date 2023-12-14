package edu.neu.csye6200.huskyevents.Services;

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
                .add(eventSaved.getId());
        userRepository.save(user);
        return eventSaved;
    }

    public Event findEvent(String eventID) {
        Event event = eventRepository.findById(eventID).get();
        return event;
    }

    public Event updateEvent(String eventID, Event event) {
        event.setId(eventID);
        Event eventUpdated = eventRepository.save(event);
        return eventUpdated;
    }
}
