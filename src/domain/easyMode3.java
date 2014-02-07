package domain;

import inferenceTools.Vertex;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import student.StudentData;

public class easyMode3 extends Mode3 {

	public double v1, v2, r1, r2, r3, i1, i2, i3;
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> solutions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> hints = new ArrayList<String>();
	public ArrayList<String> correct = new ArrayList<String>();
	public String questiondata = "";
	public ArrayList<Integer> questiontype = new ArrayList<Integer>();
	public ArrayList<Character> junctionoptions = new ArrayList<Character>();
	public static ArrayList<String> loopoptions = new ArrayList<String>();
	private Vertex<String> numcor = new Vertex<String>("Numerically Correct1",
			2);
	private Vertex<String> voltages = new Vertex<String>(
			"Voltages Total Zero1", 2);
	private Vertex<String> currents = new Vertex<String>("Currents Balanced1",
			2);
	private Vertex<String> sign = new Vertex<String>(
			"Sign Convention Correct1", 3);
	private Vertex<String> units = new Vertex<String>("Units Correct1", 3);
	public static char junctionchoice;
	public static String loopchoice;
	@SuppressWarnings("static-access")
	public easyMode3() {
		Random rand = new Random();
		junctionchoice = super.junctionchoice;
		loopchoice = super.loopchoice;
		super.v1 = v1 = rand.nextInt(20) / 2.0 + 1;
		super.v2 = v2 = rand.nextInt(20) / 2.0 + 1;
		super.r1 = r1 = rand.nextInt(20) / 2.0 + 1;
		super.r2 = r2 = rand.nextInt(20) / 2.0 + 1;
		super.r3 = r3 = rand.nextInt(20) / 2.0 + 1;
		super.i2 = i2 = (v2 - ((r1 + r2) * ((v1 + v2) / r1)))
				/ ((r1 + r2) * (r3 / r1) + r2);
		super.i1 = i1 = ((v1 + v2 + (r3 * i2)) / r1);
		super.i3 = i3 = i1 + i2;
		setquestiontext();
		addsolutiontext();
		addanswerstext();
		addhintstext();
		addcorrecttext();
		addquestiontype();
		addjunctionoptions();
		addloopoptions();		
		super.solutions = solutions;
		super.answers = answers;
		super.hints = hints;
		super.correct = correct;
		super.questiontype = questiontype;
		super.questiondata = questiondata = "V1 = " + v1 + "V, V2 = " + v2
				+ "V\nR1 = " + r1 + "Ω, R2 = " + r2 + "Ω, R3 = " + r3 + "Ω";
	}
	@SuppressWarnings("static-access")
	public void setjunctionchoice(char choice){
		super.junctionchoice = junctionchoice = choice;
	}
	@SuppressWarnings("static-access")
	public void setloopchoice(String choice){
		super.loopchoice = loopchoice = choice;
	}
	@SuppressWarnings("static-access")
	private void addloopoptions() {
		loopoptions.add("abdca");
		loopoptions.add("abfea");
		loopoptions.add("cdfec");
		super.loopoptions = loopoptions;
	}

	private void addjunctionoptions() {
		junctionoptions.add('c');
		junctionoptions.add('d');
		super.junctionoptions = junctionoptions;
	}

	private void addquestiontype() {
		questiontype.add(0);
		questiontype.add(2);
		questiontype.add(1);
		questiontype.add(2);
		questiontype.add(1);
		questiontype.add(2);
		questiontype.add(2);
		questiontype.add(2);
		questiontype.add(2);
	}

	private void addcorrecttext() {
		correct.add("Way to go!  Press Continue to move on.");
		correct.add("Awesome!  Press Continue to move on.");
		correct.add("Good work!  Press Continue to move on.");
		correct.add("Great!  Press Continue to move on.");
		correct.add("Way to go!  Press Continue to move on.");
		correct.add("Awesome!  Press Continue to move on.");
		correct.add("Great!  Press Continue to move on.");
		correct.add("Good job!  Press Continue to move on.");
		correct.add("Way to go!  You have completed this question, press Continue to start a new question.");

	}

	private void addhintstext() {
		hints.add("");
		hints.add("Conservation of charge means that current in must equal current out, follow the arrows.");
		hints.add("");
		hints.add("Conservation of energy and Kirchhoff's loop rule tell us that the voltage gained and lost around a loop must equal zero.");
		hints.add("");
		hints.add("Remember the sign conventions, when going with the current going across a resistor voltage is lost, when going against the current voltage is gained.");
		hints.add("Solve for I2 using your previous work");
		hints.add("Use equation 3 and the value you found for I2, " + i2);
		hints.add("Remember the first equation, I1+I2=I3, and the values for I1, "
				+ i1 + " and I2, " + i2);
	}

	private void addanswerstext() {
		answers.add("");
		answers.add("Conservation of charge means that current in must equal current out,\n"
				+ "following the arrows gives\n" + solutions.get(0));
		answers.add("");
		//abdca
		answers.add("Conservation of energy and Kirchhoff's loop rule tell us that the \n"
				+ "voltage gained and lost around a loop must equal zero. This gives\n"
				+ solutions.get(1));		
		//abfea
		answers.add("Remember the sign conventions, when going with the current going \n"
				+ "across a resistor voltage is lost, when going against the current \n"
				+ "voltage is gained. Therefore the answer is\n"
				+ solutions.get(2));
		//cdfec
		answers.add("Conservation of energy and Kirchhoff's loop rule tell us that the \n"
				+ "voltage gained and lost around a loop must equal zero. This gives\n"
				+ solutions.get(3));
		answers.add("Solve for I2 using your previous work, this gives\n"
				+ solutions.get(4));
		answers.add("Using equation 3 and the value you found for I2, " + i2
				+ " gives\n" + solutions.get(5));
		answers.add("Remember the first equation, I1+I2=I3, and the values for\n"
				+ " I1, "
				+ i1
				+ " and I2, "
				+ i2
				+ " which gives\n"
				+ solutions.get(6));

	}

	private void addsolutiontext() {
		solutions.add("I1 + I2 = I3");
		//abdca
		solutions.add("-" + v1  +"V + " + r1 + "Ω*I1 - " + v2 + "V - "+ r3 + "Ω*I2 = 0");
		//abfea
		solutions.add("-" + v1  +"V - " + r2 + "Ω*I3 - " + r3 + "Ω*I2 = 0");
		//cdfec
		solutions.add(v2 + "V - " + r1 + "Ω*I1 - " + r2 + "Ω*I3 = 0");
		solutions.add("" + i2 + "A");
		solutions.add("" + i1 + "A");
		solutions.add("" + i3 + "A");

	}

	public void setquestiontext() {
		questions.clear();
		questions.add("Choose a junction to work with");
		questions
				.add("Using the given diagram with the given directions of I1, I2 and I3,\n "
						+ "apply the junction rule to the junction at \'"+junctionchoice+"\'."
						+ "\nThis will be equation 1.");
		questions.add("Choose a loop to work with");
		questions
				.add("Now apply the loop rule to the loop given by \""+loopchoice+"\" \n"
						+ "and use the normal sign conventions.\n"
						+ "This will be equation 2.");
		questions.add("Choose a loop to work with");
		questions
				.add("Now apply the loop rule to the loop given by \""+loopchoice+"\" \n"
						+ "and use the normal sign conventions.\n"
						+ "This will be equation 3.");
		questions.add("What is the value of I2?");
		questions.add("Using the value of I2, what is the value of I1?\nI2 = "+i2 + "A");
		questions
				.add("Using the values of I2 and I1, what is the value of I3?\n I2 = "+i2+"A\nI1 = "+i1 + "A");
		super.questions = questions;
	}
	public boolean verifyanswer(int step, String answer) {
		switch (step) {
		case (0):
			return true;
		case (1):
			return verifystep0(answer);
		case (2):
			return true;
		case (3):
			return verifystep1(answer, Mode3.loopchoice);
		case (4):
			return true;
		case (5):
			return verifystep2(answer, Mode3.loopchoice);
		case (6):
			return verifystep5(answer);
		case (7):
			return verifystep6(answer);
		case(8):
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
					new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
							+ 0 + ","+(Math.abs(answer) < 0.000005 && valid));
			}catch(Exception e){
				valid = false;
				StudentData.student.enter_evidence(currents, 1);
				StudentData.student.Roll_over(new Vertex<String>("Understanding", 3),
						new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
								+ 0 + ","+(Math.abs(answer) < 0.000005 && valid));

			}
		return Math.abs(answer) < 0.000005 && valid;
	}

	private boolean verifystep1(String input, String loopchoice) {
		boolean result = true, volts = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int signcount = 0, unitscount = 0;
		String answer = "";
		String solution = "";
		if(loopchoice.equals("abdca"))
			solution = solutions.get(1);
		if(loopchoice.equals("abfea"))
			solution = solutions.get(2);
		if(loopchoice.equals("cdfec"))
			solution = solutions.get(3);
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
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
						+ 1 + ","+ result);
		return result;
	}

	private boolean verifystep2(String input, String loopchoice) {
		boolean result = true, volts = true;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int signcount = 0, unitscount = 0;
		String answer = "";
		String solution = "";
		if(loopchoice.equals("abdca"))
			solution = solutions.get(1);
		if(loopchoice.equals("abfea"))
			solution = solutions.get(2);
		if(loopchoice.equals("cdfec"))
			solution = solutions.get(3);
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
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
						+ 1 + ","+ result);
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
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
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
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
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
				new Vertex<String>("Understanding1", 3),dateFormat.format(date) + "," + 3 + "," + 0 + ","
						+ 6 + ","+ result);
		return result;
	}

	
}
