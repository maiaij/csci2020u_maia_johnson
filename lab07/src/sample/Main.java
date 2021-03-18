package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 7 - Maia Johnson");
        primaryStage.setScene(new Scene(root, 800, 400));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        traverseCSV csvData = new traverseCSV("C:/Users/murcr/csci2020u/lab07/src/sample/weatherwarnings-2015.csv");
        csvData.readCSV();
        launch(args);
    }
}
