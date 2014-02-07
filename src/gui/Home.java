package gui;

import inferenceTools.Vertex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import student.StudentData;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private javax.swing.JButton Mode1;
	private javax.swing.JButton Mode2;
	private javax.swing.JButton Mode3;
	private javax.swing.JButton Mode4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextPane welcometext;

	public Home() {
		super();
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		initComponents();
		setListeners();
		welcometext.setText("Welcome the the Kirchhoff's Rules Intelligent Tutor!  Select a mode to begin!");
	}

	private void setListeners() {
		Mode1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
				int difficulty;
				if(temp[0] > temp[1]){
					if(temp[0] > temp[2])
						difficulty = 0;
					else
						difficulty = 2;
				}
				else{
					if(temp[1] > temp[2])
						difficulty = 1;
					else
						difficulty = 2;
				}
				Instruction frame = new Instruction(0,difficulty);
				frame.setSize(416,700);
				frame.setVisible(true);
				close();
			}			
		});
		Mode2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
				int difficulty;
				if(temp[0] > temp[1]){
					if(temp[0] > temp[2])
						difficulty = 0;
					else
						difficulty = 2;
				}
				else{
					if(temp[1] > temp[2])
						difficulty = 1;
					else
						difficulty = 2;
				}
				Instruction frame = new Instruction(1,difficulty);
				frame.setSize(416,700);
				frame.setVisible(true);	
				close();
			}			
		});
		Mode3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
				int difficulty;
				if(temp[0] > temp[1]){
					if(temp[0] > temp[2])
						difficulty = 0;
					else
						difficulty = 2;
				}
				else{
					if(temp[1] > temp[2])
						difficulty = 1;
					else
						difficulty = 2;
				}
				Instruction frame = new Instruction(2,difficulty);
				frame.setSize(416,700);
				frame.setVisible(true);	
				close();
			}			
		});
		Mode4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {				
				Instruction frame = new Instruction(3,0);
				frame.setSize(416,700);
				frame.setVisible(true);		
				close();
			}			
		});		
	}
	private void initComponents() {
		jScrollPane1 = new javax.swing.JScrollPane();
		welcometext = new javax.swing.JTextPane();
		Mode1 = new javax.swing.JButton();
		Mode2 = new javax.swing.JButton();
		Mode3 = new javax.swing.JButton();
		Mode4 = new javax.swing.JButton();
		jScrollPane1.setBorder(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jScrollPane1.setViewportView(welcometext);

		Mode1.setText("1:Multiple Choice");

		Mode2.setText("2:Guided Exercises");

		Mode3.setText("3:Customizable Exercises");

		Mode4.setText("4:Create Your Own Exercise");

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
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														357,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				false)
																				.addComponent(
																						Mode1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						Mode3,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						Mode2,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						Mode4,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						149,
																						Short.MAX_VALUE))))
								.addContainerGap(29, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										127,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(100, 100, 100)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														Mode1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														48,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														Mode2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														48,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(67, 67, 67)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														Mode3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														48,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														Mode4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														48,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(291, Short.MAX_VALUE)));

		pack();
	}
	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
