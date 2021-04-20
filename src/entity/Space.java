package entity;

import java.util.ArrayList;

public class Space {
    private String name;
    private int id;
    private ArrayList<Rezervated> rezervations = new ArrayList<>();

    public Space(String name, int id) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name +
                "_" + id;
    }

    public void addRezervation(String date, String time, String user){
        this.rezervations.add(new Rezervated(date, time, user, name, id));
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Rezervated> getRezervations() {
        return rezervations;
    }

    public void setRezervations(ArrayList<Rezervated> rezervations) {
        this.rezervations = rezervations;
    }
}
