import entity.Library;
import gui.MainJFrame;
import service.Data;
import service.GlobalStorage;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        GlobalStorage globalStorage = new GlobalStorage();
        main.init(globalStorage);
    }

    private void init(GlobalStorage globalStorage) {
        Data data = new Data(globalStorage);
        Library library = new Library();
        globalStorage.setLibrary(library);
        //globalStorage.setLibrary(new Library);

        /******** INPUT DATA *******/
        globalStorage.setUsers(data.loadUsersData("users.txt"));
        globalStorage.getLibrary().setBooks(data.loadBooksData("books.txt"));
        globalStorage.getLibrary().setSpaces(data.loadSpacesData("spaces.txt"));
        data.loadRezervationsData("rezervations.txt");

        MainJFrame mainJFrame = new MainJFrame(globalStorage, data);
        mainJFrame.setVisible(true);

        /******** OUTPUT DATA *******/
        //data.booksData();       //atnaujina userius ir knygas
        //data.spacesData();      //atnaujina userius ir erdves
    }

}
