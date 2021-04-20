package entity;

public class Room {
    private int noOfStud;
    private int noHall;
    private boolean isFree;

    public Room (int noOfStud, int noHall) {
        this.noOfStud = noOfStud;
        this.noHall = noHall;
        this.isFree = true;
    }

}

