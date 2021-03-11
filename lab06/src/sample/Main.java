package sample;

import java.io.*;
import java.util.*;

import com.sun.javafx.charts.Legend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Main extends Application {
    final static String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3
    };


    @Override
    public void start(Stage stage) {
        stage.setTitle("Lab 06");

        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year");

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Prices");

        final BarChart<String,Number> barGraph = new BarChart<String,Number>(xAxis,yAxis);
        barGraph.setTitle("Average Housing and Commercial Prices (By Year)");

        XYChart.Series housing = new XYChart.Series();
        housing.setName("Avg Housing Price");
        for(int i = 0; i < 8; i++){
            housing.getData().add(new XYChart.Data(numbers[i], avgHousingPricesByYear[i]));
        }

        XYChart.Series commercial = new XYChart.Series();
        commercial.setName("Avg Commerical Prices");
        for(int j = 0; j < 8; j++){
            commercial.getData().add(new XYChart.Data(numbers[j], avgCommercialPricesByYear[j]));
        }

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(int k = 0; k < 5; k++){
            pieChartData.add(new PieChart.Data(ageGroups[k], purchasesByAgeGroup[k]));
        }

        final PieChart purchaseData = new PieChart(pieChartData);
        purchaseData.setTitle("Purchases by Age Groups");

        barGraph.getStylesheets().add(getClass().getResource("bar-colours.css").toExternalForm());

        Scene graphs = new Scene(new Group());
        barGraph.getData().addAll(housing, commercial);
        ((Group) graphs.getRoot()).getChildren().add(purchaseData);
        ((Group) graphs.getRoot()).getChildren().add(barGraph);
        purchaseData.setLayoutX(500);
        stage.setScene(graphs);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
