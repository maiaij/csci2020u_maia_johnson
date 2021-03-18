package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.shape.ArcType;
import static javafx.scene.text.Font.font;

public class Controller {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private Map<String, Integer> csvData = new TreeMap<>();

    private Color[] pieColours = {
            Color.web("3f5a36"), Color.web("589d68"), Color.web("ace6ac"),
            Color.web("ffc40b")
    };

    @FXML
    public void initialize() throws IOException {
        gc = canvas.getGraphicsContext2D();

        traverseCSV sourceFile = new traverseCSV("src/sample/weatherwarnings-2015.csv");
        csvData = sourceFile.readCSV();

        drawPieChart(pieColours, sourceFile.getWarnings());
        drawLegend(pieColours, csvData);
    }

    private void drawPieChart(Color[] colour, Map<String,Integer> warnings){
        double startAngle = 0;
        double total = 0;
        double sweepAngle;

        Integer[] values = warnings.values().toArray(new Integer[0]);

        for(int i = 0; i < values.length; i++){
            total += values[i];
        }

        for(int k = 0; k < values.length; k++){
            sweepAngle = (values[k]/total) * 360;
            gc.setFill(colour[k]);
            gc.fillArc(375,175, 350, 350, startAngle, sweepAngle, ArcType.ROUND);
            gc.strokeArc(375,175, 350, 350, startAngle, sweepAngle, ArcType.ROUND);
            startAngle += sweepAngle;
        }
    }

    private void drawLegend(Color[] c, Map<String, Integer> d) {
        String[] keys = d.keySet().toArray(new String[0]);
        int x1 = 50, y1 = 220, w = 50, h = 50;
        String key;

        for(int i=0; i < d.keySet().size(); i++){
            key = keys[i];
            gc.setFill(c[i]);
            gc.fillRect(x1,y1,w,h);
            gc.setFill(Color.BLACK);
            gc.setFont(font("Times New Roman", 14));
            gc.fillText(key, (x1 + 60), (y1 + 30));
            y1 += 60;
        }
    }
}
