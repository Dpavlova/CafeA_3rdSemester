package View;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Donika on 5/10/2016.
 */
public class Main extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {

            MainScreen gui = new MainScreen();


        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
