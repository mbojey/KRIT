package domain;

import inferenceTools.Vertex;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import student.StudentData;

public class easyMode2 extends Mode2 {

	public double v1, v2, r1, r2, r3, i1, i2, i3;
	private Random rand = new Random();
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> solutions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> hints = new ArrayList<String>();
	public ArrayList<String> correct = new ArrayList<String>();
	public ArrayList<Boolean> skippable = new ArrayList<Boolean>();
	public Boolean[] exists = {true,true,false,true,true,true,false,true,true,true};
	private Vertex<String> numcor = new Vertex<String>("Numerically Correct1",
			2);
	private Vertex<String> voltages = new Vertex<String>(
			"Voltages Total Zero1", 2);
	private Vertex<String> currents = new Vertex<String>("Currents Balanced1",
			2);
	private Vertex<String> sign = new Vertex<String>(
			"Sign Convention Correct1", 3);
	private Vertex<String> units = new Vertex<String>("Units Correct1", 3);
	private DecimalFormat decim = new DecimalFormat("0.###");

	public String questiondata = "";

	public easyMode2() {
		super.exists = exists;
		super.v1 = v1 = rand.nextInt(20) / 2.0 + 1;
		super.v2 = v2 = rand.nextInt(20) / 2.0 + 1;
		super.r1 = r1 = rand.nextInt(20) / 2.0 + 1;
		super.r2 = r2 = rand.nextInt(20) / 2.0 + 1;
		super.r3 = r3 = rand.nextInt(20) / 2.0 + 1;
		i2 = rand.nextInt(1);
		super.i2 = i2 = (v2 - ((r1 + r2) * ((v1 + v2) / r1)))
				/ ((r1 + r2) * (r3 / r1) + r2);
		super.i1 = i1 = ((v1 + v2 + (r3 * i2)) / r1);
		super.i3 = i3 = i1 + i2;
		addsolutiontext();
		addquestiontext();		
		addanswerstext();
		addhintstext();
		addcorrecttext();
		addboolean();
		super.questions = questions;
		super.solutions = solutions;
		super.answers = answers;
		super.hints = hints;
		super.correct = correct;
		super.skippable = skippable;
		super.questiondata = questiondata = "V1 = " + v1 + ", V2 = " + v2
				+ "\nR1 = " + r1 + ", R2 = " + r2 + ", R3 = " + r3;
	}

	private void addboolean() {
		skippable.add(false);
		skippable.add(false);
		skippable.add(false);
		skippable.add(true);
		skippable.add(true);
		skippable.add(false);
		skippable.add(false);
		skippable.add(false);

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
		solutions.add(v2 + "V - " + r1 + "½*I1 - " + r2 + "½*I3 = 0");
		solutions.add("-" + r3 + "½*I2 - " + v1 + "V + " + r1 + "½*I1 - " + v2
				+ "V = 0");
		solutions.add(v2 + "V - " + decim.format(r1 + r2) + "½*I1 - " + r2
				+ "½*I2 = 0");
		solutions.add("" + decim.format((v2 + v1) / r1) + "A + "
				+ decim.format(r3 / r1) + "I2 = I1");
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
		answers.add("Conservation of charge means that current in must equal current out,\n"
				+ "following the arrows gives\n" + solutions.get(0));
		answers.add("Conservation of energy and Kirchhoff's loop rule tell us that the \n"
				+ "voltage gained and lost around a loop must equal zero. This gives\n"
				+ solutions.get(1));
		answers.add("Remember the sign conventions, when going with the current going \n"
				+ "across a resistor voltage is lost, when going against the current \n"
				+ "voltage is gained. Therefore the answer is\n"
				+ solutions.get(2));
		answers.add("Make sure to simplify your answer. The equation you will find is\n"
				+ solutions.get(3));
		answers.add("Simplifying and solving for I2 gives\n" + solutions.get(4));
		answers.add("Solve for I2 using your previous work, this gives\n"
				+ solutions.get(5));
		answers.add("Using equation 3 and the value you found for I2, " + i2
				+ " gives\n" + solutions.get(6));
		answers.add("Remember the first equation, I1+I2=I3, and the values for\n"
				+ " I1, "
				+ i1
				+ " and I2, "
				+ i2
				+ " which gives\n"
				+ solutions.get(7));
	}

	private void addhintstext() {
		hints.add("Conservation of charge means that current in must equal current out, follow the arrows.");
		hints.add("Conservation of energy and Kirchhoff's loop rule tell us that the voltage gained and lost around a loop must equal zero.");
		hints.add("Remember the sign conventions, when going with the current going across a resistor voltage is lost, when going against the current voltage is gained.");
		hints.add("Make sure to simplify your answer.");
		hints.add("Don't forget to round your answers");
		hints.add("Solve for I2 using your previous work");
		hints.add("Use equation 3 and the value you found for I2, " + i2);
		hints.add("Remember the first equation, I1+I2=I3, and the values for I1, "
				+ i1 + " and I2, " + i2);
	}

	public boolean verifyanswer(int step, String answer) {
		switch (step) {
		case (0):
			return verifystep0(answer);
		case (1):
			return verifystep1(answer);
		case (2):
			return verifystep2(answer);
		case (3):
			return verifystep3(answer);
		case (4):
			return verifystep4(answer);
		case (5):
			return verifystep5(answer);
		case (6):
			return verifystep6(answer);
		case (7):
			return verifystep7(answer);
		}
		return false;
	}

	private boolean verifystep0(String answerstring) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		double answer = 0;
		boolean RHS = false, valid = false;
		try{
		if (!answerstring.endsWith("=") && !answerstring.endsWith("-")
				&& !answerstring.endsWith("+") && !(answerstring.equals(""))) {
			valid = true;
			while (answerstring.length() > 0) {
				if (answerstring.charAt(0) == 'I') {
					if (answerstring.charAt(1) == '1')
						answer += i1;
					if (answerstring.charAt(1) == '2')
						answer += i2;
					if (answerstring.charAt(1) == '3')
						answer += i3;
					answerstring = answerstring.substring(2);
				} else if (answerstring.charAt(0) == '+') {
					if (answerstring.charAt(2) == '1')
						answer += !RHS ? i1 : -i1;
					if (answerstring.charAt(2) == '2')
						answer += !RHS ? i2 : -i2;
					if (answerstring.charAt(2) == '3')
						answer += !RHS ? i3 : -i3;
					answerstring = answerstring.substring(3);
				} else if (answerstring.charAt(0) == '-') {
					if (answerstring.charAt(2) == '1')
						answer -= !RHS ? i1 : -i1;
					if (answerstring.charAt(2) == '2')
						answer -= !RHS ? i2 : -i2;
					if (answerstring.charAt(2) == '3')
						answer -= !RHS ? i3 : -i3;
					answerstring = answerstring.substring(3);
				} else if (answerstring.charAt(0) == '=') {
					if (answerstring.charAt(2) == '1')
						answer -= i1;
					if (answerstring.charAt(2) == '2')
						answer -= i2;
					if (answerstring.charAt(2) == '3')
						answer -= i3;
					answerstring = answerstring.substring(3);
					RHS = true;
				}
				else{
					throw new Exception();
				}

			}
		}
		if (Math.abs(answer) < 0.000005 && valid)
			StudentData.student.enter_evidence(currents, 0);
		else
			StudentData.student.enter_evidence(currents, 1);
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 0 + ","+(Math.abs(answer) < 0.000005 && valid));
		}catch(Exception e){
			valid = false;
			StudentData.student.enter_evidence(currents, 1);
			StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
					new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
							+ 0 + ","+(Math.abs(answer) < 0.000005 && valid));

		}
		return Math.abs(answer) < 0.000005 && valid;
	}

	private boolean verifystep1(String input) {
		boolean result = true, volts = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int signcount = 0, unitscount = 0;
		String answer = "";
		String solution = solutions.get(1);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = volts = false;
					} catch (Exception e) {
						result = volts = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					signcount++;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(voltages, 0);
			StudentData.student.enter_evidence(sign, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (volts)
				StudentData.student.enter_evidence(voltages, 0);
			else
				StudentData.student.enter_evidence(voltages, 1);
			if (signcount < 2)
				StudentData.student.enter_evidence(sign, signcount);
			else
				StudentData.student.enter_evidence(sign, 2);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 1 + ","+ result);
		return result;
	}

	private boolean verifystep2(String input) {
		boolean result = true, volts = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int signcount = 0, unitscount = 0;
		String answer = "";
		String solution = solutions.get(2);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = volts = false;
					} catch (Exception e) {
						result = volts = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					signcount++;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(voltages, 0);
			StudentData.student.enter_evidence(sign, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (volts)
				StudentData.student.enter_evidence(voltages, 0);
			else
				StudentData.student.enter_evidence(voltages, 1);
			if (signcount < 2)
				StudentData.student.enter_evidence(sign, signcount);
			else
				StudentData.student.enter_evidence(sign, 2);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 1 + ","+ result);
		return result;
	}

	private boolean verifystep3(String input) {
		boolean result = true, num = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int unitscount = 0;
		String answer = "";
		String solution = solutions.get(3);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = num = false;
					} catch (Exception e) {
						result = num = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					num = false;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(numcor, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (num)
				StudentData.student.enter_evidence(numcor, 0);
			else
				StudentData.student.enter_evidence(numcor, 1);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 2 + ","+ result);
		return result;
	}

	private boolean verifystep4(String input) {
		boolean result = true, num = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int unitscount = 0;
		String answer = "";
		String solution = solutions.get(4);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = num = false;
					} catch (Exception e) {
						result = num = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					num = false;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(numcor, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (num)
				StudentData.student.enter_evidence(numcor, 0);
			else
				StudentData.student.enter_evidence(numcor, 1);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 3 + ","+ result);
		return result;
	}

	private boolean verifystep5(String input) {
		boolean result = true, num = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int unitscount = 0;
		String answer = "";
		String solution = solutions.get(5);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = num = false;
					} catch (Exception e) {
						result = num = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					num = false;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(numcor, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (num)
				StudentData.student.enter_evidence(numcor, 0);
			else
				StudentData.student.enter_evidence(numcor, 1);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 4 + ","+ result);
		return result;
	}

	private boolean verifystep6(String input) {
		if (input.equals(""))
			return false;
		boolean result = true, num = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int unitscount = 0;
		String answer = "";
		String solution = solutions.get(6);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = num = false;
					} catch (Exception e) {
						result = num = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					num = false;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(numcor, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (num)
				StudentData.student.enter_evidence(numcor, 0);
			else
				StudentData.student.enter_evidence(numcor, 1);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 5 + ","+ result);
		return result;
	}

	private boolean verifystep7(String input) {
		if (input.equals(""))
			return false;
		boolean result = true, num = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int unitscount = 0;
		String answer = "";
		String solution = solutions.get(7);
		String correct = "";
		for (int i = 0; i < input.length(); i++) {
			try {
				if ((Character.isDigit(input.charAt(i)) && input.charAt(i - 1) != 'I')
						|| input.charAt(i) == '.')
					answer += input.charAt(i);
				else if (input.charAt(i) == 'I')
					answer += " " + input.charAt(i++) + "" + input.charAt(i)
							+ " ";
				else
					answer += " " + input.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				answer += input.charAt(i);
			}
		}
		for (int i = 0; i < solution.length(); i++) {
			try {
				if ((Character.isDigit(solution.charAt(i)) && solution
						.charAt(i - 1) != 'I') || solution.charAt(i) == '.')
					correct += solution.charAt(i);
				else if (solution.charAt(i) == 'I')
					correct += " " + solution.charAt(i++) + ""
							+ solution.charAt(i) + " ";
				else
					correct += " " + solution.charAt(i) + " ";
			} catch (StringIndexOutOfBoundsException ex) {
				correct += solution.charAt(i);
			}
		}
		ArrayList<String> inputterms = new ArrayList<String>();
		ArrayList<String> correctterms = new ArrayList<String>();
		Scanner scan = new Scanner(answer);
		while (scan.hasNext())
			inputterms.add(scan.next());
		scan = new Scanner(correct);
		while (scan.hasNext())
			correctterms.add(scan.next());
		for (int m = 0; m < inputterms.size(); m++) {
			if (m < correctterms.size()) {
				if (Character.isDigit(inputterms.get(m).charAt(0))) {
					try {
						if (Math.abs(Float.parseFloat(inputterms.get(m))
								- Float.parseFloat(correctterms.get(m))) < 0.002) {
						} else
							result = num = false;
					} catch (Exception e) {
						result = num = false;
					}
				} else if (Character.isLetter(inputterms.get(m).charAt(0))
						&& inputterms.get(m).charAt(0) != 'I') {
					if (inputterms.get(m).equals(correctterms.get(m))) {
					} else {
						unitscount++;
						result = false;
					}
				} else if (inputterms.get(m).charAt(0) == 'I') {
				} else if (inputterms.get(m).equals(correctterms.get(m))) {
				} else {
					num = false;
					result = false;
				}
			} else
				result = false;
		}
		if (inputterms.size() < correctterms.size() - 2)
			result = false;
		if (result) {
			StudentData.student.enter_evidence(numcor, 0);
			StudentData.student.enter_evidence(units, 0);
		} else {
			if (num)
				StudentData.student.enter_evidence(numcor, 0);
			else
				StudentData.student.enter_evidence(numcor, 1);
			if (unitscount < 2)
				StudentData.student.enter_evidence(units, unitscount);
			else
				StudentData.student.enter_evidence(units, 2);
		}
		StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 2 + "," + 0 + ","
						+ 6 + ","+ result);
		return result;
	}

	public void setv1(float input) {
		super.v1 = v1 = input;
	}

	public void setv2(float input) {
		super.v2 = v2 = input;
	}

	public void setv3(float input) {
		super.v3= v3 = input;
	}

	public void setr1(float input) {
		super.r1 = r1 = input;
	}

	public void setr2(float input) {
		super.r2 = r2 = input;
	}

	public void setr3(float input) {
		super.r3 = r3 = input;
	}

	public void setr4(float input) {
		super.r4 = r4 = input;
	}
	public void updateanswers(){
		super.i2 = i2 = (v2 - ((r1 + r2) * ((v1 + v2) / r1)))
				/ ((r1 + r2) * (r3 / r1) + r2);
		super.i1 = i1 = ((v1 + v2 + (r3 * i2)) / r1);
		super.i3 = i3 = i1 + i2;
	}

}
