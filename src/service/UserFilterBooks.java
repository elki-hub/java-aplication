package service;

import entity.Book;
import entity.Library;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class UserFilterBooks {

    GlobalStorage globalStorage;

    public UserFilterBooks(GlobalStorage globalStorage){
        this.globalStorage = globalStorage;
    }

    public List<Book> userFilter(String UserID){
        Library library = globalStorage.getLibrary();

        List<Book> books = new ArrayList<>();
        for (Book b : library.getBooks()) {
            if (containsIgnoreCase2(b.getUser(),  UserID)) {
                books.add(b);
            }
        }
        return books;
    }

    public boolean containsIgnoreCase2(String src, String input) {
        var srcLower = Normalizer.normalize(src.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{M}", "").trim(); //trim- nuima white space
        var inputLower = Normalizer.normalize(input.toLowerCase(), Normalizer.Form.NFD).replaceAll("\\p{M}", "").trim(); //normalize
        return srcLower.contains(inputLower);
    }
}