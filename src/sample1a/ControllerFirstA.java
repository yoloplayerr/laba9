package sample1a;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.ReadingData;
import sample.Vozduh;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerFirstA {
    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<Vozduh> table;
    @FXML
    private URL location;

    @FXML
    private TableColumn<Vozduh, String> date;

    @FXML
    private TableColumn<Vozduh, String> temp;

    @FXML
    void initialize() {
        ReadingData r=new ReadingData();
        // устанавливаем тип и значение которое должно хранится в колонке
        date.setCellValueFactory(new PropertyValueFactory<Vozduh,String>("temp"));
        temp.setCellValueFactory(new PropertyValueFactory<Vozduh, String>("date"));

        table.setItems(r.getData());
    }
}
