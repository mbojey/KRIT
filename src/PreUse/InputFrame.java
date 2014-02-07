package PreUse;

import inferenceTools.Vertex;
import inferenceTools.logger;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import student.StudentData;

@SuppressWarnings("serial")
public class InputFrame extends JFrame {
	// Declare components here so that they are accessible in code elsewhere
	ImagePanel questiondiagram;
	JTextPane questiondata = new JTextPane();
	JButton hint = new JButton("Hint");
	JButton retry = new JButton("Retry");
	JButton submit = new JButton("Submit");
	JButton cont = new JButton("Continue");
	JTextPane questiontext = new JTextPane();
	final JTextPane input = new JTextPane();
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
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton times = new JButton("*");
	JButton divide = new JButton("/");
	JButton equals = new JButton("=");
	JButton point = new JButton(".");
	JButton volts = new JButton("V");
	JButton amps = new JButton("A");
	JButton ohms = new JButton("Ω");
	JButton i1 = new JButton("I1");
	JButton i2 = new JButton("I2");
	JButton i3 = new JButton("I3");
	JButton del = new JButton("DEL");
	JButton clear = new JButton("CLEAR");
	int step = 0;
	Mode2 question;
	String hinttext = "";
	String explanation = "";
	JButton home = new JButton("SKIP");
	int difficulty;

	public InputFrame(int difficulty) {
		super();
		this.difficulty = difficulty;
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		questiondiagram = new ImagePanel(difficulty);
		questiondiagram.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		// Activate and Place Swing Components
		makeandplacecomponents();
		switch (difficulty) {
		case (0):
			question = new easyMode2();
			filldata();
			break;
		}
	}

	private void filldata() {
		if(step >= question.answers.size()){
			close();
			return;
		}
		submit.setVisible(true);
		input.setText("");
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
		doc = input.getStyledDocument();
		center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		hinttext = question.hints.get(step);
		explanation = question.answers.get(step);
		hint.setVisible(false);
		retry.setVisible(false);
		cont.setVisible(false);
	}

	private void makeandplacecomponents() {
		// set listeners and attributes of components
		questiondata.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,
				Color.BLACK));
		questiontext.setFont(new Font("Serif", 0, 15));
		hint.setVisible(false);
		retry.setVisible(false);
		cont.setVisible(false);
		input.setEditable(false);
		home.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.entry(System.currentTimeMillis() + "," + -1 + "," + difficulty );
				@SuppressWarnings("unused")
				StudentData student = new StudentData();
				StudentData.student.enter_evidence(new Vertex<String>("Numerically Correct1", 2),1);
				StudentData.student.enter_evidence(new Vertex<String>("Voltages Total Zero1", 2),1);
				StudentData.student.enter_evidence(new Vertex<String>("Currents Balanced1", 2),1);
				StudentData.student.Roll_over(new Vertex<String>(
						"Understanding", 3), new Vertex<String>(
						"Understanding1", 3));
				step++;
				filldata();
				cont.setVisible(false);
				input.setText("");
			}
			
		});
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String answer = input.getText();
				if (answer.equals("")) {
				} else {
					
					if (question.verifyanswer(step, answer))
						correct();
					else
						incorrect();
				}
			}
		});
		zero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "0");
			}
		});
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "1");
			}
		});
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "2");
			}
		});
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "3");
			}
		});
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "4");
			}
		});
		five.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "5");
			}
		});
		six.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "6");
			}
		});
		seven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "7");
			}
		});
		eight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "8");
			}
		});
		nine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "9");
			}
		});
		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "+");
			}
		});
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "-");
			}
		});
		times.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "*");
			}
		});
		divide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "/");
			}
		});
		equals.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + "=");
			}
		});
		point.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String soFar = input.getText();
				input.setText(soFar + ".");
			}
		});
		volts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& Character.isDigit(previous.charAt(previous
									.length() - 1))) {
						String soFar = input.getText();
						input.setText(soFar + "V");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "V");
				}
			}
		});
		amps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& Character.isDigit(previous.charAt(previous
									.length() - 1))) {
						String soFar = input.getText();
						input.setText(soFar + "A");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "A");
				}
			}
		});
		ohms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& Character.isDigit(previous.charAt(previous
									.length() - 1))) {
						String soFar = input.getText();
						input.setText(soFar + "Ω");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "Ω");
				}
			}
		});
		i1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& !Character.isLetter(previous.charAt(previous
									.length() - 1))
							&& previous.charAt(previous.length() - 1) != 'Ω') {
						String soFar = input.getText();
						input.setText(soFar + "I1");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "I1");
				}
			}
		});
		i2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& !Character.isLetter(previous.charAt(previous
									.length() - 1))
							&& previous.charAt(previous.length() - 1) != 'Ω') {
						String soFar = input.getText();
						input.setText(soFar + "I2");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "I2");
				}
			}
		});
		i3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) != 'I'
							&& !Character.isLetter(previous.charAt(previous
									.length() - 1))
							&& previous.charAt(previous.length() - 1) != 'Ω') {
						String soFar = input.getText();
						input.setText(soFar + "I3");
					}
				} catch (StringIndexOutOfBoundsException ex) {
					String soFar = input.getText();
					input.setText(soFar + "I3");
				}
			}
		});
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String previous = input.getText();
					if (previous.charAt(previous.length() - 2) == 'I')
						input.setText(previous.substring(0,
								previous.length() - 2));
					else
						input.setText(previous.substring(0,
								previous.length() - 1));
				} catch (StringIndexOutOfBoundsException ex) {
					try {
						String previous = input.getText();
						input.setText(previous.substring(0,
								previous.length() - 1));
					} catch (StringIndexOutOfBoundsException exc) {

					}
				}
				
					
			}
		});
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filldata();
				
			}
		});
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				step++;
				filldata();
				cont.setVisible(false);
				input.setText("");
			}
		});
		// Place Components in Layout
		clear.setMargin(null);
		clear.setBorder(null);
		del.setMargin(null);
		del.setBorder(null);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 12;
		c.gridheight = 12;
		c.ipady = 304;
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
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.weightx = 0.0;
		c.gridwidth = 12;
		this.add(input, c);
		c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridwidth = 2;
		this.add(seven, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		this.add(eight, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		this.add(nine, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 6;
		this.add(plus, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		this.add(del, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 10;
		this.add(clear, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		this.add(four, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		this.add(five, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		this.add(six, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 6;
		this.add(minus, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		this.add(ohms, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 10;
		this.add(i1, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		this.add(three, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		this.add(two, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		this.add(one, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 6;
		this.add(times, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		this.add(volts, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 10;
		this.add(i2, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		this.add(zero, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		this.add(point, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		this.add(equals, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 6;
		this.add(divide, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		this.add(amps, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 10;
		this.add(i3, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = GridBagConstraints.RELATIVE;
		c.gridwidth = 4;
		this.add(submit, c);
		this.add(cont, c);
		this.add(retry, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridwidth = 4;
		this.add(hint, c);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 8;
		c.gridwidth = 4;
		this.add(home, c);

	}

	private void incorrect() {
		logger.entry(System.currentTimeMillis() + "," + -1 + "," + difficulty + "," + questiondata.getText().replace('\n', ',') +"," );
		submit.setVisible(false);
		cont.setVisible(true);
		cont.removeActionListener(cont.getActionListeners()[0]);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				step++;
				filldata();
				cont.setVisible(false);
				input.setText("");
			}
		});
		

	}

	private void correct() {
		logger.entry(System.currentTimeMillis() + "," + -1 + "," + difficulty + "," + questiondata.getText().replace('\n', ',') +"," );
		submit.setVisible(false);
		cont.setVisible(true);
		cont.removeActionListener(cont.getActionListeners()[0]);
		cont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				step++;
				filldata();
				cont.setVisible(false);
				input.setText("");
			}
		});
	}
	private void close() {
		Container c;
		gui.InputFrame frame = new gui.InputFrame(0);
		frame.setSize(416, 780);
		frame.setVisible(true);	
		c = frame.getContentPane();
		c.setBackground(Color.WHITE);		
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}