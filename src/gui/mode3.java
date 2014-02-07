package gui;

import inferenceTools.Vertex;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import student.StudentData;
import domain.Mode3;
import domain.easyMode3;

@SuppressWarnings("serial")
public class mode3 extends JFrame {

	Mode3 question;
	static int step;
	static int difficulty;

	public mode3(int difficulty) {
		super();
		mode3.difficulty = difficulty;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2 - 200,
				dim.height / 2 - this.getSize().height / 2 - 360);	
		this.setVisible(false);
		// Activate and Place Swing Components
		switch (difficulty) {
		case (0):
			question = new easyMode3();
			break;
		case (1):
			question = new easyMode3();
			break;
		case (2):
			question = new easyMode3();
			break;
		}
		makeandplacecomponents();
	}
	public void makeandplacecomponents() {
		if(step >= question.answers.size()){
			close();
			return;
		}
		int questiontype = question.questiontype.get(step);
		JFrame frame;
		switch (questiontype) {
		case (0):
			frame = new JunctionChoice(difficulty);
			frame.setSize(416, 700);
			frame.setVisible(true);
			step++;
			break;
		case (1):
			if (Mode3.loopoptions.size()%3 == 0)
				frame = new LoopChoice(difficulty, Mode3.loopoptions.get(0),
						Mode3.loopoptions.get(1),
						Mode3.loopoptions.get(2));
			else
				frame = new LoopChoice(difficulty, Mode3.loopoptions.get(0),
						Mode3.loopoptions.get(1));
			frame.setSize(416, 700);
			frame.setVisible(true);
			step++;
			break;
		case (2):
			frame = new InputFrame3(difficulty, step);
			frame.setSize(416, 700);
			frame.setVisible(true);
			step++;
			break;
		}
	}	

	private void close() {
		double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
		int understanding;
		if(temp[0] > temp[1]){
			if(temp[0] > temp[2])
				understanding = 0;
			else
				understanding = 2;
		}
		else{
			if(temp[1] > temp[2])
				understanding = 1;
			else
				understanding = 2;
		}
		JFrame frame = new JFrame();
		frame.setSize(416,700);
		frame.setVisible(true);
		if(understanding == 0){
			if(difficulty ==0)
				frame = new Instruction(1,0);
			else
				frame = new mode3(difficulty - 1);				
		}
		else{
			if(difficulty == 2)
				frame = new Instruction(3,0);
			else
				frame = new mode3(difficulty + 1);	
		}
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}
}
