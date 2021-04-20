package entity;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private Role role;
    private ArrayList<Book> takenBooks = new ArrayList<>();
    private ArrayList<Rezervated> rezervations = new ArrayList<>();

    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return name +
                "_" + password +
                "_" + role;
    }

    public void addTakenBooks(String name, String author, int id, boolean isTaken, int floor, int section, String date, String user, int extLeft){
        Book book = new Book(name, author, id, isTaken, floor, section, date, user, extLeft);
        this.takenBooks.add(book);
    }

    public void addRezervation(String date, String time, String user, String name, int id){
        this.rezervations.add(new Rezervated(date, time, user, name, id));
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return role.equals(Role.MANAGER);
    }

    public boolean isStudent() {
        return role.equals(Role.STUDENT);

    }


    public boolean isUser(){
        return role.equals(Role.USER);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Book> getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(ArrayList<Book> takenBooks) {
        this.takenBooks = takenBooks;
    }

    public ArrayList<Rezervated> getRezervations() {
        return rezervations;
    }

    public void setRezervations(ArrayList<Rezervated> rezervations) {
        this.rezervations = rezervations;
    }
}

