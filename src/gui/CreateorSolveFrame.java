package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateorSolveFrame extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	JButton create;
	JButton solve;
	JButton home;
	JTextField prompt;
	JTextField input;

	public CreateorSolveFrame() {
		super();
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher (new MyDispatcher());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		initComponents();
		setListenters();
		prompt.setFocusable(false);
	}

	private void end(){
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
	private void setListenters() {
		home.addActionListener(new ActionListener(){

			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int home = showhome();
				if (home == JOptionPane.OK_OPTION) {
					Home frame = new Home();
					frame.setSize(416, 700);
					frame.setVisible(true);
					end();
				}
			}
		});
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!input.getText().equals("")) {
					TemplateChoiceFrame frame = new TemplateChoiceFrame(input
							.getText());
					frame.setSize(416, 700);
					close();
					frame.setVisible(true);
				}
			}
		});
		solve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!input.getText().equals("")) {
					QuestionChoiceFrame frame = new QuestionChoiceFrame(0);
					frame.setSize(416, 700);
					close();
					frame.setVisible(true);
				}
			}
		});

	}

	private void close() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	private void initComponents() {

		solve = new javax.swing.JButton();
		create = new javax.swing.JButton();
		prompt = new javax.swing.JTextField();
		input = new javax.swing.JTextField();
		home = new javax.swing.JButton();
		prompt.setBorder(null);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(416, 700));

		solve.setText("Solve a Problem");

		create.setText("Create  a Problem");

		prompt.setText("Enter your nickname:");

		home.setText("HOME");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		prompt,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		input))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		solve,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		130,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		34,
																		Short.MAX_VALUE)
																.addComponent(
																		create,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		130,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(67, 67, 67))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(home,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										104,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(252, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														prompt,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														input,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(86, 86, 86)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														solve,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														39,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														create,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														39,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(251, 251, 251)
								.addComponent(home,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										41,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));

		pack();
	}// </editor-fold>

}
