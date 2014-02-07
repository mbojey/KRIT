package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import student.StudentData;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				StudentData student = new StudentData();
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// JFrame background = new JFrame();
				Container c;// = background.getContentPane();
				// background.setSize(2000,2000);
				// c.setBackground(Color.BLACK);
				// background.setVisible(true);
				// MultipleChoiceFrame frame = new MultipleChoiceFrame(0);
				InputFrame frame = new InputFrame(0);
				// Creation frame = new Creation(2);
				// Hiding frame = new Hiding(0);
				// TemplateChoiceFrame frame = new TemplateChoiceFrame();
				// JunctionChoice frame = new JunctionChoice(2);
				//CreateorSolveFrame frame = new CreateorSolveFrame();
				// mode3 frame = new mode3(0);
				//logger.entry();
				//Home frame = new Home();
				c = frame.getContentPane();
				c.setBackground(Color.WHITE);
				frame.setSize(416, 700);
				frame.setVisible(true);
			}
		});
	}

}
