package it.polito.tdp.alien.model;


import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {

	private List<Parole> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<Parole>();
	}
	
	public void resetDictionary(){
		dictionary.clear();
	}
	
	public void addWord(String alien, String trans) {
		Parole w = new Parole(alien, trans);
		if (dictionary.contains(w)) {
			dictionary.get(dictionary.indexOf(w)).setTranslation(trans);
			return;
		}
		dictionary.add(w);
	}
	
	public String translateWord(String alien) {
		Parole w = new Parole(alien);
		if (dictionary.contains(w)) {
			return dictionary.get(dictionary.indexOf(w)).getTranslation();
		}
		return null;
	}
	
	
	
	
}
