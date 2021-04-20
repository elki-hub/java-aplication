package entity;

import service.GlobalStorage;

public class Returning {

    GlobalStorage globalStorage;

    public Returning(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    public String returnBook(String bookID) {
        int IDbook = Integer.parseInt(bookID.trim());
        Library library = globalStorage.getLibrary();
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book currentBook = library.getBooks().get(i);
            if (currentBook.getId() == IDbook) {
                currentBook.setUser(null);
                currentBook.setDate(null);
                currentBook.setIsTaken(false);
                return "Knyga grąžinta";
            }

        }
        return "Knygos su tokiu ID nėra";
    }
}
