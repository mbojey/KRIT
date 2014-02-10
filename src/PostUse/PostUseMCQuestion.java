package PostUse;

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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PostUseMCQuestion extends JFrame {
	int subject = 01;
	JTextPane question = new JTextPane();
	JButton submit = new JButton("Submit");
	JRadioButton a = new JRadioButton("1 - Strongly Disagree");
	JRadioButton b = new JRadioButton("2 - Disagree");
	JRadioButton c = new JRadioButton("3 - Neutral");
	JRadioButton d = new JRadioButton("4 - Agree");
	JRadioButton e = new JRadioButton("5 - Strongly Agree");
	JRadioButton f = new JRadioButton("6");
	JRadioButton g = new JRadioButton("7 - Very true");
	ButtonGroup group = new ButtonGroup();
	static String userHomeFolder = System.getProperty("user.home");
	static File file = new File(userHomeFolder, "KRIT_data.csv");
	PrintWriter writer;
	int answer;
	int questionnumber = 0;
	int place;
	public boolean done = false;
	String[] first = {"For each of the following statements, please indicate how true it is for you using the following scale:\n"+
		"1\tNot at all true\n2\n3\n4\tSomewhat true\n5\n6\n7\tVery true\n"+"“The task” in the statements below refers to the exercises in KRIT",
			"While I was working on the task, I was thinking about how much I enjoyed it.",
			"I did not feel at all nervous about doing the task.",
			"I felt that it was my choice to do the task.",
			"I think I am pretty good at the task.",
			"I found the task very interesting.",
			"I felt tense while doing the task.",
			"I think I did pretty at the task, compared to other students.",
			"Doing the task was fun.",
			"I felt relaxed while doing the task.",
			"I enjoyed doing the task very much.",
			"I didn’t really have a choice about doing the task.",
			"I am satisfied with my performance at the task.",
			"I was anxious while doing the task.",
			"I thought the task was very boring.",
			"I felt like I was doing what I wanted to do while I was working on the task.",
			"I felt pretty skilled at the task.",
			"I thought the task was very interesting.",
			"I felt pressured while doing the task.",
			"I felt like I had to do the task.",
			"I would describe the task as very enjoyable.",
			"I did the task because I had no choice.",
			"After working at this task for awhile, I felt pretty competent." };
	String[] second = {"Below are a number of statements that may or may not describe your beliefs about learning physics. You are asked to rate each statement by selecting a number between 1 and 5 where the numbers mean the following:"+
		"\n1\tStrongly Disagree\n2\tDisagree\n3\tNeutral\n4\tAgree\n5\tStrongly Agree\nChoose one of the above five choices that best expresses your feeling about the statement. If you don't understand a statement, leave it blank. If you have no strong opinion, choose 3.",
			"If I get stuck on a physics problem on my first try, I usually try to figure out a different way that works.",
			"Nearly everyone is capable of understanding physics if they work at it.",
			"I can usually figure out a way to solve physics problems.",
			"If I get stuck on a physics problem, there is no chance I'll figure it out on my own."
};
	String[] last = {"Please indicate how much you agree with each of the statement below using the following scale:"+
		"\n1\tStrongly Disagree\n2\tDisagree\n3\tNeutral\n4\tAgree\n5\tStrongly Agree\nFor each question below, please select the most appropriate answer.",
			"Solving the problems in the previous questions was easy.",
			"These types of circuit problems seem easier now that I’ve used the app.",
			"Using the app has increased my confidence in my ability to solve these problems.",
			"When I first used the app, it was easy enough to learn it and figure out how to use it.",
			"I found the app very easy to use.", "I found the app fun to use.",
			"I would use the app to help study for Physics.",
			"I would recommend it to my friends to use the app." };

	public PostUseMCQuestion(int place) {
		super();
		this.place = place;
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file,
					true)));
			writer.println("Start of Post-use Data");
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		setLayout(new GridBagLayout());
		makeandplacecomponents();
		if (place == 0)
			this.question.setText(first[0]);
		if (place == 1)
			this.question.setText(second[0]);
		if(place == 2)
			this.question.setText(last[0]);
	}

	private void makeandplacecomponents() {		
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(d);
		group.add(e);
		group.add(f);
		group.add(g);
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 1;
			}

		});
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 2;
			}

		});
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 3;
			}

		});
		d.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 4;
			}

		});
		e.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 5;
			}

		});
		f.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 6;
			}

		});
		g.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer = 7;
			}

		});
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				writer.println(answer);
				answer = 0;
				questionnumber++;
				if (place == 0) {
					a.setVisible(true);
					a.setText("1 - Not at all true");
					b.setVisible(true);
					b.setText("2");
					c.setVisible(true);
					c.setText("3");
					d.setVisible(true);
					d.setText("4 - Somewhat true");
					e.setVisible(true);
					e.setText("5");
					f.setVisible(true);
					g.setVisible(true);
					submit.setText("Submit");
					if (questionnumber == first.length)
						close();
					else {
						question.setText(first[questionnumber]);
						group.clearSelection();
					}
				} else if (place == 1) {
					a.setVisible(true);
					b.setVisible(true);
					c.setVisible(true);
					d.setVisible(true);
					e.setVisible(true);					
					submit.setText("Submit");
					if (questionnumber == second.length)
						close();
					else {
						question.setText(second[questionnumber]);
						group.clearSelection();
					}
				} else if (questionnumber == last.length)
					close();
				else {
					a.setVisible(true);
					b.setVisible(true);
					c.setVisible(true);
					d.setVisible(true);
					e.setVisible(true);
					submit.setText("Submit");
					question.setText(last[questionnumber]);
					group.clearSelection();
				}
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
		this.add(a, c);
		c.gridy = 2;
		this.add(b, c);
		c.gridy = 3;
		this.add(this.c, c);
		c.gridy = 4;
		this.add(d, c);
		c.gridy = 5;
		this.add(e, c);
		if (place == 0) {
			c.gridy = 6;
			this.add(f, c);
			c.gridy = 7;
			this.add(g, c);
			c.gridy = 8;
			c.gridwidth = 4;
			this.add(submit, c);
		} else {
			c.gridy = 6;
			c.gridwidth = 4;
			this.add(submit, c);
		}
		if(questionnumber == 0){
			a.setVisible(false);
			b.setVisible(false);
			this.c.setVisible(false);
			d.setVisible(false);
			e.setVisible(false);
			f.setVisible(false);
			g.setVisible(false);
			submit.setText("Continue");
		}
	}

	private void close() {
		writer.close();
		if(place == 0){
			JFrame background = new JFrame();
			Container c = background.getContentPane();
			PostUseMCQuestion frame2 = new PostUseMCQuestion(1);				
			frame2.setSize(416, 300);
			frame2.setVisible(true);	
			c = this.getContentPane();
			c.setBackground(Color.WHITE);
		}else if (place == 1){
			JFrame background = new JFrame();
			Container c = background.getContentPane();
			PostUseMCQuestion frame2 = new PostUseMCQuestion(2);				
			frame2.setSize(416, 300);
			frame2.setVisible(true);	
			c = this.getContentPane();
			c.setBackground(Color.WHITE);
		}
		else{
			PostUseInputFrame frame1 = new PostUseInputFrame(0);
			frame1.setSize(416, 700);
			frame1.setVisible(true);
		}
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
