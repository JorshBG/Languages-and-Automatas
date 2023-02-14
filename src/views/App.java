package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    private JPanel pnlMain;
    private JTextField txtRegex;
    private JButton btnValidate;
    private JTextField txtWord;
    private JButton btnAdd;
    private JTable tblResults;
    private JTable tblWords;
    private JLabel lblRegex;
    private JLabel lblWord;
    private JPanel pnlHead;
    private JPanel pnlTables;
    private JScrollPane pnlResults;
    private JScrollPane pnlWords;

    public App(){
        init();
        btnValidate.addActionListener(e -> {

        });
    }

    private void init(){
        setTitle("Regex Implementation");
        setContentPane(pnlMain);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setVisible(true);
    }


}


