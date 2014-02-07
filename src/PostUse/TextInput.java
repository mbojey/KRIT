package PostUse;

import inferenceTools.logger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class TextInput extends JFrame {
	int subject = 01;
	JTextPane question = new JTextPane();
	JButton submit = new JButton("Submit");
	JTextPane input = new JTextPane();
	static String userHomeFolder = System.getProperty("user.home");
	static File file = new File(userHomeFolder, "KRIT_data.csv");	PrintWriter writer;
	int answer;
	int questionnumber = 0;
	public boolean done = false;
	String[] questions = {"What did you like about KRIT?",
			"What are some suggestions you have for improving KRIT?",
			"Did KRIT change your attitude towards or confidence in solving circuit problems?   If so, how?",
			"Please provide additional comments you have about KRIT or your experience in this project.",
			"You're done! Thank you for your participation, you may now send in the file titled \"KRIT_data.csv\"  If you are a PC user"
			+ "it will be on your desktop, if you are using a Mac is will be in base directory of your user profile, the one you see when"
			+ "you open the Finder."};

	public TextInput() {
		super();
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file,
					true)));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		setLayout(new GridBagLayout());
		makeandplacecomponents();
		this.question.setText(questions[0]);
		question.setEditable(false);
	}

	private void makeandplacecomponents() {
		StyledDocument doc = question.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		doc = input.getStyledDocument();
		center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(input.getText());
				questionnumber++;
				input.setText("");
				if (questionnumber == questions.length)
					close();
				else if(questionnumber == questions.length -1){
					input.setVisible(false);
					submit.setVisible(false);
					question.setText(questions[questionnumber]);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					logger.entry(dateFormat.format(date));
					writer.close();
				}					
				else
					question.setText(questions[questionnumber]);
			}

		});
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 12;
		this.add(question, c);
		c.gridy = 1;
		this.add(input,c);
		c.gridy = 6;
		c.gridwidth = 4;
		this.add(submit, c);		
	}

	private void close() {
		writer.close();
		System.out.println(System.currentTimeMillis());
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
