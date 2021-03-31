package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    private GraphicsContext content;

    @FXML
    private Canvas canvas;

    private ArrayList<Float> google = new ArrayList<>();
    private ArrayList<Float> apple = new ArrayList<>();

    public void initialize() throws IOException{
        content = canvas.getGraphicsContext2D();
        google = downloadStockPrices("GOOG");
        apple = downloadStockPrices("AAPL");

        drawLinePlot(google, apple);
    }

    public ArrayList<Float> downloadStockPrices(String stockTicker) throws IOException {
        List<List<String>> data = new ArrayList<>();
        ArrayList<Float> closeCol = new ArrayList<>();

        String urlString = "https://query1.finance.yahoo.com/v7/finance/download/" + stockTicker +
                "?period1=1262322000&period2=1451538000&interval=1mo&events=history&" +
                "includeAdjustedClose=true";

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(false);
        conn.setDoInput(true);

        InputStream inData = conn.getInputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(inData, "UTF-8"));
        String line;

        while ((line = bf.readLine()) != null) {
            String[] record = line.split(",");
            data.add(Arrays.asList(record));
        }

        for(int i = 1; i < data.size(); i++){
            closeCol.add((Float.parseFloat(data.get(i).get(4))));
        }

        return closeCol;
    }

    public void drawLinePlot(ArrayList<Float> data1, ArrayList<Float> data2){
        content.setStroke(Color.BLACK);
        content.strokeLine(50,50,50, 750);
        content.strokeLine(50,750,770,750);

        //google
        content.setStroke(Color.RED);
        plotLine(data1);

        //apple
        content.setStroke(Color.BLUE);
        plotLine(data2);

    }

    public void plotLine(ArrayList<Float> closeCol){
        int xValue = 50;
        float y2;
        float y1 = 750 - closeCol.get(0);

        for(int i = 0; i < closeCol.size(); i++){
            y2 = 750 - closeCol.get(i);
            content.strokeLine(xValue, y1, xValue+10, y2);
            xValue += 10;
            y1 = 750 - closeCol.get(i);
        }
    }
}
