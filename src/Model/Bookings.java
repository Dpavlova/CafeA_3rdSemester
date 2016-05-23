package Model;

/**
 * Created by Donika on 4/19/2016.
 */
public class Bookings {

    private final String date,name,phone,comment,time;
    private final int people, tableNumber;

    public Bookings(String date, String time, String name, String phone, String comment, int people, int table){
        this.date = date;
        this.time = time;
        this.name = name;
        this.phone = phone;
        this.comment = comment;
        this.people = people;
        tableNumber = table;

    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getComment(){
        return comment;
    }
    public String getTime(){
        return time;
    }
    public int getPeople(){
        return people;
    }
    public int getTableNo(){ return tableNumber;}
    public String getDate(){
        return date;
    }
}
