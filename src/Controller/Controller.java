package Controller;

import Interfaces.ControllerInterface;
import Model.Database;
import View.MainScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by Donika on 4/19/2016.
 */
public class Controller<T> implements ControllerInterface<T> {

    private MainScreen mainScreen;
    private Database database;

    public Controller (MainScreen mainScreen) throws Exception {
        this.mainScreen = mainScreen;
        database = new Database(this);
    }

    public int SaveButtonActionOnUpdate(LocalDate date, String time, String nrPeopleTextField,
                                        String phoneTextField, String commentTextField, String
                                                nameTextField, String tableNoTextField) {

        if (date != null  && Integer.parseInt(nrPeopleTextField) >0 && nameTextField.length()>0 &&
                phoneTextField.length()>0 && time.length()>0) {
            return database.updateToDB(Timestamp.valueOf(date.atStartOfDay()),
                    time, Integer.parseInt(nrPeopleTextField), phoneTextField,
                    commentTextField, Integer.parseInt(tableNoTextField));
        }
        else {
            System.out.println("error.all fields must be filled");
            return 0;
        }

    }

    public int SaveButtonAction(LocalDate date, String nrPeopleTextField, String nameTextField, String phoneTextField,
                                String commentTextField,String time, String tableNoTextField) {

        if (date != null  && nrPeopleTextField.length()>0 && nameTextField.length()>0 && phoneTextField.length()>0 && time.length()>0) {
            return database.writeToDB(Timestamp.valueOf(date.atStartOfDay()),
                    Integer.parseInt(nrPeopleTextField), nameTextField, phoneTextField, commentTextField,time,
                    Integer.parseInt(tableNoTextField));
        }
        else {
            System.out.println("error.all fields must be filled");
            return 0;
        }
    }

    public int DeleteButtonAction( String phoneTextField) {

        if ( phoneTextField.length()>0 ) {
            return database.deleteToDB(phoneTextField);
        }
        else {
            System.out.println("cPhone fields must be filled");
            return 0;
        }
    }

    public ObservableList<T> viewButtonAction(String date)
    {
        return FXCollections.observableArrayList(database.getBookings(date));
    }
}
