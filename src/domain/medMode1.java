package domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class medMode1 extends Mode1 {

	public double v1, v2, r1, r2, r3, i1, i2, i3;
	private Random rand = new Random();
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> solutions = new ArrayList<String>();
	public ArrayList<String> wrongsolutions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> correct = new ArrayList<String>();
	private DecimalFormat decim = new DecimalFormat("0.###");
	public String questiondata = "";

	public medMode1() {
		super.v1 = v1 = rand.nextInt(20) / 2.0 + 1;
		super.v2 = v2 = rand.nextInt(20) / 2.0 + 1;
		super.v3 = v3 = rand.nextInt(20) / 2.0 + 1;
		super.r1 = r1 = rand.nextInt(20) / 2.0 + 1;
		super.r2 = r2 = rand.nextInt(20) / 2.0 + 1;
		super.r3 = r3 = rand.nextInt(20) / 2.0 + 1;
		super.i2 = i2 = (((v1 - v2) / r1) + ((v3 - v2) / r3))
				/ (1 + (r2 / r3) + (r2 / r1));
		String eye2 = decim.format(i2);
		super.i2 = i2 = Double.parseDouble(eye2);
		super.i3 = i3 = ((v1 - v2) / r1) - ((r2 * i2) / r1);
		String eye3 = decim.format(i3);
		super.i3 = i3 = Double.parseDouble(eye3);
		super.i1 = i1 = i2 - i3;
		String eye1 = decim.format(i1);
		super.i1 = i1 = Double.parseDouble(eye1);		
		addsolutiontext();
		addquestiontext();
		addwrongsolutiontext();
		addanswerstext();
		addcorrecttext();
		super.questions = questions;
		super.solutions = solutions;
		super.wrongsolutions = wrongsolutions;
		super.answers = answers;
		super.correct = correct;
		super.questiondata = questiondata = "V1 = " + v1 + ", V2 = " + v2
				+ ", V3 = " + v3 + "\nR1 = " + r1 + ", R2 = " + r2 + ", R3 = "
				+ r3;
	}

	private void addwrongsolutiontext() {
		wrongsolutions.add("I1 + I2 = I3");
		wrongsolutions.add("I1 = I3 + I2");
		wrongsolutions.add("I1 = I3");
		wrongsolutions.add("-" + v1 + "V - " + r1 + "�*I3 + " + r2 + "�*I2 - "
				+ v2 + "V = 0");
		wrongsolutions.add(v1 + "A - " + r1 + "�*I3 - " + r2 + "�*I2 - " + v2
				+ "A = 0");
		wrongsolutions.add(v1 + "V + " + r1 + "�*I3 - " + r2 + "�*I2 + " + v2
				+ "V = 0");
		wrongsolutions.add(v3 + "A - " + r2 + "�*I2 - " + v2 + "A + " + r3
				+ "�*I1 = 0");
		wrongsolutions.add(v3 + "V + " + r2 + "�*I2 - " + v2 + "V - " + r3
				+ "�*I1 = 0");
		wrongsolutions.add(v3 + "V - " + r2 + "�*I2 + " + v2 + "V + " + r3
				+ "�*I1 = 0");
		wrongsolutions.add("" + i2 + "V");
		wrongsolutions.add("" + (i2 + .25) + "A");
		wrongsolutions.add("" + i2 + "�");
		wrongsolutions.add("" + i1 + "�");
		wrongsolutions.add("" + (i1 + .05) + "A");
		wrongsolutions.add("" + i1 + "V");
		wrongsolutions.add("-" + i3 + "A");
		wrongsolutions.add("" + i3 + "V");
		wrongsolutions.add("" + i3 + "�");

	}

	private void addquestiontext() {
		questions
				.add("Using the given diagram with the given directions of I1,\n"
						+ "I2 and I3, apply the junction rule to the junction at \"c\"."
						+ "\nThis will be equation 1.");
		questions
				.add("Now apply the loop rule to the loop given by \"abcfa\"\n"
						+ "and use the normal sign conventions.  \n"
						+ "This will be equation2.");
		questions
				.add("Now apply the loop rule to the loop given by \"edcfe\"\n"
						+ " and use the normal sign conventions.  \n"
						+ "This will be equation3.");
		questions.add("Using (2), (3) and (1), what is the value of I2?\n1) "
				+ solutions.get(0) + "\n2) " + solutions.get(1) + "\n3) "
				+ solutions.get(2));
		questions.add("With your answer for I2, what is the value of I1?\n3) "
				+ solutions.get(2) + "\n I2 = " + i2 + "A");
		questions
				.add("With your answers for I2 and I1, what is the value of I3?\n1) "
						+ solutions.get(0)
						+ "\n I3 = "
						+ i3
						+ "A\n I1 = "
						+ i1
						+ "A");
	}

	private void addsolutiontext() {
		solutions.add("I2 = I1 + I3");
		solutions.add("-" + v1 + "V + " + r1 + "�*I3 + " + r2 + "�*I2 + " + v2
				+ "V = 0");
		solutions.add("-" + v3 + "V + " + r2 + "�*I2 + " + v2 + "V + " + r3
				+ "�*I1 = 0");
		solutions.add("" + i2 + "A");
		solutions.add("" + i1 + "A");
		solutions.add("" + i3 + "A");

	}

	private void addcorrecttext() {
		correct.add("Awesome!  Press Continue to move on.");
		correct.add("Good work!  Press Continue to move on.");
		correct.add("Great!  Press Continue to move on.");
		correct.add("Good job!  Press Continue to move on.");
		correct.add("Yeah!  Press Continue to move on.");
		correct.add("Way to go!  You have completed this question, press Continue\n"
				+ " to start a new question.");

	}

	private void addanswerstext() {
		answers.add("Conservation of charge means that current in must equal current out,\n"
				+ "following the arrows gives\n" + solutions.get(0));
		answers.add("Conservation of energy and Kirchhoff's loop rule tell us that the \n"
				+ "voltage gained and lost around a loop must equal zero. This gives\n"
				+ solutions.get(1));
		answers.add("Remember the sign conventions, when going with the current going \n"
				+ "across a resistor voltage is lost, when going against the current \n"
				+ "voltage is gained. Therefore the answer is\n"
				+ solutions.get(2));
		answers.add("Solve for I2 using your previous work, this gives\n"
				+ solutions.get(3));
		answers.add("Using equation 3 and the value you found for I2, " + i2
				+ " gives\n" + solutions.get(4));
		answers.add("Remember the first equation, " + solutions.get(0)
				+ ", and the values for\n" + " I1, " + i1 + " and I2, " + i2
				+ " which gives\n" + solutions.get(5));
	}
}
