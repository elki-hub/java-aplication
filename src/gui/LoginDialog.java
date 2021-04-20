package gui;

import service.GlobalStorage;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton loginButton;
    private JButton buttonCancel;
    private JTextField loginName;
    private JTextField errorMessageField;
    private JTextField loginPassword;

    GlobalStorage globalStorage;

    public LoginDialog(GlobalStorage globalStorage) {
        this.globalStorage = globalStorage;
        setContentPane(contentPane);
        setModal(true);
        setSize(470, 120);
        setTitle("Login");
        getRootPane().setDefaultButton(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        errorMessageField.setVisible(false);
    }

    private void onOK() {
        // add your code here
        globalStorage.setCurrentUser(loginName.getText(), loginPassword.getText());
        if(globalStorage.getCurrentUser() == null){
            errorMessageField.setVisible(true);
            revalidate();
            repaint();
            return;
        }

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

   /* public void main(String[] args) {
        LoginDialog dialog = new LoginDialog(globalStorage);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }*/
}
