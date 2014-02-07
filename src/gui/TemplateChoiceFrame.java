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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial")
public class TemplateChoiceFrame extends JFrame {
	protected int showhome() {
		return JOptionPane
				.showConfirmDialog(
						this,
						"If you leave the exercise you will have to start from the beginning when you return",
						"Want to leave?", JOptionPane.OK_CANCEL_OPTION);

	}
	int templatenumber;
	ImagePanel image0 = new ImagePanel(0);
	ImagePanel image1 = new ImagePanel(1);
	ImagePanel image2 = new ImagePanel(2);
	JButton previous = new JButton("Previous");
	JButton next = new JButton("Next");
	JButton cont = new JButton("Continue");
	JButton home = new JButton("HOME");
	JButton nothing = new JButton();
	JTextPane prompt = new JTextPane();
	String author;
	public TemplateChoiceFrame(String author){
		super();
		this.author = author;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);		
		Container c = this.getContentPane();
		c.setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		prompt.setText("Choose a template");
		StyledDocument doc = prompt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		image0.setBackground(Color.WHITE);
		image1.setBackground(Color.WHITE);
		image2.setBackground(Color.WHITE);
		image1.setVisible(false);
		image2.setVisible(false);
		makeandplacecomponents();
	}
	private void end(){
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
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
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 8;
		c.gridheight = 12;
		c.ipady = 304;
		this.add(image0, c);
		this.add(image1, c);
		this.add(image2, c);
		c.ipady = 40;
		c.ipadx = 50;
		c.gridheight = 1;
		c.gridy = 12;
		this.add(prompt,c);		
		c.gridwidth = 2;
		c.gridy = 13;
		c.fill = GridBagConstraints.NONE;
		this.add(previous,c);
		c.gridx = 6;
		this.add(next,c);
		c.gridy = 14;
		c.gridx = 0;
		this.add(cont, c);
		c.gridx = 6;
		this.add(home,c);
		next.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				switch(templatenumber){
				case(0):
					image0.setVisible(false);
					image1.setVisible(true);
					templatenumber++;
					break;
				case(1):
					image1.setVisible(false);
					image2.setVisible(true);
					templatenumber++;
					break;
				case(2):
					image2.setVisible(false);
					image0.setVisible(true);
					templatenumber = 0;
					break;
				}
				
			}
			
		});
		previous.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				switch(templatenumber){
				case(0):
					image0.setVisible(false);
					image2.setVisible(true);
					templatenumber = 2;
					break;
				case(1):
					image1.setVisible(false);
					image0.setVisible(true);
					templatenumber--;
					break;
				case(2):
					image2.setVisible(false);
					image1.setVisible(true);
					templatenumber--;
					break;
				}				
			}
			
		});
		cont.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Creation frame = new Creation(templatenumber, author);
				frame.setSize(416,700);
				close();
				frame.setVisible(true);
				
			}
			
		});
		
		
	}
	private void close(){
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
