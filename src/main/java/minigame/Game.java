package minigame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

	private int sum;
	private int life;
	private ArrayList<String> boxesList;
	private ArrayList<String> secondChance;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public ArrayList<String> getBoxesList() {
		return boxesList;
	}

	public void setBoxesList(ArrayList<String> boxesList) {
		this.boxesList = boxesList;
	}

	public ArrayList<String> getSecondChance() {
		return secondChance;
	}

	public void setSecondChance(ArrayList<String> secondChance) {
		this.secondChance = secondChance;
	}

	private ArrayList<String> generateBoxes() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("100");
		list.add("40");
		list.add("30");
		list.add("20");
		list.add("20");
		list.add("5");
		list.add("5");
		list.add("5");
		list.add("5");
		list.add("5");
		list.add("Extra life");
		list.add("Game over");
		list.add("Game over");
		list.add("Game over");
		Collections.shuffle(list);

		return list;
	}

	private ArrayList<String> generateSecondChance() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("5");
		list.add("10");
		list.add("20");
		list.add("Second chance");
		Collections.shuffle(list);

		return list;
	}

	public int randomBoxNumberGenerator(int numberOfBoxes) {
		Random rand = new Random();
		int minimum = 0;

		int maximum = numberOfBoxes;
		int randomNum = minimum + rand.nextInt((maximum - minimum));

		return randomNum;
	}

	public Game(int life) {

		this.sum = 0;
		this.life = life;
		this.boxesList = generateBoxes();
		this.secondChance = generateSecondChance();
	}

	

}
