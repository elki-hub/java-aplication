package service;

import entity.Book;
import entity.Extending;
import entity.Library;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class GlobalStorage{

    private List<User> users = new ArrayList<>();
    private Library library;
    private User currentUser;
    private String currentUserName;
    private String userRole;

    /*public void addUser(String name, String password, Role role){
        users.add(new User(name, password, role));
    }*/

    public void setCurrentUser(String userName, String userPassword) {
        for (User user: users) {
            if(user.getName().equalsIgnoreCase(userName) && user.getPassword().equals(userPassword)){
                currentUser = user;
                currentUserName = userName;
                GlobalStorage globalStorage = new GlobalStorage();
                return;
            }
        }
        currentUser = null;
    }

    public void getUR(String userName){
        for(User user: users){
            if(user.getName().equalsIgnoreCase(userName)){
                userRole = user.getRole().toString();
            }
        }
    }

    public boolean ifUserExist(String userName){
        for (User user: users) {
            if(user.getName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

    public Library getLibrary() {
        return library;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String getCurrentUserName(){return currentUserName;}

    public String getRole(){return userRole;}

    public boolean userIsManager() {
        if(currentUser == null){
            return false;
        }
        return currentUser.isManager();
    }
    /*public boolean userIsStudent(){


    }*/

    public boolean userIsGuest(){
        return currentUser == null;    //if currentUser == null; return true
    }

    public void setLibrary(Library lib) {
        library = lib;
    }

    public void setUsers(List<User> users) {      //saving users data to user class
        this.users = users;
    }
}

