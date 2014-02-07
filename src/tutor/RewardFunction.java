package tutor;

public class RewardFunction {
	private static int[][][] endStep = {{{-30,40,50},{-40,0,40},{-50,-40,-30}},
		   {{40,15,0},{45,25,10},{50,35,20}},
		   {{-30,-40,-50},{-5,-15,-25},{20,10,0}}};
	// See Excel Sheet for details

	private static int[][] skipStep = { { 10, -5 }, { 3, 2 }, { -10, 10 } };

	// {{High+Yes, High+No},{Mid+Yes, Mid+No},{Lo+Yes, Lo+No}}

	public static int EndStep(double[] understanding, double[] need) {
		double nothing = 0, hint = 0, answer = 0;
		for (int i = 0; i < endStep.length; i++)
			for (int j = 0; j < endStep[0].length; j++)
					nothing += understanding[i] * need[j]* endStep[i][j][0];
		for (int i = 0; i < endStep.length; i++)
			for (int j = 0; j < endStep[0].length; j++)
					hint += understanding[i] * need[j]* endStep[i][j][1];
		for (int i = 0; i < endStep.length; i++)
			for (int j = 0; j < endStep[0].length; j++)
					answer += understanding[i] * need[j]* endStep[i][j][2];
		if (hint > answer) {
			if (hint > nothing)
				return 1;
			else if (nothing > answer)
				return 0;
			else
				return 2;
		} else {
			if (answer > nothing)
				return 2;
			else
				return 0;
		}
	}
	public static int skipStep(double[] understanding) {
		double yes = understanding[0] * skipStep[0][0] + understanding[1]
				* skipStep[1][0] + understanding[2] * skipStep[2][0];
		double no = understanding[0] * skipStep[0][1] + understanding[1]
				* skipStep[1][1] + understanding[2] * skipStep[2][1];
		if (yes > no)
			return 0;
		else
			return 1;
	}

	

}
