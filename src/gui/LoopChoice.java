package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import domain.Mode3;
import domain.easyMode3;

@SuppressWarnings("serial")
public class LoopChoice extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	ImagePanel questiondiagram;
	JTextPane questiondata = new JTextPane();
	JTextPane questiontext = new JTextPane();
	JRadioButton a = new JRadioButton("C");
	JRadioButton b = new JRadioButton("D");
	JRadioButton c = new JRadioButton("D");
	JButton submit = new JButton("Submit");
	ButtonGroup group = new ButtonGroup();
	Mode3 question;int difficulty;

	public LoopChoice(int difficulty, String loop1, String loop2, String loop3) {
		super();
		this.difficulty = difficulty;
		a.setText(loop1);
		b.setText(loop2);
		c.setText(loop3);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(0);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		switch (difficulty) {
		case (0):
			question = new easyMode3();
			filldata();
			break;
		case (1):
			question = new easyMode3();
			filldata();
			break;
		case (2):
			question = new easyMode3();
			filldata();
			break;
		}
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();
		filldata();
	}

	public LoopChoice(int difficulty, String loop1, String loop2) {
		super();
		this.difficulty = difficulty;
		a.setText(loop1);
		b.setText(loop2);
		c.setVisible(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(difficulty);
		switch (difficulty) {
		case (0):
			question = new easyMode3();
			filldata();
			break;
		case (1):
			question = new easyMode3();
			filldata();
			break;
		case (2):
			question = new easyMode3();
			filldata();
			break;
		}
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();
		filldata();
	}

	private void filldata() {
		questiondata.setText(question.questiondata);
		StyledDocument doc = questiondata.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		questiontext.setText("Which loop would you like to work with?");
		doc = questiontext.getStyledDocument();
		center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	private void makeandplacecomponents() {
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (a.isSelected()){
					question.setloopchoice(a.getText());
					Mode3.loopoptions.remove(0);
				}
				else if (b.isSelected()){
					question.setloopchoice(b.getText());
					Mode3.loopoptions.remove(1);
				}
				else if (c.isSelected()){
					question.setloopchoice(c.getText());
					Mode3.loopoptions.remove(2);
				}
				close();
			}
		});
		group.add(a);
		group.add(b);
		group.add(c);
		a.setMargin(new Insets(0, 15, 0, 0));
		b.setMargin(new Insets(0, 15, 0, 0));
		c.setMargin(new Insets(0, 15, 0, 0));
		questiondata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
				Color.BLACK));
		questiontext.setFont(new Font("Serif", 0, 15));
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 12;
		c.gridheight = 12;
		c.ipady = 275;
		this.add(questiondiagram, c);
		c.ipady = 0;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 13;
		c.weightx = 0.0;
		c.gridwidth = 12;
		this.add(questiondata, c);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.weightx = 0.0;
		c.gridwidth = 12;
		this.add(questiontext, c);
		c.gridx = 0;
		c.gridy = 15;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(a, c);
		c.gridx = 0;
		c.gridy = 16;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(b, c);
		c.gridx = 0;
		c.gridy = 17;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(this.c, c);
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridwidth = 4;
		submit.setMargin(new Insets(10, 39, 10, 39));
		this.add(submit, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridwidth = 4;
		Component hint = new JButton();
		hint.setVisible(false);
		this.add(hint, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		c.gridwidth = 4;
		this.add(hint, c);

	}

	@SuppressWarnings("unused")
	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
		mode3 mode3 = new mode3(difficulty);
	}
}
