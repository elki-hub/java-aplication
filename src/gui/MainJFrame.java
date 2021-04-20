package gui;

import entity.*;
import service.BooksFilter;
import service.Data;
import service.GlobalStorage;
import service.UserFilterBooks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainJFrame extends JFrame {

    private JPanel mainPanel;
    private JButton logoutButton;
    private JButton loginButton;
    private JTextField usernameTextField;
    private JPanel userPanel;
    private JTabbedPane tabbedPane;
    private JPanel loggedInPanel;
    private JPanel books;
    private JTextField bookResearch;              //knygos autorius ir pavadinimas
    private JButton findBook;
    private JTextArea booksResults;
    private JButton takeBook;                   //pasiimti knyga
    private JTextField bookID;                  //knygos ID
    private JTextField userID;                  //vartotojo ID
    private JTextArea textArea1;
    private JPanel reservation;
    private JPanel onlyForManager;
    private JTextArea bookTakingResult;
    private JTextArea textArea2;
    private JButton minusYear;
    private JButton mėnesisButton1;
    private JButton dienaButton1;
    private JButton metaiButton;
    private JButton mėnesisButton;
    private JButton dienaButton;
    private JRadioButton buttonFrom10;
    private JRadioButton buttonFrom19;
    private JRadioButton buttonFrom18;
    private JRadioButton buttonFrom17;
    private JRadioButton buttonFrom16;
    private JRadioButton buttonFrom15;
    private JRadioButton buttonFrom14;
    private JRadioButton buttonFrom8;
    private JRadioButton buttonFrom12;
    private JComboBox workSpaceCombo;
    private JRadioButton buttonFrom9;
    private JRadioButton buttonFrom11;
    private JRadioButton buttonFrom13;
    private JTextField bookReturn;
    private JButton returnBook;
    private JTextArea bookReturnResult;
    private JButton extendButton;
    private JTextArea bookInfo;
    private JTextField bookExtendField;
    private JButton showButton;
    Calendar cal = Calendar.getInstance();
    private int c = 0;

    GlobalStorage globalStorage;
    Data data;



    public MainJFrame(GlobalStorage globalStorage, Data data) {
        this.globalStorage = globalStorage;
        this.data = data;
        add(mainPanel);
        setTitle("Biblioteka");
        setSize(800, 500);
        loggedInPanel.setVisible(false);
        printDate(cal);

        updateUserPanel();

        /***** Time management *****/
        metaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onPlusY();
            }
        });
        mėnesisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onPlusM();
            }
        });
        dienaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onPlusD();
            }
        });
        minusYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onMinusY();
            }
        });
        mėnesisButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onMinusM();
            }
        });
        dienaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onMinusD();
            }
        });

        /***** Book research *****/
        findBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFind();
            }
        });

        bookResearch.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onFind();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /***** book reservation *****/
        takeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onRegister();
            }
        });
        userID.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        bookID.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /***** Return *****/
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {onReturn(); }
        });

        /***** Extend *****/
        extendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onExtend();
            }
        });
        bookExtendField.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExtend();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);



        /***** Login *****/

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogout();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /***** User book management *****/

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                onFindUserBook();
            }
        });
    }

    /***** Time management *****/
    private void printDate(Calendar scal){
        Date datey = scal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String data = format1.format(datey);
        StringBuilder builder = new StringBuilder();
        builder.append(data).append("\n");
        textArea2.setText(builder.toString());

    }

    private void onPlusY(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.YEAR, 1);
        printDate(mcal);
    }
    private void onPlusM(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.MONTH, 1);
        printDate(mcal);
    }
    private void onPlusD(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.DAY_OF_MONTH, 1);
        printDate(mcal);
    }
    private void onMinusY(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.YEAR, -1);
        printDate(mcal);
    }
    private void onMinusM(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.MONTH, -1);
        printDate(mcal);
    }
    private void onMinusD(){
        Calendar mcal = new Calendar() {
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
        mcal = cal;
        mcal.add(mcal.DAY_OF_MONTH, -1);
        printDate(mcal);
    }


    /***** Book research *****/
    private void onFind() {
        String bookName = bookResearch.getText();
        BooksFilter booksFilter = new BooksFilter(globalStorage);
        List<Book> value = booksFilter.filterBooks(bookName);
        ifBookExits(value);
    }

    private void onFindUserBook() {
        GlobalStorage storage = new GlobalStorage();
        String name = globalStorage.getCurrentUserName();
        UserFilterBooks booksFilter = new UserFilterBooks(globalStorage);
        List<Book> value = booksFilter.userFilter(name);
        ifBookFind(value);
    }

    private void printBooks(List<Book> booksToPrint) {
        GlobalStorage storage = new GlobalStorage();
        StringBuilder builder = new StringBuilder();
        String name = globalStorage.getCurrentUserName();
        for (Book book : booksToPrint) {
            if("personalas".equals(name)){
                builder.append("Knygos ID: ");
                builder.append(book.getId()).append("\n");
            }
            builder.append("Knygos pavadinimas: ");
            builder.append(book.getName()).append("\n");
            builder.append("Knygos autorius: ");
            builder.append(book.getAuthor()).append("\n");
            builder.append("Knygos vieta bibliotekoje: \n");
            builder.append(book.getFloor()).append(" aukštas, ");
            builder.append(book.getSection()).append(" sekcija\n");
            builder.append("Bibliotekoje laisvų egzempliorių  ");
            if (book.isTaken()) {
                builder.append("nėra\n");
                builder.append("Knygos grazinimo laikas: ");
                builder.append(book.getDate()).append("\n");
                if("personalas".equals(name)){
                    builder.append("Knyga dabar yra pas: ");
                    builder.append(book.getUser()).append("\n");
                    builder.append("Pratęsimų likutis: ");
                    builder.append(book.getExtLeft()).append("\n").append("\n");
                }
                else builder.append("\n");
            } else builder.append("yra\n").append("\n");
            booksResults.setText(builder.toString());
        }

    }

    /***** User book management *****/

    private void ifBookFind(List<Book> list){
        if(list.size() > 0){
            onShow(list);
        }
        else{
            bookInfo.setText("Jūs neturite paimtų knygų");
        }
    }

    private void onShow(List<Book> booksToPrint){


        GlobalStorage storage = new GlobalStorage();
        StringBuilder builder = new StringBuilder();
        String name = null;
        Library library = globalStorage.getLibrary();
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book currentBook = library.getBooks().get(i);
            if(currentBook.getDate() != null){
                try {
                    SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateObj = curFormater.parse(currentBook.getDate());
                    Calendar calendar = Calendar.getInstance();
                    calendar .setTime(dateObj);
                    currentBook.setCalDate(calendar);
                }catch(Exception e){
                    int f = 0;
                }

            }
        }
        Calendar ccal = new Calendar() {
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
        name = globalStorage.getCurrentUserName();
        for (Book book : booksToPrint) {
            builder.append("Knygos ID: ");
            builder.append(book.getId()).append("\n");
            builder.append("Knygos pavadinimas: ");
            builder.append(book.getName()).append("\n");
            builder.append("Knygos autorius: ");
            builder.append(book.getAuthor()).append("\n");
            builder.append("Knygos grazinimo laikas: ");
            builder.append(book.getDate()).append("\n");
            builder.append("Pratęsimų likutis: ");
            builder.append(book.getExtLeft()).append("\n");
            ccal = book.getCalDate();
            Date dateee = ccal.getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String inActiveDate = format1.format(dateee);
            long daysBetween = ChronoUnit.DAYS.between(cal.toInstant(), book.getCalDate().toInstant());
            if(daysBetween == 0) {
                builder.append("Šiandien yra paskutinė diena knygai grąžinti!").append("\n");
            }
            else if(daysBetween < 0){
                builder.append("Vėluojate grąžinti knygą!").append("\n");
            }
            else if(daysBetween > 0 && daysBetween < 7){
                builder.append("Liko mažiau nei savaitė grąžinti knygai!").append("\n");
            }
            else builder.append("\n");

        }
            bookInfo.setText(builder.toString());
        }

    private void ifBookExits(List<Book> list){
        if(list.size() > 0){
            printBooks(list);
        }
        else{
            booksResults.setText("Knyga nerasta. Klaidingai suvestas autorius arba knygos pavadinimas. ");
        }
    }
    /***** Book registration *****/
    private void onRegister() {
        if(c>0) cal.add(Calendar.MONTH, -1);
        String bookId = bookID.getText();
        String userId = userID.getText();
        Take take = new Take(globalStorage);
        StringBuilder builder = new StringBuilder();
        builder.append(take.takeBook(bookId, userId, cal));
        bookTakingResult.setText(builder.toString());
        c++;
        data.booksData();
    }

    /***** Return *****/
    private void onReturn(){
        String bookID = bookReturn.getText();
        Returning returning = new Returning(globalStorage);
        StringBuilder builder = new StringBuilder();
        builder.append(returning.returnBook(bookID));
        bookReturnResult.setText(builder.toString());
        data.booksData();
    }

    /***** Extend *****/
    private void onExtend(){
        String bookID = bookExtendField.getText();
        Extending extend = new Extending(globalStorage);
        StringBuilder builder = new StringBuilder();
        builder.append(extend.extendBook(bookID));
        bookInfo.setText(builder.toString());
        data.booksData();
    }

    /***** Login *****/
    private void onLogin() {
        var dialog = new LoginDialog(globalStorage);
        dialog.setVisible(true);
        updateUserPanel();
    }

    private void onLogout(){
        globalStorage.setCurrentUser("", "");
        updateUserPanel();
    }


    private void updateUserPanel() {
        if(globalStorage.getCurrentUser() != null) {
            loggedInPanel.setVisible(true);
            usernameTextField.setText(globalStorage.getCurrentUser().getName());
            loginButton.setVisible(false);

            if(globalStorage.userIsManager() ){
                onlyForManager.setVisible(true);
            }
            else{
                onlyForManager.setVisible(false);
            }
        }
        else{
            onlyForManager.setVisible(false);
            loggedInPanel.setVisible(false);
            usernameTextField.setText("");
            loginButton.setVisible(true);
        }
        revalidate();
        repaint();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
