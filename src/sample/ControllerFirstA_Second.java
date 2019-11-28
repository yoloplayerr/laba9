package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerFirstA_Second {
    @FXML
    private TableView<Vozduh> someTable;
    @FXML
    private TableColumn<Vozduh, String> dateId;
    @FXML
    private TableColumn<Vozduh, String> column;
    @FXML
    private TableColumn<Vozduh, String> tempId;

    @FXML
    void initialize() {
        ReadingData r=new ReadingData();
        // устанавливаем тип и значение которое должно хранится в колонке

        dateId.setCellValueFactory(new PropertyValueFactory<Vozduh,String>("temp"));
        tempId.setCellValueFactory(new PropertyValueFactory<Vozduh, String>("date"));

        someTable.setItems(r.getData());
    }

}
