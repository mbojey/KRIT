package Instructions;

import inferenceTools.Vertex;
import inferenceTools.logger;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import student.StudentData;
import PreUse.MCQuestion;

@SuppressWarnings("serial")
public class InstructionFrame extends JFrame implements MouseMotionListener {

	
	JButton next = new JButton("Next");
	JButton back = new JButton("Back");
	JTextPane topinformation = new JTextPane();
	JTextPane bottominformation = new JTextPane();
	JTextPane title = new JTextPane();
	ImagePanel image;
	String[] topinstructions = {
			"This software, KRIT, helps you practice with Kirchhoff’s Rules by giving you different types of exercises and helping you through them.  Based on how you do in each exercise, KRIT will help you along if it thinks you’re stuck or give you a more challenging exercise if you’re doing well. KRIT may also give you an exercise in a different level depending on how you do. Try it out and see if you like it.\n\nIf you don’t like the level that KRIT selected for you, you can always go back to the Main Screen and select the level that you wish to try out.  KRIT has 4 levels, and each level has easy, medium, or hard exercises. We will explain these levels next.\n\nIf at any point these instructions seem unclear, feel free to ask the researcher to explain them.",
			"In this level, you will be presented with a circuit diagram like the one shown here:",
			"The exercises in this level are also based on a circuit diagram. However, instead of having multiple choice questions, you now have to use a keypad to enter the answer. Here is a sample question and a sample answer before it’s been submitted:",
			"In this level, you can work on the questions in an exercise in the order that you want. First, you choose which loops and junctions to work on and create equations based on these elements. Here’s an example question:",
			"Bored of the exercises KRIT has and want to create your own? You can do just that in this level. KRIT will walk you through the steps in building your own exercise, but you’ll have to solve it and give it the right answer too or it won’t get created.\n\nWhen you enter this level, you will see two options:",
			"Here, you will see a screen like this that shows a circuit diagram and asks you to enter the values for each variable in it:",
			"Once the problem has been created, you will need to select three variable values to hide. These are the values that other students will have to solve for. KRIT will show you a circuit like this:",
			"Remember the two options in this level? If you selected Solve Exercises, you will see a screen like this:",
			"If you get stuck while using KRIT, try it figure it out on your own before asking the researcher. For the purposes of this study, questions about the software will be answered but questions related to solving the Physics exercises will need to be worked out on your own." };
	String[] bottominstructions = {
			"",
			"Using the diagram, you will be asked step-by-step questions for applying Kirchhoff’s rules. Your task is to pick the best answer in the multiple choice question and submit it to move onto the next question.",
			"When you are entering answers in this level, be sure to simplify your answers and use decimals instead of fractions. If you get stuck, KRIT will try to help you. Some steps also have hints that you may want to check out.",
			"The rest of the exercise is the same as before – you solve for the currents, enter the answer using the keypad, and submit it to see if it’s correct.",
			"One option lets you create your own exercise, while the other lets you solve exercises that your friends created. Let’s walk through how you can create your own exercises.",
			"",
			"Enter all the values required using the keypad, then press Submit. Make sure your values work out otherwise KRIT won’t let you create it.",
			"All you have to do is pick an exercise and solve it! KRIT won’t guide you through these problems, but it can tell if you get the answer right or wrong. Try it out and see!",
			"You can now take a short break or you can get started with a questionnaire. Once you are ready, click on the start button." };
	String[] filenames = { "blank.jpg", "question1a.jpg", "question1b.jpg",
			"junctionchoice.jpg", "problemchoice.jpg", "creationb.jpg", "hiding.jpg", "choosing.jpg", "blank.jpg" };
	String[] titles = { "Instructions", "Level 1: Multiple Choice",
			"Level 2: Guided Exercises", "Level 3: Customizable Exercises",
			"Level 4: Create Your Own Exercise",
			"Level 4: Create Your Own Exercise",
			"Level 4: Create Your Own Exercise",
			"Level 4: Create Your Own Exercise", "Questions?" };
	int position = 0;
	int x = 0;
	int y = 0;
	int xdist = 0;
	int ydist = 0;
	long current;

	public InstructionFrame(int position) {
		super();
		addMouseMotionListener(this);
		current = System.currentTimeMillis();
		this.position = position;
		image = new ImagePanel(filenames[position]);
		image.setBackground(Color.WHITE);
		makeandplacecomponents();
		filldata();
		title.setFont(new Font("Serif",Font.BOLD,24));
	}

	private void makeandplacecomponents() {
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				browse();
				pause();
				if(position != 8){
					Container c;
					InstructionFrame frame4 = new InstructionFrame(position+1);
					frame4.setSize(704, 780);
					frame4.setVisible(true);
					c = frame4.getContentPane();
					c.setBackground(Color.WHITE);	
					close();
					}
				else{
					close();
				}
			}			
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(position != 0){
				Container c;
				InstructionFrame frame4 = new InstructionFrame(position-1);
				frame4.setSize(704, 780);
				frame4.setVisible(true);
				c = frame4.getContentPane();
				c.setBackground(Color.WHITE);	
				close();
				}
			}
		});
		initComponents();
	}

	
	protected void pause() {
		if(System.currentTimeMillis() - current > 10000 && System.currentTimeMillis() - current < 15000){
			System.out.println("Pause");
			current = System.currentTimeMillis();
		}
		
	}
	private void browse() {
		if(xdist > 2000 || ydist > 2000)
			System.out.println("Browsed");
		xdist = ydist = 0;		
	}
	private void close() {
		if(position == 8){
			JFrame background = new JFrame();
			Container c = background.getContentPane();
			background.setSize(2000, 2000);
			c.setBackground(Color.BLACK);
			background.setVisible(true);
			JFrame frame;
			@SuppressWarnings("unused")
			StudentData student = new StudentData();			
			double[] temp = StudentData.student.find_probability(new Vertex<String>("Understanding1", 3));
			logger.entry();
			if(temp[0] > 0.6)
				frame = new MCQuestion(0);	
			else if(temp[1] > 0.6)
				frame = new MCQuestion(0);	
			else if(temp[2] > 0.6)
				frame = new MCQuestion(0);	
			else
				frame = new MCQuestion(0);	
			frame.setSize(416,300);
			frame.setVisible(true);
		}
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}

	private void initComponents() {	        
		   JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
	        title = new javax.swing.JTextPane();
	        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
	        topinformation = new javax.swing.JTextPane();
	        JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
	        bottominformation = new javax.swing.JTextPane();
	        jScrollPane1.setBorder(null);
	        jScrollPane2.setBorder(null);
	        jScrollPane3.setBorder(null);

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jScrollPane1.setViewportView(title);

	        jScrollPane2.setViewportView(topinformation);

	        javax.swing.GroupLayout imageLayout = new javax.swing.GroupLayout(image);
	        image.setLayout(imageLayout);
	        imageLayout.setHorizontalGroup(
	            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 0, Short.MAX_VALUE)
	        );
	        imageLayout.setVerticalGroup(
	            imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 293, Short.MAX_VALUE)
	        );

	        jScrollPane3.setViewportView(bottominformation);

	        back.setText("Back");

	        next.setText("Next");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1)
	            .addComponent(jScrollPane2)
	            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(back)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(next)
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(back)
	                    .addComponent(next))
	                .addContainerGap(13, Short.MAX_VALUE))
	        );

	        pack();
	    }

	private void filldata() {
		topinformation.setText(topinstructions[position]);
		bottominformation.setText(bottominstructions[position]);		
		title.setText(titles[position]);
		if (position == 8)
			next.setText("Start Using KRIT!");
	}

	@Override
	public void mouseDragged(MouseEvent e) {		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int newx = e.getXOnScreen();
		int newy = e.getYOnScreen();
		xdist += Math.abs(newx-x);
		ydist += Math.abs(newy-y);
		this.x = newx;
		this.y = newy;
		
	}

}
