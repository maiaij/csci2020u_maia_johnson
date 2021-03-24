package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataSource {
    
    public static ObservableList<StudentRecord> getAllMarks(File f) throws IOException {
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
        String line;
        String[] record;

        while((line = br.readLine()) != null){
            record = line.split(",");
            marks.add(new StudentRecord(record[0], record[1], record[2], record[3]));
        }

        return marks;
    }
}