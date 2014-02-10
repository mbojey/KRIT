package gui;

import inferenceTools.Vertex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import student.StudentData;

import domain.Mode2;
import domain.easyMode2;
import domain.hardMode2;
import domain.medMode2;

@SuppressWarnings("serial")
public class SolvingFrame extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	int focus;
	int difficulty;
	float[] values = new float[10];
	boolean[] visible = new boolean[10];
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
	JTextPane input1 = new JTextPane();
	JTextPane input2 = new JTextPane();
	JTextPane input3 = new JTextPane();
	JTextPane input4 = new JTextPane();
	JTextPane input5 = new JTextPane();
	JTextPane input6 = new JTextPane();
	JTextPane input7 = new JTextPane();
	JTextPane input8 = new JTextPane();
	JTextPane input9 = new JTextPane();
	JTextPane input10 = new JTextPane();
	JTextPane prompt = new JTextPane();
	JButton submit = new JButton("Submit");
	JButton point = new JButton(".");
	JButton zero = new JButton("0");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton minus = new JButton("-");
	JButton del = new JButton("DEL");
	JButton clear = new JButton("CLEAR");
	JButton home = new JButton("HOME");
	JButton volts = new JButton("V");
	JButton ohms = new JButton("½");
	JButton amps = new JButton("A");
	private Vertex<String> numcor = new Vertex<String>("Numerically Correct1",
			2);
	private Vertex<String> voltages = new Vertex<String>(
			"Voltages Total Zero1", 2);
	private Vertex<String> currents = new Vertex<String>("Currents Balanced1",
			2);
	private Vertex<String> sign = new Vertex<String>(
			"Sign Convention Correct1", 3);
	private Vertex<String> units = new Vertex<String>("Units Correct1", 3);

	public SolvingFrame(String filename) throws FileNotFoundException {
		super();
		File questionfile = new File(filename);
		Scanner scan = new Scanner(questionfile);
		difficulty = scan.nextInt();
		int i = 0;
		while (scan.hasNextFloat()) {
			values[i] = scan.nextFloat();
			visible[i] = scan.nextBoolean();
			i++;
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(difficulty);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		questiondiagram.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();
		filldata();
		Mode2 question;
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

	private void setVisibilities(Boolean[] exists) {
		V1.setVisible(exists[0]);
		input1.setVisible(exists[0] && !visible[0]);
		V2.setVisible(exists[1]);
		input2.setVisible(exists[1] && !visible[1]);
		V3.setVisible(exists[2]);
		input3.setVisible(exists[2] && !visible[2]);
		R1.setVisible(exists[3]);
		input4.setVisible(exists[3] && !visible[3]);
		R2.setVisible(exists[4]);
		input5.setVisible(exists[4] && !visible[4]);
		R3.setVisible(exists[5]);
		input6.setVisible(exists[5] && !visible[5]);
		R4.setVisible(exists[6]);
		input7.setVisible(exists[6] && !visible[6]);
		I1.setVisible(exists[7]);
		input8.setVisible(exists[7] && !visible[7]);
		I2.setVisible(exists[8]);
		input9.setVisible(exists[8] && !visible[8]);
		I3.setVisible(exists[9]);
		input10.setVisible(exists[9] && !visible[9]);
	}

	private void filldata() {
		if (visible[0])
			V1.setText("V1=" + values[0] + "V");
		else
			V1.setText("V1=");
		if (visible[1])
			V2.setText("V2=" + values[1] + "V");
		else
			V2.setText("V2=");
		if (visible[2])
			V3.setText("V3=" + values[2] + "V");
		else
			V3.setText("V3=");
		if (visible[3])
			R1.setText("R1=" + values[3] + "½");
		else
			R1.setText("R1=");
		if (visible[4])
			R2.setText("R2=" + values[4] + "½");
		else
			R2.setText("R2=");
		if (visible[5])
			R3.setText("R3=" + values[5] + "½");
		else
			R3.setText("R3=");
		if (visible[6])
			R4.setText("R4=" + values[6] + "½");
		else
			R4.setText("R4=");
		if (visible[7])
			I1.setText("I1=" + values[7] + "A");
		else
			I1.setText("I1=");
		if (visible[8])
			I2.setText("I2=" + values[8] + "A");
		else
			I2.setText("I2=");
		if (visible[9])
			I3.setText("I3=" + values[9] + "A");
		else
			I3.setText("I3=");

		prompt.setText("Fill in the blanks");
		StyledDocument doc = prompt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	private void makeandplacecomponents() {
		// set listeners and attributes of components
		setListeners();
		// Place Components in Layout
		clear.setBorder(null);
		clear.setMargin(new Insets(0, 0, 0, 0));
		submit.setBorder(null);
		submit.setMargin(new Insets(100, 0, 10, 0));
		home.setBorder(null);
		home.setMargin(new Insets(10, 0, 10, 0));
		del.setBorder(null);
		del.setMargin(new Insets(0, 0, 0, 0));
		input1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		input10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		prompt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
				Color.BLACK));
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 8;
		c.gridheight = 12;
		c.ipady = 304;
		this.add(questiondiagram, c);
		c.ipady = 0;
		c.gridheight = 1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 13;
		this.add(prompt, c);
		c.gridy = 14;
		c.weightx = 0.6;
		c.gridwidth = 1;
		this.add(V1, c);
		c.gridx = 1;
		this.add(input1, c);
		c.gridx = 2;
		this.add(V2, c);
		c.gridx = 3;
		this.add(input2, c);
		c.gridx = 4;
		this.add(V3, c);
		c.gridx = 5;
		this.add(input3, c);
		c.gridx = 0;
		c.gridy = 15;
		this.add(R1, c);
		c.gridx = 1;
		this.add(input4, c);
		c.gridx = 2;
		this.add(R2, c);
		c.gridx = 3;
		this.add(input5, c);
		c.gridx = 4;
		this.add(R3, c);
		c.gridx = 5;
		this.add(input6, c);
		c.gridx = 6;
		this.add(R4, c);
		c.gridx = 7;
		this.add(input7, c);
		c.gridx = 0;
		c.gridy = 16;
		this.add(I1, c);
		c.gridx = 1;
		this.add(input8, c);
		c.gridx = 2;
		this.add(I2, c);
		c.gridx = 3;
		this.add(input9, c);
		c.gridx = 4;
		this.add(I3, c);
		c.gridx = 5;
		this.add(input10, c);
		c.gridy = 17;
		c.gridwidth = 2;
		c.gridx = 0;
		this.add(seven, c);
		c.gridx = 2;
		this.add(eight, c);
		c.gridx = 4;
		this.add(nine, c);
		c.gridx = 6;
		this.add(volts, c);
		c.gridx = 0;
		c.gridy = 18;
		this.add(six, c);
		c.gridx = 2;
		this.add(five, c);
		c.gridx = 4;
		this.add(four, c);
		c.gridx = 6;
		this.add(amps, c);
		c.gridx = 0;
		c.gridy = 19;
		this.add(three, c);
		c.gridx = 2;
		this.add(two, c);
		c.gridx = 4;
		this.add(one, c);
		c.gridx = 6;
		this.add(ohms, c);
		c.gridx = 0;
		c.gridy = 20;
		this.add(zero, c);
		c.gridx = 2;
		this.add(point, c);
		c.gridx = 4;
		this.add(minus, c);
		c.gridx = 6;
		this.add(del, c);
		c.gridx = 0;
		c.gridy = 21;
		this.add(submit, c);
		c.gridx = 4;
		this.add(clear, c);
		c.gridx = 6;
		this.add(home, c);
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
		nine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "9");
				}
			}
		});
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "-");
				}
			}
		});
		eight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "8");
				}
			}
		});
		seven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "7");
				}
			}
		});
		six.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "6");
				}
			}
		});
		five.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "5");
				}
			}
		});
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "4");
				}
			}
		});
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "3");
				}
			}
		});
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "2");
				}
			}
		});
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "1");
				}
			}
		});
		zero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "0");
				}
			}
		});
		point.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + ".");
				}
			}
		});
		volts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "V");
				}
			}
		});
		amps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "A");
				}
			}
		});
		ohms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input + "½");
				}
			}
		});
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextPane focused = findFocused();
				if (focused != null) {
					String input = focused.getText();
					focused.setText(input.substring(0, input.length() - 1));
				}
			}
		});
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				input1.setText("");
				input2.setText("");
				input3.setText("");
				input4.setText("");
				input5.setText("");
				input6.setText("");
				input7.setText("");
				input8.setText("");
				input9.setText("");
				input10.setText("");

			}

		});
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (verifyanswer()) {
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					StudentData.student.enter_evidence(numcor, 0);
					StudentData.student.enter_evidence(voltages, 0);
					StudentData.student.enter_evidence(currents, 0);
					StudentData.student.enter_evidence(sign, 0);
					StudentData.student.enter_evidence(units, 0);
					StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
							new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 4);
					showcompleteddialog();
					CreateorSolveFrame frame = new CreateorSolveFrame();
					frame.setSize(416, 700);
					close();
					frame.setVisible(true);
				}
				else{
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					StudentData.student.enter_evidence(numcor, 1);
					StudentData.student.enter_evidence(voltages, 1);
					StudentData.student.enter_evidence(currents, 1);
					StudentData.student.enter_evidence(sign, 2);
					StudentData.student.enter_evidence(units, 2);
					StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
							new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 4);
				}

			}

		});
		input1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 1;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 2;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 3;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input4.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 4;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input5.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 5;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input6.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 6;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input7.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 7;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input8.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 8;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input9.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 9;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
		input10.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				focus = 10;
			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});
	}

	protected boolean verifyanswer() {
		String[] input = { input1.getText(), input2.getText(),
				input3.getText(), input4.getText(), input5.getText(),
				input6.getText(), input7.getText(), input8.getText(),
				input9.getText(), input10.getText() };
		boolean result = true;
		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals("")) {
				if (Math.abs(Float.parseFloat(input[i].substring(0,
						input[i].length() - 1))
						- values[i]) < 0.01) {
					if (i < 3 && input[i].endsWith("V"))
						result &= true;
					else if (i > 2 && i < 7 && input[i].endsWith("½"))
						result &= true;
					else if (i > 6 && input[i].endsWith("A"))
						result &= true;
					else
						result = false;
				} else
					result = false;
			}
		}
		return result;
	}

	private JTextPane findFocused() {
		if (focus == 1)
			return input1;
		if (focus == 2)
			return input2;
		if (focus == 3)
			return input3;
		if (focus == 4)
			return input4;
		if (focus == 5)
			return input5;
		if (focus == 6)
			return input6;
		if (focus == 7)
			return input7;
		if (focus == 8)
			return input8;
		if (focus == 9)
			return input9;
		if (focus == 10)
			return input10;
		return null;
	}

	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	protected void showcompleteddialog() {
		JOptionPane.showMessageDialog(this, "You did it!", "Completed",
				JOptionPane.PLAIN_MESSAGE, null);
	}
}
