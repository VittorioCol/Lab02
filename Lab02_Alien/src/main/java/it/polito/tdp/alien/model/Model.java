package it.polito.tdp.alien.model;

public class Model {
	AlienDictionary aD;
	public Model(){
		aD=new AlienDictionary();
	}
	public void addWord(String word,String translation) {
		aD.addWord(word, translation);
	}
	public String translateWord(String alien) {
		return aD.translateWord(alien);
	}
	public void resetDictionary() {
		aD.resetDictionary();
	}
}
