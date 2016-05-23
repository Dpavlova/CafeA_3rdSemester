package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Created by Donika on 5/10/2016.
 */
public class ButtonsForMainScreen extends GridPane{

    BookingsForm bookingsForm;
    private GridPane grid;

    final Text textUnderButtons = new Text();

    private Button SaveBtn;
    private Button Bookings;
    private Button EditBtn;
    private Button ClearBtn;
    private Button DeleteBtn;


    public ButtonsForMainScreen(){

        SaveBtn = new Button("Save");
        Bookings = new Button("Bookings");
        ClearBtn = new Button("Clear");
        DeleteBtn = new Button("Delete");
        EditBtn = new Button("Edit");

        // setId - links to style in css style sheet..
        SaveBtn.setId("SaveBtnStyle");
        Bookings.setId("StatisticsBtnStyle");
        EditBtn.setId("EditBtnStyle");

        //add first row buttons to an hbox
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(ClearBtn, EditBtn, DeleteBtn);

        // bookings button in a hBox
        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(Bookings);

        // save button in a hBox
        HBox hBox3 = new HBox(11);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(SaveBtn);

        grid.add(hBox, 0, 0);
        grid.add(hBox2, 0, 1);
        grid.add(hBox3, 0, 2);
//        grid.add(hBox, 1, 8);
//        grid.add(hBox2, 1, 10);
//        grid.add(hBox3, 1, 10);


        Bookings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                String date = "";
//                if (dateTextField.getValue() != null)
//                    date = dateTextField.getValue().toString();
//                textUnderButtons.setText("All reservations for date: " + dateTextField.getValue().toString());
//
//                table.getItems().clear();
//                table.getItems().addAll(controller.viewButtonAction(date));
            }
        });

        EditBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                ReservationInfo cus = table.getSelectionModel().getSelectedItem();
//                nameTextField.setText(cus.getName());
//                nrPeopleTextField.setText(Integer.toString(cus.getPeople()));
//                phoneTextField.setText(cus.getPhone());
//                commentTextField.setText(cus.getComment());
//                tableNoTexhtField.setText(Integer.toString(cus.getTableNo()));
//                timeComboBox.setValue(cus.getTime());
                SaveBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
//                        if(controller.SaveButtonActionOnUpdate(dateTextField.getValue(), timeComboBox.getValue().toString(),
//                                nrPeopleTextField.getText(), phoneTextField.getText(), commentTextField.getText(),
//                                nameTextField.getText(), tableNoTexhtField.getText()) >0)
//                        {
//                            dateTextField.getEditor().clear();
//                            bookingsForm.clearAllFields();
//                            table.getItems().clear();
//                            table.getItems().addAll(controller.viewButtonAction(""));
//
//                        }
//                    }
//                });
                    }
                });
            }});

        DeleteBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                ObservableList selectedItems = table.getSelectionModel().getSelectedItems();
//
//                if(selectedItems.size() !=1)
//                {
//                    JOptionPane.showMessageDialog(null, "Select row you want to delete");
//                }
//                else
//                {
//                    ReservationInfo cus = table.getSelectionModel().getSelectedItem();
//                    int u = controller.DeleteButtonAction(cus.getPhone());
//                    if(u>0)
//                    {
//                        table.getItems().clear();
//                        bookingsForm.clearAllFields();
//                        table.getItems().addAll(controller.viewButtonAction(""));
//                    }
//                }
            }
        });


        SaveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                if(controller.SaveButtonAction(dateTextField.getValue(), nrPeopleTextField.getText(),
//                        nameTextField.getText(),phoneTextField.getText(),commentTextField.getText(),
//                        timeComboBox.getValue().toString(), tableNoTexhtField.getText())>0) {
//                    table.getItems().clear();
//                    bookingsForm.clearAllFields();
//                    table.getItems().addAll(controller.viewButtonAction(""));
//                }
            }
        });


        ClearBtn.setOnAction(clearBtnEvent -> {
//            dateTextField.getEditor().clear();
//            //timeComboBox.getItems().clear();
//            timeComboBox.setValue("Select");
//            nrPeopleTextField.clear();
//            nameTextField.clear();
//            phoneTextField.clear();
//            commentTextField.clear();
//            tableNoTexhtField.setText("0");

        });

    }
}


