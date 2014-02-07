package Instructions;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import student.StudentData;

public class Test {

	public static void main(String[] args) {
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
				InstructionFrame frame9 = new InstructionFrame(9);
				frame9.setSize(704, 762);
				frame9.setVisible(true);
				frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Container c = frame9.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame8 = new InstructionFrame(8);
				frame8.setSize(704, 762);
				frame8.setVisible(true);
				c = frame8.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame7 = new InstructionFrame(7);
				frame7.setSize(704, 762);
				frame7.setVisible(true);
				c = frame7.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame6 = new InstructionFrame(6);
				frame6.setSize(704, 762);
				frame6.setVisible(true);
				c = frame6.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame5 = new InstructionFrame(5);
				frame5.setSize(704, 762);
				frame5.setVisible(true);
				c = frame5.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame4 = new InstructionFrame(4);
				frame4.setSize(704, 762);
				frame4.setVisible(true);
				c = frame4.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame3 = new InstructionFrame(3);
				frame3.setSize(704, 762);
				frame3.setVisible(true);
				c = frame3.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame2 = new InstructionFrame(2);
				frame2.setSize(704, 762);
				frame2.setVisible(true);
				c = frame2.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame1 = new InstructionFrame(1);
				frame1.setSize(704, 762);
				frame1.setVisible(true);
				c = frame1.getContentPane();
				c.setBackground(Color.WHITE);
				InstructionFrame frame = new InstructionFrame(0);
				frame.setSize(704, 762);
				frame.setVisible(true);				
				c = frame.getContentPane();
				c.setBackground(Color.WHITE);
			
				
				
				
				
				
			
			}

		});

	}
}
