package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class QuestionChoiceFrame extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	private javax.swing.JButton cont;
	private javax.swing.JButton home;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextPane prompt;
	private javax.swing.JRadioButton question1;
	private javax.swing.JRadioButton question2;
	private javax.swing.JRadioButton question3;
	private javax.swing.JRadioButton question4;
	private javax.swing.JRadioButton question5;
	private javax.swing.JRadioButton question6;
	private javax.swing.JRadioButton question7;
	private javax.swing.JRadioButton question8;
	private ButtonGroup btngrp = new ButtonGroup();
	private int offset = 0;
	private String directory = "F:/ITS/Questions";

	public QuestionChoiceFrame(int offset) {
		super();
		this.offset = offset;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		initComponents();
		filldata();
		setListeners();
	}

	private void end() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	private void setListeners() {
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {

				int home = showhome();
				if (home == JOptionPane.OK_OPTION) {
					Home frame = new Home();
					frame.setSize(416, 700);
					frame.setVisible(true);
					end();
				}
			}

		});
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String filename = "";
				if (question1.isSelected())
					filename = directory + "/" + question1.getText()+".txt";
				if (question2.isSelected())
					filename = directory + "/" + question2.getText()+".txt";
				if (question3.isSelected())
					filename = directory + "/" + question3.getText()+".txt";
				if (question4.isSelected())
					filename = directory + "/" + question4.getText()+".txt";
				if (question5.isSelected())
					filename = directory + "/" + question5.getText()+".txt";
				if (question6.isSelected())
					filename = directory + "/" + question6.getText()+".txt";
				if (question7.isSelected())
					filename = directory + "/" + question7.getText()+".txt";
				if (question8.isSelected())
					filename = directory + "/" + question8.getText()+".txt";
				if (!filename.equals("")) {
					SolvingFrame frame = null;
					try {
						frame = new SolvingFrame(filename);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setSize(416, 700);
					close();
					frame.setVisible(true);
				}

			}
		});

	}

	private void filldata() {
		prompt.setText("Pick a question created by one of your classmates to solve.");
		StyledDocument doc = prompt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		final File folder = new File(
				"F:/ITS/Questions");
		ArrayList<String> filenames = listFilesForFolder(folder);
		JRadioButton[] questions = { question1, question2, question3,
				question4, question5, question6, question7, question8 };
		int i = offset;
		int k = 0;
		for (int j = 0; j < questions.length; j++) {
			btngrp.add(questions[j]);
			questions[j].setVisible(false);
			questions[j].setBackground(Color.WHITE);
		}

		while (i < filenames.size() && k < questions.length) {
			questions[i].setText(filenames.get(i).substring(0,filenames.get(i).length()-4));
			questions[i].setVisible(true);
			i++;
			k++;
		}
	}

	public ArrayList<String> listFilesForFolder(final File folder) {
		ArrayList<String> result = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				result.add(fileEntry.getName());
			}
		}
		return result;
	}

	private void initComponents() {

		home = new javax.swing.JButton();
		question1 = new javax.swing.JRadioButton();
		question2 = new javax.swing.JRadioButton();
		question3 = new javax.swing.JRadioButton();
		question4 = new javax.swing.JRadioButton();
		question5 = new javax.swing.JRadioButton();
		question6 = new javax.swing.JRadioButton();
		question7 = new javax.swing.JRadioButton();
		question8 = new javax.swing.JRadioButton();
		cont = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBorder(null);
		prompt = new javax.swing.JTextPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		home.setText("HOME");

		question1.setText("jRadioButton1");

		question2.setText("jRadioButton1");

		question3.setText("jRadioButton1");

		question4.setText("jRadioButton1");

		question5.setText("jRadioButton1");

		question6.setText("jRadioButton1");

		question7.setText("jRadioButton1");

		question8.setText("jRadioButton1");

		cont.setText("Continue");

		jScrollPane1.setViewportView(prompt);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														question8,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question7,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question3,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question5,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question6,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question4,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question2,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														question1,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										cont,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										104,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										home,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										104,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
										.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										87,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(question1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question6,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question5,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question7,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(question8,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														home,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														cont,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
	}// </editor-fold>

	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
