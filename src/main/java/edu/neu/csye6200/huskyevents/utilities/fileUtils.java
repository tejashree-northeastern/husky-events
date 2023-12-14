package edu.neu.csye6200.huskyevents.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileUtils {

        public static List<String> readFile(String filePath) {
    	List<String> csvStrings = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            // Read lines from the file until the end of the file is reached
            while ((line = bufferedReader.readLine()) != null) {
                csvStrings.add(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
		return csvStrings;
         
    }
    
    public static void writeFile(String filename, List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
