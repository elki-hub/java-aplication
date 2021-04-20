package entity;

import service.GlobalStorage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Extending {
    GlobalStorage globalStorage;

    public Extending(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
    }

    public String extendBook(String bookID) {
        Calendar tcal = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int i, int i1) {

            }

            @Override
            public void roll(int i, boolean b) {

            }

            @Override
            public int getMinimum(int i) {
                return 0;
            }

            @Override
            public int getMaximum(int i) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int i) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int i) {
                return 0;
            }
        };
        int tmp;
        int t = 0;
        int IDbook = Integer.parseInt(bookID.trim());
        Library library = globalStorage.getLibrary();
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book currentBook = library.getBooks().get(i);
            if (currentBook.getId() == IDbook) {
                tmp = currentBook.getExtLeft();
                if(currentBook.isTaken()) {
                    if(tmp != 0) {
                        t = currentBook.getExtLeft();
                        tcal = currentBook.getCalDate();
                        tcal.add(tcal.DAY_OF_MONTH, 7);
                        currentBook.setCalDate(tcal);
                        Date date = tcal.getTime();
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                        String inDate = format1.format(date);
                        currentBook.setDate(inDate);
                        t--;
                        currentBook.setExtLeft(t);
                        return "Knygos grąžinimo laikas pratęstas";
                    }
                    return "Nebelikę pratęsimų";
                }
                return "Knyga nepaimta";
            }
        }
        return "Knygos grąžinimo laikas pratęstas";
    }
}
