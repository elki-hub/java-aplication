package service;

import entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    GlobalStorage globalStorage;

    public Data(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    /******** INPUT DATA *******/
    public List loadUsersData(String fileName) {
        ArrayList<User> usr = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split("_");
                usr.add(new User(word[0], word[1], Role.valueOf(word[2])));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usr;
    }

    public List loadBooksData(String fileName) {
        ArrayList<Book> bk = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split("_");
                Book book = new Book(word[0], word[1], Integer.parseInt(word[2]), Boolean.parseBoolean(word[3]), Integer.parseInt(word[4]), Integer.parseInt(word[5]), word[6],  word[7], Integer.parseInt(word[8]));
                bk.add(book);
                if(!word[7].equals("null")){
                    List<User> users = globalStorage.getUsers();
                    for(User u: users){
                        String tempUser = u.getName();
                        if(tempUser.equals(word[7])){
                            u.addTakenBooks(word[0], word[1], Integer.parseInt(word[2]), Boolean.parseBoolean(word[3]), Integer.parseInt(word[4]), Integer.parseInt(word[5]), word[6], word[7], Integer.parseInt(word[8]));
                            break;
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }

    public List loadSpacesData(String fileName){
        ArrayList<Space> sp = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while((line = reader.readLine()) != null) {
                String[] word = line.split("_");
                sp.add(new Space(word[0], Integer.parseInt(word[1])));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sp;
    }

    public void loadRezervationsData(String fileName){
        List<Space> spaces = globalStorage.getLibrary().getSpaces();
        List<User> users = globalStorage.getUsers();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null){
                String[] word = line.split("_");
                int tempID = Integer.parseInt(word[0]);
                for(Space s : spaces){
                    if(s.getId() == (tempID)){
                        s.addRezervation(word[1], word[2], word[3]);
                        for(User u : users){
                            if(u.getName().equals(word[3])){
                                u.addRezervation(word[1], word[2], word[3], s.getName(), s.getId());
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /******** OUTPUT DATA *******/
    public void booksData(){
        updateBooks();
        updateUsers();
    }
    public void spacesData(){
        updateUsers();
        updateSpacesAndRezervations();
    }
    public void updateUsers(){
        List<User> users = globalStorage.getUsers();
        String userString = "";
        for(User u: users){
            userString += u.toString() + "\n";
        }
        writeToFile("users.txt", userString);
    }

    public void updateBooks(){
        List<Book> books = globalStorage.getLibrary().getBooks();
        String bookString = "";
        for(Book b: books){
            bookString += b.toString() + "\n";
        }
        writeToFile("books.txt", bookString);
    }

    public void updateSpacesAndRezervations(){
        List<Space> spaces = globalStorage.getLibrary().getSpaces();
        String spaceString = "";
        String rezervationString = "";
        for(Space s: spaces){
            spaceString += s.toString() + "\n";
            rezervationString += rezervationsToString(s);
        }
        writeToFile("spaces.txt", spaceString);
        writeToFile("rezervations.txt", rezervationString);
    }

    public String rezervationsToString(Space s){
        String string = "";
            List<Rezervated> rezervations = s.getRezervations();
            for(Rezervated r: rezervations){
                string += r.toString(s) + "\n";
            }
            return string;
    }

    public void writeToFile(String fileName, String string){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(string);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*finally{
            try{
                if(writer != null)
                    writer.close();
            }catch(IOException e){
            }
        }*/
    }
}