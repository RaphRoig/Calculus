package application;
import java.util.*;

public class Game {
	private int difficulty;
	private int numberOfCalc;
	private Player player;
	private List<Calculation> calculations;
	private int nbCalcsSolved;
	
	public Game(int difficulty_, int numberOfCalc_, Player player_) {
		difficulty = difficulty_;
		player = player_;
		numberOfCalc=numberOfCalc_;
		calculations = new ArrayList<Calculation>();
		for (int i = 0; i<numberOfCalc; i++) {
			Calculation calc = new Calculation(difficulty);
			calculations.add(calc);
		}
		nbCalcsSolved = 0;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getNumberOfCalc() {
		return numberOfCalc;
	}

	public void setNumberOfCalc(int numberOfCalc) {
		this.numberOfCalc = numberOfCalc;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Calculation> getCalculations() {
		return calculations;
	}

	public void setCalculations(List<Calculation> calculations) {
		this.calculations = calculations;
	}

	public int getNbOfSolved() {
		return nbCalcsSolved;
	}

	public void setNbOfSolved(int nbCalcsSolved) {
		this.nbCalcsSolved = nbCalcsSolved;
	}
	
	public String markString() {
		String mark = getPlayer().getScore() + " / " + getNumberOfCalc();
		return mark;
	}
	public String difficultyString() {
		switch(getDifficulty()) {
			case 1:
				return "facile";				
			case 2:
				return "moyen";
			case 3:
				return "difficile";
			default:
				return "";
		}
	}
}
