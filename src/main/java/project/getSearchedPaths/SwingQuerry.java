package project.getSearchedPaths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SwingQuerry extends Frame implements ActionListener {
    JTextField inputField;
    JLabel label;
    JButton submitButton;

    public SwingQuerry() {
        //example of valid input a1,b2
        inputField = new JTextField();
        inputField.setBounds(100, 150, 150, 20);
        label = new JLabel();
        label.setBounds(50, 100, 250, 20);
        submitButton = new JButton("Determina parcursurile continand");
        submitButton.setBounds(50, 100, 250, 30);
        submitButton.addActionListener(this);
        add(submitButton);
        add(inputField);
        add(label);
        JLabel label = new JLabel();
        label.setBounds(50, 300, 75, 75);
        label.setSize(300, 100);
        String data1 = "* separate prin , ";
        label.setText(data1);
        add(label);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingQuerry();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String inputText = (inputField.getText());
            String[] elementsOfInputText = inputText.split(",");
            LinkedList<String> requestedValuesToLookUp = new LinkedList<>();
            for (String element : elementsOfInputText) {
                requestedValuesToLookUp.add(element);
            }
            try {
                long now = System.currentTimeMillis();
                ParseCSVLineByLine p = new ParseCSVLineByLine();
                LinkedHashSet<String> returnValue = p.getParseCSVLineByLine();
                JFrame frame = new JFrame();
                DefaultListModel<String> listReturned = new DefaultListModel<>();
                for (String a : returnValue) {
                    boolean decision = true;
                    for (String b : requestedValuesToLookUp) {
                        if (!a.contains(b))
                            decision = false;
                    }
                    if (decision)
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
