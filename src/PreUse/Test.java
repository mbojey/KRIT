package PreUse;

import inferenceTools.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				//JFrame background = new JFrame();
				//Container c = background.getContentPane();
				//background.setSize(2000, 2000);
				//c.setBackground(Color.BLACK);
				//background.setVisible(true);
				//InputFrame frame = new InputFrame(0);				
				//frame.setSize(416, 700);				
				//frame.setVisible(true);
				//c = frame.getContentPane();
				//c.setBackground(Color.WHITE);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				@SuppressWarnings("unused")
				StudentData student1 = new StudentData();
				logger.entry(dateFormat.format(date));
				MCQuestion frame1 = new MCQuestion(0);				
				frame1.setSize(416, 300);				
				frame1.setVisible(true);
				//c = frame1.getContentPane();
				//c.setBackground(Color.WHITE);
				
				
			}
		});
	}

	

}
