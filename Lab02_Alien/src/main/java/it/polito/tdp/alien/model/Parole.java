package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parole{
	
	private String alienWord;
	private List<String> translations;
	
	
	public Parole(String alienWord) {
		this.alienWord = alienWord;
		translations=new ArrayList<String>();
	}


	public String getTranslations() {
		return translations.toString();
	}


	public void AddTranslations(String translation) {
		this.translations.add(translation);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parole other = (Parole) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
}
	
	
