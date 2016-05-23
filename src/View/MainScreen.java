package View;

import Controller.Controller;
import Model.Bookings;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * Created by Donika on 4/19/2016.
 */
public class MainScreen {

    Controller controller;
    TableView<Bookings> table;
    ButtonsForMainScreen buttons;


    Stage stage;
    Scene scene;

    Image img;
    ImageView imgView;

    //StackPane root;
    BorderPane pane;
    GridPane rightSide;
    HBox leftSide;
    //HBox rightSide;
    BookingsForm bookingsForm;


    //HBox hBox = new HBox();

    public MainScreen() throws Exception {

        controller = new Controller(this);

        //root = new StackPane();
        stage = new Stage();
        pane = new BorderPane(); //main frame
        rightSide = new GridPane();  //Right side of the screen
        //rightSide = new HBox();
        leftSide = new HBox();   //Left side of the screen

        table = new TableView<>();  //creating tableView for bookings
        table.setMinSize(450, 650);
        table.setMaxSize(450, 650);
        //bookingsForm = new BookingsForm();  //creating the bookings form, right side.
        //buttons = new ButtonsForMainScreen();

    /**setting left and right side of the pane*/
        //rightSide.getChildren().addAll(bookingsForm);

        leftSide.getChildren().addAll(table);

        //pane.setLeft(table);
        pane.setLeft(leftSide);

        pane.setRight(rightSide);
        //pane.setRight(bookingsForm);
    /**setting left and right side of the pane*/

    /**setting the stage*/
        scene = new Scene(pane, 900, 700);
        scene.getStylesheets().
                add("View/style.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setTitle("Cafe A");
    /**setting the stage*/


    /**adding the logo to the screen*/
        img = new Image("View/images/logo.png");
        imgView = new ImageView();
        imgView.setImage(img);
        //rightSide.getChildren().addAll(imgView);
        rightSide.add(imgView, 0, 0);
        //rightSide.getChildren().addAll(bookingsForm);
        //rightSide.add(bookingsForm, 1, 0);
        //rightSide.add(buttons, 2, 1);

        //pane.setTop(imgView);
    /**adding the logo to the screen*/

//        bookingsView.setMaxSize(400, 500);
//        bookingsView.setMinSize(200, 400);
//        leftSide.setMinSize(200, 400);
//        leftSide.setMaxSize(400, 500);
//        leftSide.setAlignment(Pos.CENTER_LEFT);
        //pane.getChildren().add(table);
        //pane.setRight(bookingsForm);
        //pane.setLeft(bookingsView);



        //scene.getStylesheets().add("styleForTable.css");

        //TableView<Bookings> table = new TableView<>();
       // BookingsView<T> tableView = new BookingsView<>();

    /**creating the tableView*/
    //date column
        TableColumn dateCol = new TableColumn("date");
        dateCol.setPrefWidth(90);
        //dateCol.prefWidthProperty().bind(table.widthProperty().multiply(0.25));
        dateCol.setResizable(false);
        dateCol.setCellValueFactory(new PropertyValueFactory<Bookings, LocalDate>("date"));
    //time column
        TableColumn timeCol = new TableColumn("time");
        timeCol.setPrefWidth(50);
        timeCol.setResizable(false);
        timeCol.setCellValueFactory(new PropertyValueFactory<Bookings, String>("time"));
    //number of people column
        TableColumn paxCol = new TableColumn("ppl");
        paxCol.setPrefWidth(30);
        //paxCol.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
        paxCol.setResizable(false);
        paxCol.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("people"));
    //name column
        TableColumn nameCol = new TableColumn("name");
        nameCol.setPrefWidth(50);
        nameCol.setCellValueFactory(new PropertyValueFactory<Bookings, String>("name"));
    //phone number column
        TableColumn phoneCol = new TableColumn("phone");
        phoneCol.setPrefWidth(90);
        phoneCol.setResizable(false);
        //phoneCol.prefWidthProperty().bind(table.widthProperty().multiply(0.6));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Bookings, String>("phone"));
    //comment column
        TableColumn commentCol = new TableColumn("comment");
        commentCol.setPrefWidth(100);
        commentCol.setResizable(false);
        commentCol.setCellValueFactory(new PropertyValueFactory<Bookings, String>("comment"));
    //table number column
        TableColumn tableNoCol = new TableColumn("table");
        tableNoCol.setPrefWidth(50);
        tableNoCol.setResizable(false);
        tableNoCol.setCellValueFactory(new PropertyValueFactory<Bookings, Integer>("tableNo"));


        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(dateCol, timeCol, paxCol, nameCol, phoneCol, commentCol, tableNoCol);

        table.getItems().addAll(controller.viewButtonAction(""));
    /**creating the tableView*/

        //hBox.getChildren().addAll(table);
        //rightSide.add(bookingsView,3,3);


//        rightSide.getChildren().addAll(bookingsForm);
//        rightSide.setAlignment(Pos.TOP_CENTER);
//        rightSide.setHgap(9);
//        rightSide.setVgap(9);
//        rightSide.add(imgView, 0, 0);
        //rightSide.add(bookingsForm, 2, 2);

        //rightSide.setColumnSpan(imgView, 2);



    }
}
