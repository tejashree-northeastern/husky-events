package edu.neu.csye6200.huskyevents.Entities;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "events")
public class Event {

    @Id
    String id;

    String name;
    String description;
    String userAdmin;
    Date scheduleTime;
    int duration;
    String location;
    List<String> tags;
    String image;
    int __v;
    List<String> attendees;
    Date endTime;
    Date startTime;
    String locationUrl;
    String organizer;
}
