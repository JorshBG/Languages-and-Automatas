package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AFD extends JFrame implements ActionListener{
    private JPanel main;
    private JButton btnSetDictionary;
    private JButton btnSetStates;
    private JButton btnSetInit;
    private JLabel lblTitle1;
    private JLabel lblDictionary;
    private JLabel lblTitle2;
    private JLabel lblStates;
    private JLabel lblTitle3;
    private JLabel lblInit;
    private JButton btnSetFinals;
    private JLabel lblTitle4;
    private JLabel lblFinal;
    private JCheckBox chkExact;
    private JCheckBox chkIncludeVoid;
    private JLabel lblSizeWord;
    private JTextField txtSizeWords;
    private JButton btnGenerateLang;
    private JButton btnBuild;
    private JTextArea txtValidation;
    private JScrollPane sclMain;
    private JTable tblTansitions;
    private JScrollPane sclOut;

    // Defaults
    private int[] states;
    private Character[] alphabet;
    private int init;
    private int[] deaths;
    private int[][] transitionTable;
    private automata.controllers.AFD control;
    private ArrayList<String> language;
    private DefaultTableModel tblModel;
    private Character[] headers;
    private String[][] contentStates;

    public AFD (){
        this.setTitle("AFD build");
        this.setContentPane(main);
//        setLocationRelativeTo(null);
        setSize(630, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setResizable(false);
        setVisible(true);
        btnSetFinals.addActionListener(this);
        btnSetInit.addActionListener(this);
        btnSetDictionary.addActionListener(this);
        btnSetStates.addActionListener(this);
        btnBuild.addActionListener(this);
        btnGenerateLang.addActionListener(this);
        this.control = new automata.controllers.AFD();
        this.tblModel = new DefaultTableModel();
        tblTansitions.setModel(tblModel);
//        this.createUIComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.btnSetDictionary) {
            String stringValues = JOptionPane.showInputDialog(null, "Insert the values of the dictionary separated by coma");
            String values[] = stringValues.split(",");
            lblDictionary.setText("E = {" + stringValues + "}");
            this.alphabet = new Character[values.length];
            this.headers = new Character[values.length+1];
            for (int i = 0; i < values.length; i++) {
                this.alphabet[i] = values[i].charAt(0);
                this.headers[i+1] = values[i].charAt(0);
            }
            this.headers[0] = 'Q';
            this.tblModel.setColumnIdentifiers(this.headers);
        } else if (e.getSource() == this.btnSetStates) {
            String stringValues = JOptionPane.showInputDialog(null, "Insert the names of the states separated by coma");
            String values[] = stringValues.split(",");
            lblStates.setText("Q = {" + stringValues + "}");
            this.states = new int[values.length];
            this.contentStates = new String[values.length][];
            for (int i = 0; i < values.length; i++) {
                this.states[i] = Integer.parseInt(values[i]);
                this.contentStates[i] = new String[]{values[i],"-1","-1"};
            }
            this.tblModel.setDataVector(this.contentStates,this.headers);
        } else if (e.getSource() == this.btnSetInit) {
            String stringValue = JOptionPane.showInputDialog(null, "Insert the name of the init state");
//            String values[] = stringValues.split(",");
            lblInit.setText("Q0 = {" + stringValue + "}");
            this.init = Integer.parseInt(stringValue);
        } else if (e.getSource() == this.btnSetFinals) {
            String stringValues = JOptionPane.showInputDialog(null, "Insert the names of the final states separated by coma");
            String values[] = stringValues.split(",");
            lblFinal.setText("A = {" + stringValues + "}");
            this.deaths = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                this.deaths[i] = Integer.parseInt(values[i]);
            }
        } else if (e.getSource() == this.btnGenerateLang) {
            boolean isFixedSize = this.chkExact.isSelected();
            boolean isIncludeVoid = this.chkIncludeVoid.isSelected();
            int sizeWord = Integer.parseInt(this.txtSizeWords.getText());
            this.language = control.generateLang(this.alphabet, sizeWord, isFixedSize, isIncludeVoid);

        } else if (e.getSource() == btnBuild) {
            var data = this.tblModel.getDataVector();
            int trueData[][] = new int[data.size()][data.get(0).size()-1];
            for (int i = 0; i < data.size(); i++) {
                for (int j = 1; j < data.get(0).size(); j++) {
                    var row = data.get(i);
                    trueData[i][j-1] =  Integer.parseInt(row.get(j).toString());
                }
            }

            this.control.newAFD_model(
                    this.states,
                    this.alphabet,
                    this.init,
                    this.deaths,
                    trueData
            );
            String result = this.control.validate(this.language);
            this.txtValidation.setText(result);
        }
    }

    private void createUIComponents() {
        sclOut = new JScrollPane();
        sclOut.setEnabled(true);
        sclOut.setMinimumSize(new Dimension(200,30));
        sclOut.setPreferredSize(new Dimension(200,30));
        sclOut.setSize(200,30);
        sclOut.setVerticalScrollBarPolicy(20);
        txtValidation = new JTextArea();
        txtValidation.setEditable(false);
        txtValidation.setLineWrap(true);
        txtValidation.setRows(0);
        txtValidation.setAutoscrolls(true);
        txtValidation.setPreferredSize(new Dimension(200,40));
        sclOut.setViewportView(txtValidation);
    }
}
