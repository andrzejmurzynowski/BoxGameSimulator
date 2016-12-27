package minigame;

import java.util.ArrayList;

public class SecondChanceTest {

	public static void main(String[] args) {
		Game game = new Game(1);
		ArrayList<String> list = game.getSecondChance();
		//Second stage boxes should be displayed in random order
		for (String name : list) {
			System.out.println(name + " ");
		}
	}
}
