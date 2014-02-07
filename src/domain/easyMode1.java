package domain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class easyMode1 extends Mode1 {

	public double v1, v2, r1, r2, r3, i1, i2, i3;
	private Random rand = new Random();
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> solutions = new ArrayList<String>();
	public ArrayList<String> wrongsolutions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> correct = new ArrayList<String>();
	private DecimalFormat decim = new DecimalFormat("0.###");
	public String questiondata = "";
	public easyMode1() {
		super.v1 = v1 = rand.nextInt(20)/2.0+1;
		super.v2 = v2 = rand.nextInt(20)/2.0+1;
		super.r1 = r1 = rand.nextInt(20)/2.0+1;
		super.r2 = r2 = rand.nextInt(20)/2.0+1;
		super.r3 = r3 = rand.nextInt(20)/2.0+1;		
		super.i2 = i2 = (v2 - ((r1 + r2) * ((v1 + v2) / r1)))
				/ ((r1 + r2) * (r3 / r1) + r2);
		String eye2 = decim.format(i2);
		super.i2 = i2 = Double.parseDouble(eye2);
		super.i1 = i1 = ((v1 + v2 + (r3 * i2)) / r1);
		String eye1 = decim.format(i1);
		super.i1 = i1 = Double.parseDouble(eye1);
		super.i3 = i3 = i1 + i2;
		String eye3 = decim.format(i3);
		super.i3 = i3 = Double.parseDouble(eye3);
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
				+ "\nR1 = " + r1 + ", R2 = " + r2 + ", R3 = "
				+ r3;
	}
	private void addwrongsolutiontext() {
		wrongsolutions.add("I1 - I2 = I3");
		wrongsolutions.add("I1 = I3 + I2");
		wrongsolutions.add("I1 = I3");
		wrongsolutions.add("-"+v2 + "V + " + r1 + "Ω*I1 + " + r2 + "Ω*I3 = 0");
		wrongsolutions.add(v2 + "V + " + r1 + "Ω*I1 + " + r2 + "Ω*I3 = 0");
		wrongsolutions.add(v2 + "A - " + r1 + "Ω*I1 - " + r2 + "Ω*I3 = 0");
		wrongsolutions.add(r3 + "Ω*I2 - " + v1 + "V - " + r1 + "Ω*I1 - " + v2
				+ "V = 0");
		wrongsolutions.add("-" + r3 + "Ω*I2 - " + v1 + "V - " + r1 + "Ω*I1 + " + v2
				+ "V = 0");
		wrongsolutions.add("-" + r3 + "Ω*I2 - " + v1 + "A + " + r1 + "Ω*I1 - " + v2
				+ "A = 0");
		wrongsolutions.add(v2 + "V - " + decim.format(r1 - r2) + "Ω*I1 - " + r1 + "Ω*I2 = 0");
		wrongsolutions.add(v2 + "V + " + decim.format(r1 + r2) + "Ω*I1 - " + r1 + "Ω*I2 = 0");
		wrongsolutions.add(v2 + "V - " + decim.format(r1 + r2) + "Ω*I1 - " + r1 + "Ω*I2 = 0");
		wrongsolutions.add("" + decim.format((v2 + v1) / r1) + "V + " + decim.format(r3 / r1) + "I2 = I1");
		wrongsolutions.add("-" + decim.format((v2 + v1) / r1) + "A + " + decim.format(r3 / r1) + "I2 = I1");
		wrongsolutions.add("" + decim.format((v2 - v1) / r1) + "A + " + decim.format(r3 / r1) + "I2 = I1");
		wrongsolutions.add("" + i2 + "V");
		wrongsolutions.add("" + (i2+2) + "A");
		wrongsolutions.add("" + i2 + "Ω");
		wrongsolutions.add("" + i1 + "Ω");
		wrongsolutions.add("-" + i1 + "A");
		wrongsolutions.add("" + i1 + "V");
		wrongsolutions.add("" + (i3+1) + "A");
		wrongsolutions.add("" + i3 + "V");
		wrongsolutions.add("" + i3 + "Ω");
		
	}
	private void addquestiontext() {
		questions
		.add("Using the given diagram with the given directions of I1, I2 and I3,\n "
				+ "apply the junction rule to the junction at \'d\'."
				+ "\nThis will be equation 1.");
		questions
		.add("Now apply the loop rule to the loop given by \"cdfec\" \n"
				+ "and use the normal sign conventions.\n"
				+ "This will be equation 2.");
		questions
		.add("Now apply the loop rule to the loop given by \"cabdc\" \n"
				+ "and use the normal sign conventions.\n"
				+ "This will be equation 3.");
		questions.add("Use equation (1) to rewrite (2) in terms of"
		+ "I1, I2 and simplify, this will be equation 4.\n1) " + solutions.get(0)+"\n2) " + solutions.get(1));
		questions.add("Solve for I1 in equation 3, this will be equation 5.\n 3) " + solutions.get(2));
		questions.add("What is the value of I2?\n 4) "+solutions.get(3)+"\n5) "+solutions.get(4));
		questions.add("Using the value of I2, what is the value of I1?\nI2 = " +decim.format(i2)+"A\n 2)"+solutions.get(1));
		questions
		.add("Using the values of I2 and I1, what is the value of I3?\nI2 = "+decim.format(i2)+"A\nI1 = "+decim.format(i1)+"A");
	}
	private void addsolutiontext() {
		solutions.add("I1 + I2 = I3");
		solutions.add(v2 + "V - " + r1 + "Ω*I1 - " + r2 + "Ω*I3 = 0");
		solutions.add("-" + r3 + "Ω*I2 - " + v1 + "V + " + r1 + "Ω*I1 - " + v2
				+ "V = 0");
		solutions.add(v2 + "V - " + decim.format(r1 + r2) + "Ω*I1 - " + r2 + "Ω*I2 = 0");
		solutions.add("" + decim.format((v2 + v1) / r1) + "A + " + decim.format(r3 / r1) + "I2 = I1");
		solutions.add("" + i2 + "A");
		solutions.add("" + i1 + "A");
		solutions.add("" + i3 + "A");

	}
	private void addcorrecttext() {
		correct.add("Way to go!  Press Continue to move on.");
		correct.add("Awesome!  Press Continue to move on.");
		correct.add("Good work!  Press Continue to move on.");
		correct.add("Great!  Press Continue to move on.");
		correct.add("Correct!  Press Continue to move on.");
		correct.add("Good job!  Press Continue to move on.");
		correct.add("Yeah!  Press Continue to move on.");
		correct.add("Way to go!  You have completed this question, press Continue to start a new question.");

	}
	private void addanswerstext() {
		answers.add("Conservation of charge means that current in must equal current out,\n" +
				"following the arrows gives\n"+solutions.get(0));
		answers.add("Conservation of energy and Kirchhoff's loop rule tell us that the \n" +
				"voltage gained and lost around a loop must equal zero. This gives\n" +
				solutions.get(1));
		answers.add("Remember the sign conventions, when going with the current going \n" +
				"across a resistor voltage is lost, when going against the current \n" +
				"voltage is gained. Therefore the answer is\n"+ solutions.get(2));
		answers.add("Make sure to simplify your answer. The equation you will find is\n" +
				solutions.get(3));
		answers.add("Simplifying and solving for I2 gives\n" + solutions.get(4));
		answers.add("Solve for I2 using your previous work, this gives\n" +
				solutions.get(5));
		answers.add("Using equation 3 and the value you found for I2, " + i2
				+" gives\n"+solutions.get(6));
		answers.add("Remember the first equation, I1+I2=I3, and the values for\n" +
				" I1, "	+ i1 + " and I2, " + i2+" which gives\n"+solutions.get(7));
	}
}
