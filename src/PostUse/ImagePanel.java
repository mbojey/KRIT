package PostUse;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private ImageIcon image;

	public ImagePanel(int difficulty) {
		String filename = "";
		switch (difficulty) {
		case (0):
			filename = "question1.jpg";
			break;
		case (1):
			filename = "question2.jpg";
			break;
		case (2):
			filename = "question3.jpg";
			break;
		}

		try {
			image = null;
			image = new ImageIcon(getClass().getResource(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}

}