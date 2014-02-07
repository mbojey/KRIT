package gui;

import inferenceTools.Vertex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

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

import student.StudentData;
import domain.Mode1;
import domain.easyMode1;
import domain.hardMode1;
import domain.medMode1;

@SuppressWarnings("serial")
public class MultipleChoiceFrame extends JFrame implements MouseMotionListener {
	ImagePanel questiondiagram;
	JTextPane questiondata = new JTextPane();
	JTextPane questiontext = new JTextPane();
	JButton submit = new JButton("Submit");
	JButton cont = new JButton("Continue");
	JButton hint = new JButton("Continue");
	JRadioButton a = new JRadioButton("A)");
	JRadioButton b = new JRadioButton("B)");
	JRadioButton c = new JRadioButton("C)");
	JRadioButton d = new JRadioButton("D)");
	ButtonGroup group = new ButtonGroup();
	int step = 0;
	int wrongcounter = 0;
	Mode1 question;
	String explanation = "";
	int answer = 0;
	int correct;
	int difficulty;
	JButton home = new JButton("HOME");
	int x = 0;
	int y = 0;
	int xdist = 0;
	int ydist = 0;
	long current;

	public MultipleChoiceFrame(int difficulty) {
		super();
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		this.difficulty = difficulty;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(difficulty);
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();
		switch (difficulty) {
		case (0):
			question = new easyMode1();
			filldata();
			break;
		case (1):
			question = new medMode1();
			filldata();
			break;
		case (2):
			question = new hardMode1();
			filldata();
			break;
		}
	}

	private void filldata() {
		if(step >= question.answers.size()-1){
			close();
			return;
		}		
		questiondata.setText(question.questiondata);
		StyledDocument doc = questiondata.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		questiontext.setText(question.questions.get(step));
		doc = questiontext.getStyledDocument();
		center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		explanation = question.answers.get(step);
		Random rand = new Random();
		correct = rand.nextInt(4) + 1;
		if (correct == 1)
			a.setText(question.solutions.get(step));
		else
			a.setText(question.wrongsolutions.get(wrongcounter++));
		if (correct == 2)
			b.setText(question.solutions.get(step));
		else
			b.setText(question.wrongsolutions.get(wrongcounter++));
		if (correct == 3)
			c.setText(question.solutions.get(step));
		else
			c.setText(question.wrongsolutions.get(wrongcounter++));
		if (correct == 4)
			d.setText(question.solutions.get(step));
		else
			d.setText(question.wrongsolutions.get(wrongcounter++));
		cont.setVisible(false);
		group.clearSelection();
		if (submit.getActionListeners() == null)
			submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e){ browse(); pause();
					if (answer == 0) {
						StudentData.student.enter_evidence(new Vertex<String>(
								"Blank1", 2), 0);
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date date = new Date();
						StudentData.student.Roll_over(new Vertex<String>(
								"Understanding", 3), new Vertex<String>(
								"Understanding1", 3), dateFormat.format(date) + ","
										+ 1+  "," + difficulty + "," + step);
					} else {
						StudentData.student.enter_evidence(new Vertex<String>(
								"Blank1", 2), 1);
						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Date date = new Date();
						StudentData.student.Roll_over(new Vertex<String>(
								"Understanding", 3), new Vertex<String>(
								"Understanding1", 3), dateFormat.format(date) + ","
										+ 1+  "," + difficulty + "," + step);
						if (answer == correct)
							correct();
						else
							incorrect();
					}
				}
			});

	}

	private void incorrect() {
		cont.setVisible(true);
		submit.setVisible(false);
		final long starttimer1 = System.currentTimeMillis();
		questiontext.setText(question.answers.get(step));
		cont.removeActionListener(cont.getActionListeners()[0]);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				long endtimer = System.currentTimeMillis();
				Scanner scan = new Scanner(explanation);
				int wordcount = 0;
				while (scan.hasNext()) {
					wordcount++;
					scan.next();
				}
				// 300 ms is average time to read one word.
				if (wordcount * 300 > endtimer - starttimer1)
					StudentData.student.enter_evidence(new Vertex<String>(
							"Read Answer1", 2), 1);
				else
					StudentData.student.enter_evidence(new Vertex<String>(
							"Read Answer1", 2), 0);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				StudentData.student.Roll_over(new Vertex<String>(
						"Understanding", 3), new Vertex<String>(
						"Understanding1", 3), dateFormat.format(date) + ","
								+ 1+  "," + difficulty + "," + step);
				answer = 0;
				step++;
				filldata();
				cont.setVisible(false);
				submit.setVisible(true);
			}
		});

	}

	private void correct() {
		cont.setVisible(true);
		submit.setVisible(false);
		questiontext.setText(question.correct.get(step));
		cont.removeActionListener(cont.getActionListeners()[0]);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 0;
				step++;
				filldata();
				cont.setVisible(false);
				submit.setVisible(true);
			}
		});

	}
	private void end(){
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	private void makeandplacecomponents() {
		home.addActionListener(new ActionListener(){

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
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				if (answer == 0) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					StudentData.student.enter_evidence(new Vertex<String>(
							"Blank1", 2), 0);
					StudentData.student.Roll_over(new Vertex<String>(
							"Understanding", 3), new Vertex<String>(
							"Understanding1", 3), dateFormat.format(date) + ","
									+ 1+  "," + difficulty + "," + step);
				} else {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					StudentData.student.enter_evidence(new Vertex<String>(
							"Blank1", 2), 1);
					StudentData.student.Roll_over(new Vertex<String>(
							"Understanding", 3), new Vertex<String>(
							"Understanding1", 3), dateFormat.format(date) + ","
									+ 1+  "," + difficulty + "," + step);
					if (answer == correct)
						correct();
					else
						incorrect();
				}
			}
		});
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 0;
				step++;
				filldata();
				cont.setVisible(false);
			}
		});
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(d);
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 1;
			}

		});
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 2;
			}

		});
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 3;
			}

		});
		d.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){ browse(); pause();
				answer = 4;
			}

		});
		a.setMargin(new Insets(0,15,0,0));
		b.setMargin(new Insets(0,15,0,0));
		c.setMargin(new Insets(0,15,0,0));
		d.setMargin(new Insets(0,15,0,0));
		questiondata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		questiontext.setFont(new Font("Serif",0,15));
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 12;
		c.gridheight = 12;
		c.ipady = 297;
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
		c.gridy = 14;
		c.weightx = 0.0;
		c.gridwidth = 12;
		this.add(questiontext, c);
		c.gridx = 0;
		c.gridy = 15;		
		c.gridx = 1;		
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(a, c);	
		c.gridx = 0;
		c.gridy = 16;		
		c.gridx = 1;		
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(b, c);
		c.gridx = 0;
		c.gridy = 17;		
		c.gridx = 1;		
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(this.c, c);
		c.gridx = 0;
		c.gridy = 18;		
		c.gridx = 1;		
		c.weightx = 0.0;
		c.gridwidth = 11;
		this.add(d, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridwidth = 4;
		this.add(submit, c);
		this.add(cont, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridwidth = 4;
		this.add(hint, c);
		hint.setVisible(false);
		c.weightx = 1;
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 11;
		c.gridwidth = 1;
		this.add(home, c);

	}

	private void close() {
		showdone();
		double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
		int understanding;
		if(temp[0] > temp[1]){
			if(temp[0] > temp[2])
				understanding = 0;
			else
				understanding = 2;
		}
		else{
			if(temp[1] > temp[2])
				understanding = 1;
			else
				understanding = 2;
		}
		JFrame frame;		
		if(understanding == 0){
			if(difficulty == 0)
				frame = new MultipleChoiceFrame(0);
			else
				frame = new MultipleChoiceFrame(difficulty - 1);				
		}
		else{
			if(difficulty == 2)
				frame = new Instruction(1,0);
			else
				frame = new MultipleChoiceFrame(difficulty + 1);	
		}
		frame.setSize(416,700);
		frame.setVisible(true);
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	private void showdone() {
		String[] ok = {"OK"};
		JOptionPane.showOptionDialog(this, "You have finished this exercise, time to move on to a new one.", "Exercise Complete",
		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
		ok, null);		
	}
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int newx = e.getXOnScreen();
		int newy = e.getYOnScreen();
		xdist += Math.abs(newx - x);
		ydist += Math.abs(newy - y);
		this.x = newx;
		this.y = newy;

	}

	protected void pause() {
		if (System.currentTimeMillis() - current > 10000
				&& System.currentTimeMillis() - current < 15000) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			StudentData.student.enter_evidence(new Vertex<String>("Pause1", 2),
					0);
			StudentData.student.Roll_over(
					new Vertex<String>("Understanding", 3), new Vertex<String>(
							"Understanding1", 3), dateFormat.format(date) + ","
							+ 2 + "," + difficulty + "," + step);
			current = System.currentTimeMillis();
		}

	}

	private void browse() {
		if (xdist > 2000 || ydist > 2000) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			StudentData.student.enter_evidence(
					new Vertex<String>("Browse1", 2), 0);
			StudentData.student.Roll_over(
					new Vertex<String>("Understanding", 3), new Vertex<String>(
							"Understanding1", 3), dateFormat.format(date) + ","
							+ 2 + "," + difficulty + "," + step);
		}
		xdist = ydist = 0;
	}
}
