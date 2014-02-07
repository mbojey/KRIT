package Instructions;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {

	private ImageIcon image;

	public ImagePanel(int difficulty) {
		try {
			switch (difficulty) {
			case (0):
				//image = ImageIO.read(new File("question1.jpg"));
				break;
			case (1):
				//image = ImageIO.read(new File("question2.jpg"));
				break;
			case (2):
				//image = ImageIO.read(new File("question3.jpg"));
				break;
			}

		} catch (Exception ex) {
		}
	}
	public ImagePanel(String filename){
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