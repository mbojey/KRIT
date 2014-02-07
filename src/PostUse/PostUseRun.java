package PostUse;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import student.StudentData;

public class PostUseRun {	

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
				JFrame background = new JFrame();
				Container c = background.getContentPane();
				background.setSize(2000, 2000);
				c.setBackground(Color.BLACK);
				PostUse.PostUseMCQuestion frame = new PostUse.PostUseMCQuestion(0);				
				frame.setSize(416, 300);				
				frame.setVisible(true);
			}
		});
	}

	

}
