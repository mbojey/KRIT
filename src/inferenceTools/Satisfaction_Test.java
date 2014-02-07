package inferenceTools;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;


public class Satisfaction_Test {

	public static void main(String[] args) {
		String trail = "";
		String filename = "SatValue2Hi_CUT.csv";
		int maxlength = 900;
		int minlength = 0;
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter(filename)));
			writer.print(trail);
			trail = "";
			writer.close();
		} catch (Exception e) {
			System.out.println("Didn't work");
		}
		int valuetested = 0;
		for (int i = 0; i < 100; i++) {
			Bayes_net test = new Bayes_net();
			double[] satisfaction = { 1 / 3.0, 1 / 3.0, 1 / 3.0 };
			double[][] satisfaction1 = { { .8, .15, .05 }, { .1, .8, .1 },
					{ .05, .15, .8 } };			
			double[][] receptiveness = { { .8, .15, .05 }, { .1, .8, .1 },
					{ .05, .15, .8 } };
			double[][] use_of_hint = { { .8, .2 }, { .5, .5 }, { .2, .8 } };
			double[][] media = { { .8, .2 }, { .5, .5 }, { .2, .8 } };
			double[][] blank = use_of_hint;			
			test.add_vertex("Satisfaction", 3, satisfaction);
			test.add_vertex("Blank", 2);
			test.add_vertex("Use_of_hint", 2);
			test.add_vertex("Use_Social_Media", 2);
			test.add_vertex("Recpetivesness_to_Help", 3);
			test.add_vertex("Satisfaction1", 3);
			test.add_vertex("Blank1", 2);
			test.add_vertex("Use_of_hint1", 2);
			test.add_vertex("Use_Social_Media1", 2);
			test.add_vertex("Recpetivesness_to_Help1", 3);
			test.add_edge("Satisfaction", 3, "Satisfaction1", 3,
					satisfaction1);
			test.add_edge("Satisfaction", 3, "Recpetivesness_to_Help", 3, receptiveness);
			test.add_edge("Recpetivesness_to_Help", 3, "Use_of_hint", 2, use_of_hint);
			test.add_edge("Satisfaction", 3, "Use_Social_Media", 2, media);
			test.add_edge("Satisfaction", 3, "Blank", 2, blank);
			test.add_edge("Satisfaction1", 3, "Recpetivesness_to_Help1", 3, receptiveness);
			test.add_edge("Recpetivesness_to_Help1", 3, "Use_of_hint1", 2, use_of_hint);
			test.add_edge("Satisfaction1", 3, "Use_Social_Media1", 2, media);
			test.add_edge("Satisfaction1", 3, "Blank1", 2, blank);
			JoinTree sample = test.convertToJoinTree();
			sample.makeConsistent();
			// double[] result = sample.find_all_probabilities();
			double[] result = sample.find_probability(new Vertex<String>(
					"Satisfaction1", 3));
			Vertex<String> Blank = new Vertex<String>("Blank1",
					2);			
			Vertex<String> Social = new Vertex<String>(
					"Use_Social_Media1", 2);
			Vertex<String> Hint = new Vertex<String>(
					"Use_of_hint1", 2);
			int[] temp = new int[3];
			trail += result[valuetested] + ",";
			boolean hi = false, med = false, lo = false;
			Random rand = new Random();

			while ((hi || med || lo) == false) {
				temp = Satisfaction_Action_Maker.getActionsHi(sample);
				sample.Roll_over(new Vertex<String>("Satisfaction", 3),
						new Vertex<String>("Satisfaction1", 3));
				switch (rand.nextInt(3)) {
				case (0):
					sample.enter_evidence(Blank, temp[0]);
					break;
				case (1):
					sample.enter_evidence(Social, temp[1]);
					break;
				case (2):
					sample.enter_evidence(Hint, temp[2]);
					break;				
				}
				result = sample.find_probability(new Vertex<String>(
						"Satisfaction1", 3));

				if (1 - result[0] < 0.25) {
					hi = true;
				} else if (1 - result[1] < 0.25) {
					med = true;
				} else if (1 - result[2] < 0.25) {
					lo = true;
				}
				trail += result[valuetested] + ",";

			}
			try {
				PrintWriter writer = new PrintWriter(new BufferedWriter(
						new FileWriter(filename, true)));
				if (trail.length() < maxlength && trail.length() > minlength){
					writer.println(trail);
					System.out.println("Works");
				}					
				else
					writer.println();
				trail = "";
				writer.close();
			} catch (Exception e) {
				System.out.println("Didn't work");
			}
		}

	}

}
