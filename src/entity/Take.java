package entity;

import service.GlobalStorage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Take {

    GlobalStorage globalStorage;

    public Take(GlobalStorage globalStorage){
        this.globalStorage = globalStorage;
    }

    public String takeBook(String bookId, String userID, Calendar cal){
        int bookID = Integer.parseInt(bookId.trim());
        Calendar lcal = Calendar.getInstance();

        Library library = globalStorage.getLibrary();
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book currentBook = library.getBooks().get(i);
            if (currentBook.getId() == bookID) {
                if(globalStorage.ifUserExist(userID)){
                    lcal.add(lcal.MONTH, 1);
                    currentBook.setCalDate(lcal);
                    Date dateee = lcal.getTime();
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    String inActiveDate = format1.format(dateee);
                    currentBook.setUser(userID);
                    currentBook.setDate(inActiveDate);
                    globalStorage.getUR(userID);
                    String userRole = globalStorage.getRole();
                    if("STUDENT".equals(userRole)){
                        currentBook.setExtLeft(2);
                    }
                    else currentBook.setExtLeft(1);
                    currentBook.setIsTaken(true);
                    return "Knyga užrezervuota";
                }
                return "Toks vartotojas neegzistuoja";
            }
        }
        return "Klaidingai įvestas knygos ID";
    }
}

