package it.unical.hangman.businessLogic;

import org.springframework.beans.factory.annotation.Autowired;

public class HangmanGame {
	
	@Autowired
	private WordsFactory wordsFactory;
	private String playWord;
	private int leftTrials;
	private String currentWord;
	
	public HangmanGame() {
		super();
		/*if(appContext!=null) {
			System.out.println("ciao!");
		} else {
			System.out.println("ciao2!");
		}
		playWord = appContext.getBean("wordsFactory", WordsFactory.class).getRandomWord();
		*/
	}
	public void init() {
		playWord = wordsFactory.getRandomWord().toUpperCase();
		currentWord = initCurrentWord();
		leftTrials = 5;
	}
	
	public String initCurrentWord() {
		String offuscated = "";
		for(int i = 0; i<playWord.length();i++) {
			offuscated+="_";
		}
		return offuscated;
	}

	public String getPlayWord() {
		return playWord;
	}

	public void setPlayWord(String playWord) {
		this.playWord = playWord;
	}

	public int getLeftTrials() {
		return leftTrials;
	}

	public void setLeftTrials(int leftTrials) {
		this.leftTrials = leftTrials;
	}

	public String getCurrentWord() {
		return currentWord;
	}

	public void setCurrentWord(String currentWord) {
		this.currentWord = currentWord;
	}
	
	public void buyLetter(String letter) {
		char letterChar = letter.charAt(0);
		boolean goodGuess = false;
		for(int i=0;i<playWord.length();i++) {
			if(letterChar == playWord.charAt(i)) {
				StringBuilder sb = new StringBuilder(currentWord);
				sb.setCharAt(i, letterChar);
				currentWord = sb.toString();
				goodGuess = true;
			}			
		}
		if(!goodGuess) {
			leftTrials--;
		}
	}
	
	public boolean isWon() {
		for(int i=0;i<currentWord.length();i++) {
			if(currentWord.charAt(i)=='_') {
				return false;
			}
		}
		return true;
	}
	
	
}


