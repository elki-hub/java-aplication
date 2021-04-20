package entity;

import service.GlobalStorage;

import java.util.*;

public class Library{
    private List<Book> books = new ArrayList<>();
    private List<Space> spaces = new ArrayList<>();


    public void addBook(String name, String author, int id, boolean isTaken, int floor, int section, String date, String user, int extLeft){
        Book book = new Book(name, author, id, isTaken, floor, section, date, user, extLeft);
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void  setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

   public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }
}