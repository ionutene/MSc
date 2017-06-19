package project.getBoundedPaths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class Main1 extends Frame implements ActionListener {
    JTextField limitField1;
    JTextField limitField2;
    JLabel label;
    JButton buttonSubmit;

    public Main1() {
        limitField1 = new JTextField();
        limitField2 = new JTextField();
        limitField1.setBounds(75, 200, 50, 20);
        limitField2.setBounds(200, 200, 50, 20);
        label = new JLabel();
        label.setBounds(50, 100, 250, 20);
        buttonSubmit = new JButton("Gaseste parcursurile intre");
        buttonSubmit.setBounds(50, 100, 250, 30);
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);
        add(limitField1);
        add(limitField2);
        add(label);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new Main1();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int fromLowerValue = Integer.parseInt(limitField1.getText());
            int toMaximiumValue = Integer.parseInt(limitField2.getText());
            try {
                long now = System.currentTimeMillis();
                Map<String, Set<String>> formulas = CSVParser.readCSV();
                Combinations combinations = new Combinations(formulas.keySet());
                combinations.doAllNonRepetitiveCombinationsBetweenIndices(fromLowerValue, toMaximiumValue);
                RouteVerification routeVerification = new RouteVerification(combinations.getFinalElements(), formulas);
                ArrayList<String> returnValue = routeVerification.doRouteVerifications();
                JFrame frame = new JFrame();
                DefaultListModel<String> listReturned = new DefaultListModel<>();
                for (String a : returnValue) {
                    listReturned.addElement(a);
                }
                JList<String> list = new JList<>(listReturned);
                JScrollPane scrollBar1 = new JScrollPane();
                list.setBounds(100, 100, 75, 175);
                scrollBar1.setBounds(75, 100, 225, 175);
                scrollBar1.setViewportView(list);
                frame.add(scrollBar1);
                frame.setSize(400, 400);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.setResizable(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JLabel label = new JLabel();
                label.setBounds(150, 300, 75, 75);
                label.setSize(500, 100);
                String data = "Totul a durat: " + (System.currentTimeMillis() - now) + " ms";
                label.setText(data);
                frame.add(label);
                System.out.println();
            } catch (IOException a) {
                a.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
