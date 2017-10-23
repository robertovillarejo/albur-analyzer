package io.github.robertovillarejo.sexualslang;

import java.io.Serializable;
import java.util.List;

public class SenseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2530042582862320038L;

	private String sense;
	
	private Double probability;
	
	private List<String> lemmas;

	public String getSense() {
		return sense;
	}

	public void setSense(String sense) {
		this.sense = sense;
	}

	public Double getProbability() {
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public List<String> getLemmas() {
		return lemmas;
	}

	public void setLemmas(List<String> lemmas) {
		this.lemmas = lemmas;
	}
	

}
