package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class traverseCSV {
    private Map<String, Integer> data;
    private String file;

    public traverseCSV(String f){
        file = f;
        data = new TreeMap<>();
    }

    public Map<String, Integer> readCSV() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String record;

        while((record = br.readLine()) != null){
            String[] c = record.split(",");
            String warningType = c[5];

            if(data.containsKey(warningType)){
                int temp = data.get(warningType);
                data.put(warningType, temp + 1);
            }

            else{
                data.put(warningType, 1);
            }
        }

        return data;
    }

    public Map<String, Integer> getWarnings(){
        return data;
    }
}
