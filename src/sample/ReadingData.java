package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReadingData {
    public static ArrayList<String> date=new ArrayList<>();
    public static ArrayList<String> temp=new ArrayList<>();

    public static ObservableList<Vozduh> getData() {
        String csvFile = "temp2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        ObservableList<Vozduh> vz= FXCollections.observableArrayList();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                date.add(country[0]);
                temp.add(country[1]);
                vz.add(new Vozduh(country[0],country[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return vz;
    }
    public static ArrayList<Vozduh> secondMethod(){
        ArrayList<Vozduh> oList=new ArrayList<>();
        Vozduh temp;
        String csvFile = "temp2.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                if(Integer.valueOf(country[0].substring(3,5))==4){
                    temp=new Vozduh(country[1],country[0]);
                 oList.add(temp);
                }else{
                    continue;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return oList;
    }
}

