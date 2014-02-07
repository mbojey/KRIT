package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Instruction extends JFrame {

	private javax.swing.JButton cont;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextPane welcometext;
	int mode;
	int difficulty;

	public Instruction(int mode, int difficulty) {
		super();
		this.mode = mode;
		this.difficulty = difficulty;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		initComponents();
		setListeners();
		filltext();
	}

	private void filltext() {
		switch(mode){
		case(0):
			welcometext.setText("In this mode you will be presented with an exercise and will select the best answer to each step in solving that question from the list given.");
			break;
		case(1):
			welcometext.setText("In this mode you will be presented with a question and will enter the answer to the question asked at each step.");
			break;
		case(2):
			welcometext.setText("In this mode you will be presented with a question and will be able to choose what steps to take to solve the question.");
			break;
		case(3):
			welcometext.setText("In this mode you have two options.  You can view questions created by your classmates or you can create your own questions to share.");
			break;
		}
		
	}

	private void setListeners() {
		cont.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = null;
				switch(mode){
				case(0):
					frame = new MultipleChoiceFrame(difficulty);
					frame.setSize(416,700);
					frame.setVisible(true);
					break;
				case(1):
					frame = new InputFrame(difficulty);
					frame.setSize(416,700);
					frame.setVisible(true);
					break;
				case(2):
					frame = new mode3(difficulty);
					frame.setSize(416,700);
					frame.setVisible(false);
					break;
				case(3):
					frame = new CreateorSolveFrame();
					frame.setSize(416,700);
					frame.setVisible(true);
					break;
				}
				close();
				
			}
			
		});
		
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		welcometext = new javax.swing.JTextPane();
		cont = new javax.swing.JButton();
		jScrollPane1.setBorder(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jScrollPane1.setViewportView(welcometext);

		cont.setText("Continue");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														cont,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														149,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														356,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(30, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										378, Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(cont,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(244, 244, 244)));

		pack();
	}
	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
