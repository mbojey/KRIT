package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import domain.Mode2;
import domain.easyMode2;
import domain.hardMode2;
import domain.medMode2;

@SuppressWarnings("serial")
public class Hiding extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	// Declare components here so that they are accessible in code elsewhere
	ImagePanel questiondiagram;
	JTextPane V1 = new JTextPane();
	JTextPane V2 = new JTextPane();
	JTextPane V3 = new JTextPane();
	JTextPane R1 = new JTextPane();
	JTextPane R2 = new JTextPane();
	JTextPane R3 = new JTextPane();
	JTextPane R4 = new JTextPane();
	JTextPane I1 = new JTextPane();
	JTextPane I2 = new JTextPane();
	JTextPane I3 = new JTextPane();
	JTextPane prompt = new JTextPane();
	JButton submit = new JButton("Submit");
	JCheckBox v1 = new JCheckBox("V1");
	JCheckBox v2 = new JCheckBox("V2");
	JCheckBox v3 = new JCheckBox("V3");
	JCheckBox r1 = new JCheckBox("R1");
	JCheckBox r2 = new JCheckBox("R2");
	JCheckBox r3 = new JCheckBox("R3");
	JCheckBox r4 = new JCheckBox("R4");
	JCheckBox i1 = new JCheckBox("I1");
	JCheckBox i2 = new JCheckBox("I2");
	JCheckBox i3 = new JCheckBox("I3");
	Mode2 question;
	int difficulty;
	String author;
	String[] values;
	JButton home = new JButton("HOME");
	public Hiding(int difficulty, String[] values, String author) {
		super();
		this.values = values;
		this.difficulty = difficulty;
		this.author = author;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(difficulty);
		questiondiagram.setBackground(Color.WHITE);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();	
		filldata(values);
		setlisteners();		
		switch (difficulty) {
		case (0):
			question = new easyMode2();
			setVisibilities(question.exists);
			break;
		case (1):
			question = new medMode2();
			setVisibilities(question.exists);
			break;
		case (2):
			question = new hardMode2();
			setVisibilities(question.exists);
			break;
		}	
	}
	

	private void setlisteners() {
		home.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {

				int home = showhome();
				if (home == JOptionPane.OK_OPTION) {
					Home frame = new Home();
					frame.setSize(416, 700);
					frame.setVisible(true);
					close();
				}
			}
			
		});
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean[] hidden = new Boolean[10];
				for(int i  = 0; i < 10; i++){
					hidden[i] = question.exists[i]; 
				}
				int hiddencount = 0;
				if(v1.isSelected()){
					hidden[0] = false;
					hiddencount++;
				}
				if(v2.isSelected()){
					hidden[1] = false;
					hiddencount++;
				}
				if(v3.isSelected()){
					hidden[2] = false;
					hiddencount++;
				}
				if(r1.isSelected()){
					hidden[3] = false;
					hiddencount++;
				}
				if(r2.isSelected()){
					hidden[4] = false;
					hiddencount++;
				}
				if(r3.isSelected()){
					hidden[5] = false;
					hiddencount++;
				}
				if(r4.isSelected()){
					hidden[6] = false;
					hiddencount++;
				}
				if(i1.isSelected()){
					hidden[7] = false;
					hiddencount++;
				}
				if(i2.isSelected()){
					hidden[8] = false;
					hiddencount++;
				}
				if(i3.isSelected()){
					hidden[9] = false;
					hiddencount++;
				}
				if(hiddencount == 3){
					String filename = "F:/ITS/Questions/Question "+difficulty+1+" by "+author+".txt";
					File questionfile = new File(filename);
					try {
						PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(questionfile)));
						writer.println(difficulty);
						for(int i = 0; i < 10; i++){
							writer.println(values[i].substring(0, values[i].length()-1)+" "+hidden[i]);
						}
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					showcompleteddialog();
					CreateorSolveFrame frame = new CreateorSolveFrame();
					frame.setSize(416, 700);
					close();
					frame.setVisible(true);
				}
				else
					showerrordialog();			
			}
			
		});
		
	}


	protected void showerrordialog() {
		JOptionPane.showMessageDialog(this, "You must hide 3 values.", "Hiding Error", JOptionPane.PLAIN_MESSAGE, null);
	}
	protected void showcompleteddialog() {
		JOptionPane.showMessageDialog(this, "You did it!", "Creation Completed", JOptionPane.PLAIN_MESSAGE, null);
	}


	private void filldata(String[] values) {
		V1.setText("V1=" + values[0]);
		V2.setText("V2=" + values[1]);
		V3.setText("V3=" + values[2]);
		R1.setText("R1=" + values[3]);
		R2.setText("R2=" + values[4]);
		R3.setText("R3=" + values[5]);
		R4.setText("R4=" + values[6]);
		I1.setText("I1=" + values[7]);
		I2.setText("I2=" + values[8]);
		I3.setText("I3=" + values[9]);	
		prompt.setText("Select 3 values to hide");
		StyledDocument doc = prompt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}
	private void setVisibilities(Boolean[] exists) {
		V1.setVisible(exists[0]);
		V2.setVisible(exists[1]);
		V3.setVisible(exists[2]);
		R1.setVisible(exists[3]);
		R2.setVisible(exists[4]);
		R3.setVisible(exists[5]);
		R4.setVisible(exists[6]);
		I1.setVisible(exists[7]);
		I2.setVisible(exists[8]);
		I3.setVisible(exists[9]);
		v1.setVisible(exists[0]);
		v2.setVisible(exists[1]);
		v3.setVisible(exists[2]);
		r1.setVisible(exists[3]);
		r2.setVisible(exists[4]);
		r3.setVisible(exists[5]);
		r4.setVisible(exists[6]);
		i1.setVisible(exists[7]);
		i2.setVisible(exists[8]);
		i3.setVisible(exists[9]);
	}


	private void makeandplacecomponents() {		
		// Place Components in Layout
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
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 13;
		c.weightx = 0.6;
		c.gridwidth = 3;
		this.add(V1, c);
		c.gridx = 3;
		this.add(V2, c);
		c.gridx = 6;
		this.add(V3, c);		
		c.gridx = 0;
		c.gridy = 14;
		this.add(R1, c);
		c.gridx = 3;
		this.add(R2, c);
		c.gridx = 6;
		this.add(R3, c);
		c.gridx = 9;
		this.add(R4, c);
		c.gridy = 15;
		c.gridx = 0;
		this.add(I1, c);
		c.gridx = 3;
		this.add(I2, c);
		c.gridx = 6;
		this.add(I3, c);
		c.gridy = 16;
		c.gridx = 0;
		c.gridwidth = 12;
		this.add(prompt, c);
		c.gridy = 17;
		c.gridx = 0;
		c.gridwidth = 3;
		this.add(v1, c);
		c.gridx = 3;
		this.add(v2, c);
		c.gridx = 6;
		this.add(v3, c);	
		c.gridx = 0;
		c.gridy = 18;
		this.add(r1, c);
		c.gridx = 3;
		this.add(r2, c);
		c.gridx = 6;
		this.add(r3, c);
		c.gridx = 9;
		this.add(r4, c);
		c.gridx = 0;
		c.gridy = 19;
		this.add(i1, c);
		c.gridx = 3;
		this.add(i2, c);
		c.gridx = 6;
		this.add(i3, c);		
		c.gridx = 0;
		c.gridy = 20;
		submit.setSize(new Dimension(104, 55));
		this.add(submit, c);
		c.gridx = 6;
		this.add(home,c);
		
	}	
	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}