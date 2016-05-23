package Model;

import Controller.Controller;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Donika on 4/19/2016.
 */
public class Database<T> {

    private Controller controller;

    private Connection conn = null;

    public Database(Controller controller) throws Exception, java.text.ParseException {
        this.controller = controller;
        try
        {
            String DB_URL = "jdbc:mysql://db4free.net:3306/taastrup";
            String USER = "daka";
            String PASS = "12345678";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("conn obj created " + conn + " message: ");
        } catch (SQLException e)
        {
            System.out.println("db error " + e.getMessage());
        }catch (ClassNotFoundException ce)
        {
            System.out.println("Class not found: " + ce.getMessage());
        }
    }

    public int deleteToDB(String phoneTextField)
    {
        String get_data = " select calendarId , cPhone from reservation where cPhone=?";
        int result =0;
        int cal_id = 0;
        String cPhone="";

        try
        {
            PreparedStatement preparedStatement_cus = conn.prepareStatement(get_data);

            preparedStatement_cus.setString(1, phoneTextField);
            System.out.println(preparedStatement_cus);
            ResultSet resultSet = preparedStatement_cus.executeQuery();
            while(resultSet.next()){
                cal_id = resultSet.getInt(1);
                cPhone = resultSet.getString(2);
                //System.out.println("cPhone:" + cPhone+ "\n");
                //System.out.println("CalendarId :" +cal_id + "\n");
            }


            PreparedStatement preparedStatement_res= conn.prepareStatement("delete from reservation  where cPhone = ?");

            preparedStatement_res.setString(1, cPhone);
            //System.out.println(preparedStatement_res);
            result =  preparedStatement_res.executeUpdate();
            PreparedStatement preparedStatement_cal= conn.prepareStatement("delete from calendar where calendarId = ?");

            preparedStatement_cal.setInt(1, cal_id);
            //System.out.println(preparedStatement_cal);
            result = result + preparedStatement_cal.executeUpdate();

            PreparedStatement preparedStatement_cusd= conn.prepareStatement("delete from customer where cPhone = ?");

            preparedStatement_cusd.setString(1, cPhone);
            //System.out.println(preparedStatement_cusd);
            result =result +  preparedStatement_cusd.executeUpdate();



        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }


    public int updateToDB(Timestamp date,String time ,int nrOfPeople, String phoneTextField, String comment, int tableNr)
    {
        int result =0;
        try
        {
            if(isCustomerExist(phoneTextField)) {
                String sql_update = "update reservation inner join customer on customer.cPhone = reservation.cPhone " +
                        "inner join calendar on calendar.calendarId = reservation.calendarId " +
                        "set calendar.cDate = \'"+ date+"\', cPeople =\'"+ nrOfPeople + "\', cComment =\'"+ comment + "\', tableNo =\'"+ tableNr +
                        "\' where calendar.cDate = \'" + date +"\' and customer.cPhone=\'" + phoneTextField +"\'";  //calendar.cTime ='"+ time +
                PreparedStatement ps_update_res = conn.prepareStatement(sql_update);

                //System.out.println(ps_update_res);
                result = ps_update_res.executeUpdate();
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isCustomerExist(String cPhone)
    {
        PreparedStatement preparedStatement;
        String check_sql = "select * from reservation where cPhone= ?";
        try
        {
            preparedStatement = conn.prepareStatement(check_sql);
            preparedStatement.setString(1, cPhone);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                System.out.println("Error: " +resultSet.getString(1) + "\n");
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public int getCalendarID()
    {
        int result=1;
        PreparedStatement preparedStatement;
        try
        {
            preparedStatement = conn.prepareStatement("Select max(calendarid) from calendar");


            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                // System.out.println("Got the new calendar Id *** " +resultSet.getString(1) + "\n");
                result =  Integer.parseInt(resultSet.getString(1));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        }
        return result;
    }



    public int createCustomerInDatabase(String name, String phoneNumber)
    {
        try {
            String cus_sql = "insert into customer values(?,?)";

            PreparedStatement preparedStatement_cus = conn.prepareStatement(cus_sql);

            preparedStatement_cus.setString(1, name);
            preparedStatement_cus.setString(2, phoneNumber);

            // System.out.println(preparedStatement_cus.toString());
            int numberOfRows = preparedStatement_cus.executeUpdate();
            return numberOfRows;
        }
        catch(Exception e)
        {

        }
        return 0;
    }

    public int writeToDB(Timestamp timestamp, int cNoPeople, String cName, String cPhone, String cComment,String time, int tableNr){

        String cal_sql = "insert into calendar (cDate,cTime) values(?,?)";
        String res_sql = "insert into reservation(calendarId,cPhone,cPeople,cComment,tableNo) values(?,?,?,?,?)";
        //String booking_sql = "insert into booking (resID,calendarId) values(?,?)";

        if(!isCustomerExist(cPhone)){
            int resultOfCreatingCustomer = createCustomerInDatabase(cName, cPhone);
            if(resultOfCreatingCustomer == 0)
            {
                return 0;
            }
        }
        int cal_id =1;
        try{
            PreparedStatement preparedStatement_cal = conn.prepareStatement(cal_sql);


            preparedStatement_cal.setTimestamp(1, timestamp);
            preparedStatement_cal.setString(2, time);

            int numberOfRows = preparedStatement_cal.executeUpdate();

            //System.out.println(preparedStatement_cal.toString());
            cal_id =  getCalendarID();
            PreparedStatement preparedStatement_res = conn.prepareStatement(res_sql);

            // cal_id =  getCalendarID();
            // PreparedStatement preparedStatement_booking = conn.prepareStatement(booking_sql);

            preparedStatement_res.setInt(1, cal_id);
            preparedStatement_res.setString(2, cPhone);
            preparedStatement_res.setInt(3, cNoPeople);
            preparedStatement_res.setString(4, cComment);
            preparedStatement_res.setInt(5, tableNr);

            //System.out.println(preparedStatement_res.toString());
            numberOfRows = numberOfRows + preparedStatement_res.executeUpdate();
            return numberOfRows;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Bookings> getBookings(String date){
        ArrayList<Bookings> list=new ArrayList<>();
        try
        {
            PreparedStatement preparedStatement;
            if(date.length()>0) {
                String sql1= "select t3.cDate,t3.ctime,t2.cPhone,t2.cName,t1.cPeople,t1.cComment,t1.tableNo " +
                        "from reservation t1, customer t2, calendar t3 where t1.cPhone = t2.cPhone " +
                        "and t1.calendarId =t3.calendarId and t3.cDate = ?";
                preparedStatement = conn.prepareStatement(sql1);
                preparedStatement.setString(1, date);
                //System.out.println("Query is :" + preparedStatement.toString() + "\n");
            }
            else{
                String sql2 ="select t3.cDate,t3.ctime,t2.cName,t2.cPhone,t1.cComment,t1.cPeople,t1.tableNo " +
                        "from reservation t1, customer t2, calendar t3 where t1.cPhone = t2.cPhone " +
                        "and t1.calendarId = t3.calendarId";
                preparedStatement = conn.prepareStatement(sql2);
                //System.out.println("Query is :" + preparedStatement.toString() + "\n");
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Bookings(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),
                        Integer.parseInt(resultSet.getString(6)), Integer.parseInt(resultSet.getString(7))));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
