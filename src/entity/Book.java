package entity;

import java.util.Calendar;

public class Book {
    private String name;
    private String author;
    private int id;
    private boolean isTaken;
    private int floor;
    private int section;
    private String date;
    private String user;
    private int extLeft;
    private Calendar calDate = new Calendar() {
        @Override
        protected void computeTime() {

        }

        @Override
        protected void computeFields() {

        }

        @Override
        public void add(int i, int i1) {

        }

        @Override
        public void roll(int i, boolean b) {

        }

        @Override
        public int getMinimum(int i) {
            return 0;
        }

        @Override
        public int getMaximum(int i) {
            return 0;
        }

        @Override
        public int getGreatestMinimum(int i) {
            return 0;
        }

        @Override
        public int getLeastMaximum(int i) {
            return 0;
        }
    };

    public Book(String name, String author, int id, boolean isTaken, int floor, int section, String date, String user, int extLeft) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.isTaken = isTaken;
        this.floor = floor;
        this.section = section;
        this.date = date;
        this.user = user;
        this.extLeft = extLeft;
        this.calDate = calDate;
    }

    @Override
    public String toString() {
        return name +
                "_" + author +
                "_" + id +
                "_" + isTaken +
                "_" + floor +
                "_" + section +
                "_" + date +
                "_" + user +
                "_" + extLeft;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isTaken() {
        return isTaken;
    }
    public void setIsTaken(boolean taken) {
        this.isTaken = taken;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSection() {
        return section;
    }
    public void setSection(int section) {
        this.section = section;
    }

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}

    public int getExtLeft(){return extLeft;}
    public void setExtLeft(int extLeft) {this.extLeft = extLeft;}

    public Calendar getCalDate(){return calDate;}
    public void setCalDate (Calendar calDate) {this.calDate = calDate;}
}
