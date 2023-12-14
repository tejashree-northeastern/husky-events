package edu.neu.csye6200.huskyevents.Entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "events")
public class Event {

    @Id
    String id;

    @NonNull
    String name;

    @NonNull
    String description;

    @NonNull
    String organizer;

    @NonNull
    String startTime;

    @NonNull
    String endTime;

    @NonNull
    String location;

    String locationUrl;

    @NonNull
    String image;
    
    List<String> tags;
    
    List<String> attendees; 
}
