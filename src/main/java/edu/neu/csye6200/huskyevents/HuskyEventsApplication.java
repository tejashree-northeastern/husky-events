package edu.neu.csye6200.huskyevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HuskyEventsApplication {

	public static void main(String[] args) {
		try {
            SpringApplication.run(HuskyEventsApplication.class, args);
            ReadCsv readCsv = new ReadCsv();
            readCsv.demo();
        } catch (Exception e) {
            e.printStackTrace(); 
            System.exit(1); 
        }
	}

}
