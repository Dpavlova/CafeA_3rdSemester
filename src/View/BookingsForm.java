package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Timestamp;

/**
 * Created by Donika on 5/10/2016.
 */
public class BookingsForm extends GridPane{

    //ButtonsForMainScreen buttons;
    Timestamp sq = null;

    final ComboBox timeComboBox;
    final DatePicker datePicker = new DatePicker();
    final DatePicker dateTextField = new DatePicker();

    private Label dateLabel;
    private Label timeLabel;
    private Label nrPeopleLabel;
    private Label nameLabel;
    private Label phoneLabel;
    private Label commentLabel;
    private Label tableLabel;

    private Label dateStatisticsLabel;
    private Label dayStatisticsLabel;
    private Label eveningStatisticsLabel;

     private TextField timeTextField;
    private TextField nrPeopleTextField;
    private TextField nameTextField;
    private TextField phoneTextField;
    private TextField commentTextField;
    private TextField tableNoTextField;


    GridPane grid = new GridPane();
    GridPane buttonsGrid = new GridPane();
    GridPane statisticsGrid = new GridPane();

    public BookingsForm(){

        //final DatePicker datePicker = new DatePicker();
        final DatePicker dateTextField = new DatePicker();



        dateLabel = new Label("Date:");
        timeLabel = new Label("Time:");
        nrPeopleLabel = new Label("Nr. of people:");
        nameLabel = new Label("Name:");
        phoneLabel = new Label("Phone number:");
        commentLabel = new Label("Comment:");
        tableLabel = new Label("Table number:");


        nrPeopleTextField = new TextField();
        nameTextField = new TextField();
        phoneTextField = new TextField();
        commentTextField = new TextField();
        tableNoTextField = new TextField();

        ObservableList<String> timeOptions =
                FXCollections.observableArrayList(
                        "10:00", "10:15", "10:30", "10:45",
                        "11:00", "11:15", "11:30", "11:45",
                        "12:00", "12:15", "12:30", "12:45",
                        "13:00", "13:15", "13:30", "13:45",
                        "14:00", "14:15", "14:30", "14:45",
                        "15:00", "15:15", "15:30", "15:45",
                        "16:00", "16:15", "16:30", "16:45",
                        "17:00", "17:15", "17:30", "17:45",
                        "18:00", "18:15", "18:30", "18:45",
                        "19:00", "19:15", "19:30", "19:45",
                        "20:00", "20:15", "20:30", "20:45",
                        "21:00"

                );

        timeComboBox = new ComboBox(timeOptions);

    //add labels to the gridpane..
        grid.add(dateLabel,0,1);
        grid.add(timeLabel,0,2);
        grid.add(nrPeopleLabel,0,3);
        grid.add(nameLabel,0,4);
        grid.add(phoneLabel,0,5);
        grid.add(commentLabel,0,6);
        grid.add(tableLabel,0,7);

        //adding labels for statistics into the rightSide
        statisticsGrid.add(dateStatisticsLabel, 2, 9);
        statisticsGrid.add(dayStatisticsLabel, 1, 10);
        statisticsGrid.add(eveningStatisticsLabel, 1, 11);
        //adding labels for statistics into the rightSide
    //add labels to the gridpane..

    //text fields and text prompts to the rightSide
        grid.add(dateTextField, 1, 1);
        dateTextField.setPromptText("enter date");

        grid.add(timeComboBox, 1, 2);
        timeComboBox.setValue("Select");

        grid.add(nrPeopleTextField,1,3);
        nrPeopleTextField.setPromptText("enter number of guests");

        grid.add(nameTextField,1,4);
        nameTextField.setPromptText("enter name");

        grid.add(phoneTextField,1,5);
        phoneTextField.setPromptText("enter phone number");

        grid.add(commentTextField,1,6);
        commentTextField.setPromptText("enter comment (optional)");

        grid.add(tableNoTextField,1,7);
        tableNoTextField.setPromptText("enter table number (optional)");
        tableNoTextField.setText("0");
    //text fields and text prompts to the rightSide

        //buttonsGrid.getChildren().addAll(buttons);
        //buttonsGrid.add(buttons, 1, 8);

    }

    public void clearAllFields()
    {
        dateTextField.getEditor().clear();
        timeComboBox.setValue("Select");
        nrPeopleTextField.clear();
        nameTextField.clear();
        phoneTextField.clear();
        commentTextField.clear();
        tableNoTextField.setText("0");
    }
}
