package it.unical.hangman.businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsFactory {
	private File file;
	private List<String> words = new ArrayList<>();
	
	public WordsFactory() {
		super();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public void init() {
		System.out.println("INIT");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       words.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getRandomWord() {
		return words.get(new Random().nextInt(words.size()));
	}
	
	
}
