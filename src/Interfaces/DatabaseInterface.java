package Interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by Donika on 4/19/2016.
 */
public interface DatabaseInterface<T> {

    int writeToDB(Timestamp timestamp, int cNoPeople, String cName, String cPhone, String cComment,String time, int tableNr);
    int deleteToDB(String phoneTextField);
    int updateToDB(Timestamp date, String time , int nrOfPeople, String phoneTextField, String comment, int tableNr);
    int getCalendarID();
    boolean isCustomerExist(String cPhone);
    int createCustomerInDatabase(String name, String phoneNumber);
    ArrayList<T> getBookings(String date);
}
