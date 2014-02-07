package inferenceTools;
import java.util.Random;

public class Satisfaction_Action_Maker {

	static Random rand = new Random();

	public static int[] getActionsLo(JoinTree inputTree) {
		double random = rand.nextDouble();
		int[] result = new int[3];// Blank, Social, Hint
		int satisfaction_value = 2, reception_value;
		if (random < inputTree.vertices.get(6).probabilities.two_dimension[satisfaction_value][0])
			result[0] = 0;
		else
			result[0] = 1;
		if (random < inputTree.vertices.get(8).probabilities.two_dimension[satisfaction_value][0])
			result[1] = 0;
		else
			result[1] = 1;
		if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0])
			reception_value = 0;
		else if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0]
				+ inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][1])
			reception_value = 1;
		else
			reception_value = 2;
		if (random < inputTree.vertices.get(7).probabilities.two_dimension[reception_value][0])
			result[2] = 0;
		else
			result[2] = 1;
		return result;
	}
	public static int[] getActionsMid(JoinTree inputTree) {
		double random = rand.nextDouble();
		int[] result = new int[3];// Blank, Social, Hint
		int satisfaction_value = 1, reception_value;
		if (random < inputTree.vertices.get(6).probabilities.two_dimension[satisfaction_value][0])
			result[0] = 0;
		else
			result[0] = 1;
		if (random < inputTree.vertices.get(8).probabilities.two_dimension[satisfaction_value][0])
			result[1] = 0;
		else
			result[1] = 1;
		if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0])
			reception_value = 0;
		else if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0]
				+ inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][1])
			reception_value = 1;
		else
			reception_value = 2;
		if (random < inputTree.vertices.get(7).probabilities.two_dimension[reception_value][0])
			result[2] = 0;
		else
			result[2] = 1;
		return result;
	}
	public static int[] getActionsHi(JoinTree inputTree) {
		double random = rand.nextDouble();
		int[] result = new int[3];// Blank, Social, Hint
		int satisfaction_value = 0, reception_value;
		if (random < inputTree.vertices.get(6).probabilities.two_dimension[satisfaction_value][0])
			result[0] = 0;
		else
			result[0] = 1;
		if (random < inputTree.vertices.get(8).probabilities.two_dimension[satisfaction_value][0])
			result[1] = 0;
		else
			result[1] = 1;
		if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0])
			reception_value = 0;
		else if (random < inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][0]
				+ inputTree.vertices.get(9).probabilities.two_dimension[satisfaction_value][1])
			reception_value = 1;
		else
			reception_value = 2;
		if (random < inputTree.vertices.get(7).probabilities.two_dimension[reception_value][0])
			result[2] = 0;
		else
			result[2] = 1;
		return result;
	}

}
