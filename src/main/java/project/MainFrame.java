package project;
import project.getAllPaths.Main;
import project.getBoundedPaths.Main1;
import project.getSearchedPaths.ParseCSVLineByLine;
import project.getSearchedPaths.SwingQuerry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
/**
 ** Created by 01ene on 6/19/2017.
 */
public class MainFrame extends JFrame {
    JButton option1 = new JButton("Compatibilitati de dimensiune intre");
    JButton option2 = new JButton("Compatibilitati continand traseul ");
    JButton option3 = new JButton("Toate compatibilitatile");
    JButton option4 = new JButton("Actualizeaza");

    public MainFrame() {
        option1.setBounds(50, 100, 250, 30);
        option2.setBounds(50, 150, 250, 30);
        option3.setBounds(50, 200, 250, 30);
        option4.setBounds(50, 250, 250, 30);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        setSize(400, 400);

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main1();
            }
        });

        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingQuerry();
            }
        });

        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LinkedList<String> requestedValues = new LinkedList<>();
                    try {
                        long now = System.currentTimeMillis();
                        ParseCSVLineByLine p = new ParseCSVLineByLine();
                        LinkedHashSet<String> returnValue = p.getParseCSVLineByLine();
                        JFrame frame = new JFrame();
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
                    } catch (IOException a) {
                        a.printStackTrace();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        option4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
            }
        });
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
