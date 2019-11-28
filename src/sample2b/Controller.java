package sample2b;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    @FXML
    LineChart<Integer, Integer> chart;

    @FXML
    void initialize() throws IOException {
        ObservableList<XYChart.Series<Integer, Integer>> dataList = FXCollections.observableArrayList();
        BufferedReader bf = new BufferedReader(new FileReader(new File("temp2.csv")));
        String [] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        String line;
        int temp = 0;
        LineChart.Series<Integer, Integer> series = null;
        while ((line = bf.readLine()) != null) {
            int k = Integer.parseInt(line.substring(3, 5));
            if (k != temp) {
                if(temp!=0) dataList.add(series);
                series = new LineChart.Series<>();
                series.setName(months[temp]);
                temp=k;
            }

            series.getData().add(new XYChart.Data<>(Integer.parseInt(line.substring(0, 2)), Integer.parseInt(line.substring(11))));
        }
       dataList.add(series);
        chart.setData(dataList);
    }
}