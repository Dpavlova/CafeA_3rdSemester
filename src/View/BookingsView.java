package View;

import Controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.applet.Applet;
import java.time.LocalDate;

/**
 * Created by Donika on 4/19/2016.
 */
public class BookingsView<T> extends TableView<T>{

    private Controller<T> controller;
//    public static void main(String[] args) {
//        launch(args);
//    }

   // TableColumn dateCol;
   // TableColumn timeCol;
//    TableColumn paxCol;
//    TableColumn nameCol;
//    TableColumn phoneCol;
//    TableColumn commentCol;
//    TableColumn tableNoCol;

    HBox hBox = new HBox();

    //@Override
    //public void start(stage stage) {
    public void openView(Stage stage){
    Scene scene = new Scene(new Group());
        stage.setWidth(400);
        stage.setHeight(500);

        scene.getStylesheets().add("styleForTable.css");



    //javafx.scene.control.TableView<T> table = new javafx.scene.control.TableView<>();
    BookingsView<T> tableView = new BookingsView<>();


    TableColumn dateCol = new TableColumn("date");
    dateCol.setPrefWidth(70);
    dateCol.setCellValueFactory(new PropertyValueFactory<T, LocalDate>("date"));
    TableColumn timeCol = new TableColumn("time");
    timeCol.setPrefWidth(70);
    timeCol.setCellValueFactory(new PropertyValueFactory<T, String>("time"));
    TableColumn paxCol = new TableColumn("ppl");
    paxCol.setPrefWidth(25);
    paxCol.setCellValueFactory(new PropertyValueFactory<T, Integer>("people"));
    TableColumn nameCol = new TableColumn("name");
    nameCol.setPrefWidth(70);
    nameCol.setCellValueFactory(new PropertyValueFactory<T, String>("name"));
    TableColumn phoneCol = new TableColumn("phone");
    phoneCol.setPrefWidth(65);
    phoneCol.setCellValueFactory(new PropertyValueFactory<T, String>("phone"));
    TableColumn commentCol = new TableColumn("comment");
    commentCol.setPrefWidth(50);
    commentCol.setCellValueFactory(new PropertyValueFactory<T, String>("comment"));
    TableColumn tableNoCol = new TableColumn("table");
    tableNoCol.setPrefWidth(25);
    tableNoCol.setCellValueFactory(new PropertyValueFactory<T, Integer>("tableNo"));

    //table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().addAll(dateCol, timeCol, paxCol, nameCol, phoneCol, commentCol, tableNoCol);

        tableView.getItems().addAll(controller.viewButtonAction(""));

        hBox.getChildren().add(tableView);
    }
}
