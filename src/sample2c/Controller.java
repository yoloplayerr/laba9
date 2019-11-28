package sample2c;

import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.io.*;

public class Controller {
    @FXML
    BarChart<String, Double> chart;
    @FXML
    void initialize() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(new File("temp2.csv")));
        String [] months = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        int i = 0;
        int s = 0;
        int d = 0;
        String line;
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("");
        while ((line = bf.readLine()) != null) {
            int k = Integer.parseInt(line.substring(3, 5));
            if (k != i) {
                if(i!=0) {
                    double t = (double) s/d;
                    System.out.println(t);
                    series.getData().add(new XYChart.Data<>(months[k - 1], t));
                    d = 0;
                    s = 0;
                }
                i=k;
            }
            d++;
           s+=Integer.parseInt(line.substring(11));
        }
        chart.getData().add(series);
    }
}