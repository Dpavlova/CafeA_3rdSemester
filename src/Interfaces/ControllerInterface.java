package Interfaces;

import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by Donika on 4/19/2016.
 */
public interface ControllerInterface<T> {

    int SaveButtonActionOnUpdate(LocalDate date, String time, String nrPeopleTextField,
                                 String phoneTextField, String commentTextField, String
                                         nameTextField, String tableNoTextField);
    int SaveButtonAction(LocalDate date, String nrPeopleTextField, String nameTextField, String phoneTextField,
                         String commentTextField,String time, String tableNoTextField);
    int DeleteButtonAction( String phoneTextField);
    ObservableList<T> viewButtonAction(String date);
}
