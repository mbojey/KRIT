package Instructions;

import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import student.StudentData;

public class StartofEverything {

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
				Container c;
				InstructionFrame frame = new InstructionFrame(0);
				frame.setSize(704, 780);
				frame.setVisible(true);				
				c = frame.getContentPane();
				c.setBackground(Color.WHITE);		
			}
		});

	}
}
