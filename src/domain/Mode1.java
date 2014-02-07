package domain;

import java.util.ArrayList;

public class Mode1 {

	public double v1,v2,v3,v4,r1,r2,r3,r4,i1,i2,i3,i4;
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> solutions = new ArrayList<String>();
	public ArrayList<String> wrongsolutions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<String> correct = new ArrayList<String>();
	public String questiondata = "";
	public boolean verifyanswer(int step, String answer){
		return false;
	}
}
