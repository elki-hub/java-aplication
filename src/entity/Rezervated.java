package entity;

import java.util.Calendar;

public class Rezervated extends Space{

    private String date;
    private String time;
    private String user;
    private Calendar catDate;

    public Rezervated(String date, String time, String user, String name, int id) {
        super(name, id);
        this.date = date;
        this.time = time;
        this.user = user;
        this.catDate = convertDate(date);
    }

    public Calendar convertDate(String string){
        Calendar calendar = Calendar.getInstance();
        String[] word = string.split("-");
        calendar.set(Calendar.YEAR, Integer.parseInt(word[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(word[1]));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(word[2]));
        return calendar;
    }

    public String toString(Space space) {
        return space.getId() +
                "_" + date +
                "_" + time +
                "_" + user ;
    }

        public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
