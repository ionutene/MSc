package project.getSearchedPaths;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * Created by 01ene on 6/16/2017.
 */
public class SwingQuerry extends Frame implements ActionListener {
    JTextField tf1;
    JLabel l;
    JButton b;

    SwingQuerry() {
        //example of valid input a1,b2
        tf1 = new JTextField();
        tf1.setBounds(100, 150, 150, 20);
        l = new JLabel();
        l.setBounds(50, 100, 250, 20);
        b = new JButton("Determina parcursurile continand");
        b.setBounds(50, 100, 250, 30);
        b.addActionListener(this);
        add(b);
        add(tf1);
        add(l);
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

    public static void main(String[] args)

    {
        new SwingQuerry();

    }

    /*public boolean validator(String variable, LinkedList<String> requestedValues) {
        boolean result = false;
        String[] variableArray = (variable.replace(",", "").replace(" ", "").split("(?<=\\G.{2})"));
        for (String req : requestedValues) {
            String[] requestedArray = (req.replace(",", "").replace(" ", "").split("(?<=\\G.{2})"));
            result = false;
            for (String as : variableArray) {
                if (requestedArray.equals(as)) {
                    result = true;
                }
            }
        }

        return result;
    }*/

    public void actionPerformed(ActionEvent e) {
        try {
            String from = (tf1.getText());
            String[] as = from.split(",");
            LinkedList<String> requestedValues = new LinkedList<>();
            for (String c : as) {
                requestedValues.add(c);
            }
            try {
                long now = System.currentTimeMillis();
                ParseCSVLineByLine p = new ParseCSVLineByLine();
                LinkedHashSet<String> returnValue = p.getParseCSVLineByLine();

                JFrame f = new JFrame();

                DefaultListModel<String> l1 = new DefaultListModel<>();

                for (String a : returnValue) {
                    boolean decision = true;
                    for (String b : requestedValues) {

                        if (!a.contains(b))
                            decision = false;

                    }
                    if (decision)
                        l1.addElement(a);
                }
                JList<String> list = new JList<>(l1);
                JScrollPane scrollBar1 = new JScrollPane();

                list.setBounds(100, 100, 75, 175);
                scrollBar1.setBounds(75, 100, 225, 175);
                scrollBar1.setViewportView(list);
                f.add(scrollBar1);
                f.setSize(400, 400);
                f.setLayout(null);
                f.setVisible(true);
                f.setResizable(true);

                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT

                JLabel label = new JLabel();
                label.setBounds(150, 300, 75, 75);
                label.setSize(500, 100);
                String data = "Totul a durat: " + (System.currentTimeMillis() - now) + " ms";
                label.setText(data);
                f.add(label);

                System.out.println();

            } catch (IOException a) {
                a.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
