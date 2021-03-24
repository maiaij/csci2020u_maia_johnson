package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

    @FXML
    private TextField studentIDTF, assignmentsTF, midtermTF, examTF;

    @FXML
    private TableView tabView;

    private ObservableList<StudentRecord> data = FXCollections.observableArrayList();
    private String currentFileName = "Untiled1";
    private File currentFile;
    private Stage mainStage = sample.Main.getStage();

    @FXML
    private void initialize() throws IOException{ }

    @FXML
    private void clearTable(){
        data.clear();
    }

    @FXML
    private void open() throws  IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        currentFile = fileChooser.showOpenDialog(mainStage);
        currentFileName = currentFile.getName();
        load();
    }

    @FXML
    private void load() throws IOException {
        data = DataSource.getAllMarks(currentFile);
        tabView.setItems(data);
    }

    @FXML
    private void save() throws IOException{
        FileWriter write = new FileWriter(currentFile);

        for(int i=0; i < data.size(); i++){
            write.append(data.get(i).getStudentID() + "," + data.get(i).getAssignments() + "," +
                            data.get(i).getMidterm() + "," + data.get(i).getExam() + "\n");
        }

        write.close();
    }

    @FXML
    private void saveAs() throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        currentFile = fileChooser.showSaveDialog(mainStage);
        currentFileName = currentFile.getName();
        save();
    }

    @FXML
    private void exit(){
        Platform.exit();
    }

    @FXML
    private void addData(){
        data.add(new StudentRecord(studentIDTF.getText(), assignmentsTF.getText(), midtermTF.getText(), examTF.getText()));
        tabView.setItems(data);
    }
}
