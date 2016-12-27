package minigame;

import java.util.ArrayList;
import java.util.Scanner;

public class GameStarter {

	public static void main(String[] args) {
		Game game = new Game(1);
		ArrayList<String> list = game.getBoxesList();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		for (String name : list) {
			System.out.println(name + " ");
		}

		System.out.println();
		System.out.println();
		System.out.println();

		// G³ówna petla gry

		while (game.getLife() != 0) {
			System.out.println("Wybierz BOX od 0-" + (game.getBoxesList().size() - 1));
			choice = input.nextInt();
			input.nextLine();
			System.out.println("Wybrano BOX: " + choice);
			System.out.println("Wewn¹trz niego jest: " + game.getBoxesList().get(choice));

			// First Stage

			if (game.getBoxesList().get(choice).equals("Game over")) {
				game.setLife(game.getLife() - 1);
				System.out.println("Iloœæ ¿yæ obecnie to: " + game.getLife());
			}

			else if (game.getBoxesList().get(choice).equals("Extra life")) {
				game.setLife(game.getLife() + 1);
				System.out.println("Dosta³eœ dodatkowe ¿ycie, iloœæ ¿yæ obecnie to: " + game.getLife());
			}

			else {
				System.out.println("Wygra³es: " + game.getBoxesList().get(choice));
				game.setSum(game.getSum() + Integer.parseInt(game.getBoxesList().get(choice)));
				System.out.println("Twoja obecna wygrana to: " + game.getSum());

			}
			// Usuniêcie Boxa
			game.getBoxesList().remove(choice);

			// Second Stage
			if (game.getLife() == 0) {
				// Pobierany jest element 0 poniewa¿ lista jest mieszana co daje
				// efekt randomu
				if (game.getSecondChance().get(0).equals("Second chance")) {
					game.setLife(1);
					System.out.println("Dosta³eœ Drugie ¿ycie nie zmarnuj go ;-)");
					game.getSecondChance().remove(0); // Usuwanie Second Chance
														// zeby bylo tylko raz
				} else {
					game.setSum(game.getSum() + Integer.parseInt(game.getSecondChance().get(0)));
					System.out.println("Dodatkowa wygrana z drugiej szansy to: " + game.getSecondChance().get(0));

				}
			}

		}
		// Zamykanie strumienia
		input.close();
		System.out.println("Twoja wygrana to: " + game.getSum());
		System.out.println("Gra zakoñczona");

	}

}
