package edu.neu.csye6200.huskyevents.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.csye6200.huskyevents.Entities.Event;
import edu.neu.csye6200.huskyevents.Entities.User;
import edu.neu.csye6200.huskyevents.Repositories.EventRepository;
import edu.neu.csye6200.huskyevents.Repositories.UserRepository;

@Service
public class EventServies {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

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
}
