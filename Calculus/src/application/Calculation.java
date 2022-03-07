package application;

import java.util.*;


public class Calculation {
	private int difficulty;
	private String equation;
	private int result;
	private int[] choices;
	private boolean solved;
	private int playerChoice;

	public Calculation(int difficulty_) {
		
		setDifficulty(difficulty_);
		setSolved(false);
		switch(difficulty) {
			case 1:
				List<String> easy = createEasy();
				setResult(Integer.parseInt(easy.get(0)));
				setEquation(easy.get(1));
				choices = easyChoice(getResult());
				break;
			case 2:
				List<String> medium = createMedium();
				setResult(Integer.parseInt(medium.get(0)));
				setEquation(medium.get(1));
				choices = mediumChoice(getResult());
				break;
			case 3:
				List<String> hard = createHard();
				setResult(Integer.parseInt(hard.get(0)));
				setEquation(hard.get(1));
				choices = hardChoice(getResult());
				break;
		}
		
	}
	
	public int[] easyChoice(int result) {
		int[] choices = {-99,-99,-99,-99};
		Random random = new Random();
		choices[random.nextInt(4)] = result;
		for (int i = 0; i < 4; i++) {
			if (choices[i] == -99) {
				int[] tempTab = Arrays.copyOf(choices, choices.length);
				do {
					int plusOrMinus = random.nextInt(2);
					choices[i] = (plusOrMinus == 0) ? result + random.nextInt(4,10) : result - random.nextInt(4,10) ;
				} while (choices[i] < 0 || choices[i] == tempTab[0] || choices[i] == tempTab[1] || choices[i] == tempTab[2] || choices[i] == tempTab[3] );
			}
		}
		return choices;
	}
	
	public int[] mediumChoice(int result) {
		int[] choices = {-99,-99,-99,-99};
		Random random = new Random();
		choices[random.nextInt(4)] = result;
		for (int i = 0; i < 4; i++) {
			if (choices[i] == -99) {
				int[] tempTab = Arrays.copyOf(choices, choices.length);
				do {
					int plusOrMinus = random.nextInt(2);
					choices[i] = (plusOrMinus == 0) ? result + random.nextInt(2,8) : result - random.nextInt(2,8) ;
				} while(choices[i] == tempTab[0] || choices[i] == tempTab[1] || choices[i] == tempTab[2] || choices[i] == tempTab[3]);
			}
		}
		return choices;
	}
	
	public int[] hardChoice(int result) {
		int[] choices = {-99,-99,-99,-99};
		Random random = new Random();
		choices[random.nextInt(4)] = result;
		for (int i = 0; i < 4; i++) {
			if (choices[i] == -99) {
				int[] tempTab = Arrays.copyOf(choices, choices.length);
				do {
					int plusOrMinus = random.nextInt(2);
					choices[i] = (plusOrMinus == 0) ? result + random.nextInt(5) : result - random.nextInt(5) ;
				}  while(choices[i] == tempTab[0] || choices[i] == tempTab[1] || choices[i] == tempTab[2] || choices[i] == tempTab[3]);
			}
		}
		return choices;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int[] getChoices() {
		return choices;
	}

	public void setChoices(int[] choices) {
		this.choices = choices;
	}
	
	public boolean getSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	public int getPlayerChoice() {
		return playerChoice;
	}

	public void setPlayerChoice(int playerChoice) {
		this.playerChoice = playerChoice;
	}

	public void createAddition(int nb1, int nb2, int result, String equation, List<String> addCalc) {

		result = nb1 + nb2;
		equation = nb1 + " + " + nb2 + " = ?";
		addCalc.add(String.valueOf(result));
		addCalc.add(equation);
	}
	
	public void createSubtraction(int nb1, int nb2, int result, String equation, List<String> subCalc) {
		result = nb1 - nb2;
		equation = nb1 + " - " + nb2 + " = ?";
		subCalc.add(String.valueOf(result));
		subCalc.add(equation);
	}
	
	public void createMultiplication(int nb1, int nb2, int result, String equation, List<String> multCalc) {

		result = nb1 * nb2;
		equation = nb1 + " x " + nb2 + " = ?";
		multCalc.add(String.valueOf(result));
		multCalc.add(equation);
	}
	
	public void createDivision(int nb1, int nb2, int result, String equation, List<String> divCalc) {

		result = nb1 / nb2;
		equation = nb1 + " / " + nb2 + " = ?";
		divCalc.add(String.valueOf(result));
		divCalc.add(equation);
	}
	
	public List<String> createEasy() {
		List<String> easyCalc = new ArrayList<String>();
		Random random = new Random();
		int result = 0;
		String equation = "";
		int nb1;
		int nb2;
		int operator = random.nextInt(2);;
		nb1 = random.nextInt(1,21);
		nb2 = random.nextInt(1,21);
		if (operator==0) {
			createAddition(nb1, nb2, result, equation, easyCalc);
		}
		else if (operator==1) {
			while ((nb1 - nb2) < 0) {
				nb1 = random.nextInt(1,21);
				nb2 = random.nextInt(1,21);
			}
			createSubtraction(nb1, nb2, result, equation, easyCalc);
		}
		return easyCalc;
	}
	
	public List<String> createMedium() {
		List<String> mediumCalc = new ArrayList<String>();
		Random random = new Random();
		int result = 0;
		String equation = "";
		int nb1;
		int nb2;
		int operator;
		nb1 = random.nextInt(1,36);
		nb2 = random.nextInt(1,36);
		operator = random.nextInt(3);
		if (operator==0) {
			createAddition(nb1, nb2, result, equation, mediumCalc);
		}
		else if (operator==1) {
			createSubtraction(nb1, nb2, result, equation,mediumCalc);
		}
		else if (operator==2) {
			nb1 = random.nextInt(2,13);
			nb2 = random.nextInt(2,13);
			createMultiplication(nb1, nb2, result, equation,mediumCalc);
		}
		return mediumCalc;
	}
	
	public List<String> createHard() {
		List<String> hardCalc = new ArrayList<String>();
		Random random = new Random();
		int result = 0;
		String equation = "";
		int nb1;
		int nb2;
		int operator;
		nb1 = random.nextInt(1,50);
		nb2 = random.nextInt(1,50);
		operator = random.nextInt(4);
		if (operator==0) {
			createAddition(nb1, nb2, result, equation, hardCalc);
		}
		else if (operator==1) {
			createSubtraction(nb1, nb2, result, equation,hardCalc);
		}
		else if (operator==2) {
			nb1 = random.nextInt(3,15);
			nb2 = random.nextInt(3,15);
			createMultiplication(nb1, nb2, result, equation, hardCalc);
		}
		else if (operator==3) {
			while (nb1 % nb2 != 0) {
				nb1 = random.nextInt(1,50);
				nb2 = random.nextInt(1,50);
			}
			createDivision(nb1, nb2, result, equation, hardCalc);
		}
		return hardCalc;
	}
	
	
	
	
}
