package inferenceTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import student.StudentData;

public class logger {
	static int subject = 01;
	static String userHomeFolder = System.getProperty("user.home");
	static File file = new File(userHomeFolder, "KRIT_data.csv");
	static PrintWriter writer;
	
	public static void entry(){
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			writer.println("Understanding,,,Need,,,Receptiveness,,,,Numerical,correct,volts,correct,currents,correct,sign,,correct,units,,correct,blank,,browse,,pause,,undo,,ask,,readhint,,readanswer,,,time,mode,exercise,question,correct");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void entry(String input) {
		String student = getStudentData();
		String actions = getStudentActions();
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			writer.println(student + "," + actions + "," + input);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getStudentData() {
		double[] temp = StudentData.student
				.find_probability(new Vertex<String>("Understanding1", 3));
		String result = "";
		for (double value : temp)
			result += value + ",";
		temp = StudentData.student.find_probability(new Vertex<String>(
				"Receptiveness1", 3));
		for (double value : temp)
			result += value + ",";
		temp = StudentData.student.find_probability(new Vertex<String>("Need1",
				3));
		for (double value : temp)
			result += value + ",";
		return result;
	}

	public static String getStudentActions() {
		double[] temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Numerically Correct1", 2));
		String result = "";
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Voltages Total Zero1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Currents Balanced1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Sign Convention Correct1", 3));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Units Correct1", 3));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student
				.getlikelihood(new Vertex<String>("Blank1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>("Browse1",
				2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student
				.getlikelihood(new Vertex<String>("Pause1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student
				.getlikelihood(new Vertex<String>("Undo1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Ask for Hint1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Read Hint1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		temp = StudentData.student.getlikelihood(new Vertex<String>(
				"Read Answer1", 2));
		for (double value : temp)
			if(value == 0 )
				result += "true,  ";
			else
				result += "false, ";
		return result;
	}
}
