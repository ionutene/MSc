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

public class MainFrame extends JFrame {

	/*	private JMenuBar menuBar =new JMenuBar();
		private JMenu menu = new JMenu("Optiuni");*/
	JButton m1 = new JButton("Compatibilitati de dimensiune intre");
	JButton m2 = new JButton("Compatibilitati continand traseul ");
	JButton m3 = new JButton("Toate compatibilitatile");
	JButton m4 = new JButton("Actualizeaza");
	/*private JMenuItem m1 = new JMenuItem("Optiune 1");
	private JMenuItem m2 = new JMenuItem("Optiune 2");*/

	public MainFrame() {
		m1.setBounds(50, 100, 250, 30);
		m2.setBounds(50, 150, 250, 30);
		m3.setBounds(50, 200, 250, 30);
		m4.setBounds(50, 250, 250, 30);
		//		m1.addActionListener(new ActionListener() );

		add(m1);
		add(m2);
		add(m3);
		add(m4);
		/*menuBar.add(menu);
		setJMenuBar(menuBar);*/
		setSize(400, 400);
		m1.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) {
				new Main1();
			}
		});

		m2.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) {
				new SwingQuerry();
			}
		});

		m3.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) {
				try {


					LinkedList<String> requestedValues = new LinkedList<>();

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

		});


		m4.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent e) {
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
