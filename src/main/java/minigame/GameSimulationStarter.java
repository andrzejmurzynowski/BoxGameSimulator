package minigame;

import java.util.ArrayList;

public class GameSimulationStarter {

	public static void main(String[] args) {

		ArrayList<Integer> rewards = new ArrayList<>();

		int numberOfRuns = 10000;

		// Main Loop in simulation

		for (int i = 0; i < numberOfRuns; i++) {

			Game game = new Game(1); // Game starts with one life
			// Box printing (just checking if everything is OK)
			ArrayList<String> list = game.getBoxesList();
			for (String name : list) {
				System.out.print(name + " ");

			}
			System.out.println();

			// Main game loop

			while (game.getLife() != 0) {

				// #1 Choosing of box number based on the box list
				int choice = game.randomBoxNumberGenerator(game.getBoxesList().size());

				// First Stage

				if (game.getBoxesList().get(choice).equals("Game over")) {
					game.setLife(game.getLife() - 1);
				}

				else if (game.getBoxesList().get(choice).equals("Extra life")) {
					game.setLife(game.getLife() + 1);
				}

				else {
					game.setSum(game.getSum() + Integer.parseInt(game.getBoxesList().get(choice)));
				}
				// Deletion of Box which was chosen
				game.getBoxesList().remove(choice);

				// Second Stage
				if (game.getLife() == 0) {
					// Element with index of 0 is taken because list is already
					// in random order which is pseudo random approach however
					// it is still valid based on the investigation in the main
					// game loop #1.

					if (game.getSecondChance().get(0).equals("Second chance")) {
						game.setLife(1);
						game.getSecondChance().remove(0); // Deletion of second
															// chance according
															// to the
															// specification it
															// should be just
															// once

					} else {
						game.setSum(game.getSum() + Integer.parseInt(game.getSecondChance().get(0)));

					}
				}

			}
			// Saving of record to the simulation array table
			rewards.add(game.getSum());

			System.out.println("Twoja wygrana to: " + game.getSum());
			// System.out.println("Gra zakoñczona");

		}
		// Calculation of the sum based on the stream which was introduced in Javy 8
		int sumReward = rewards.stream().mapToInt(Integer::intValue).sum();

		// Calculation of the sum based on the FOREACH Loop
		int sumReward2 = 0;
		for (int reward : rewards) {
			sumReward2 = sumReward2 + reward;
		}

		int averageReward = sumReward / numberOfRuns;
		System.out.println("Symulation was run on the " + numberOfRuns + " games.");
		System.out.println("Sum calculated using STREAM: " + sumReward);
		System.out.println("Sum calculated using FOREACH LOOP: " + sumReward2);
		System.out.println("Average reward in game is: " + averageReward + " Euro");

	}

}
