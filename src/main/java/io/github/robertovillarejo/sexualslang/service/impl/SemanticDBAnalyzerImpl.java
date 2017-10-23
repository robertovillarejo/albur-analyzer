package io.github.robertovillarejo.sexualslang.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.freeling.ListString;
import edu.upc.freeling.SemanticDB;
import io.github.robertovillarejo.sexualslang.SenseDTO;
import io.github.robertovillarejo.sexualslang.dto.WordDTO;
import io.github.robertovillarejo.sexualslang.service.SemanticDBAnalyzer;

@Service
public class SemanticDBAnalyzerImpl implements SemanticDBAnalyzer {
	
	@Autowired
	private SemanticDB semDB;
	
	@Override
	public void analyze(List<List<WordDTO>> listSentence) {
		Iterator<List<WordDTO>> it = listSentence.iterator();
		while(it.hasNext()) {
			List<WordDTO> sentence = it.next();
			Iterator<WordDTO> itW = sentence.iterator();
			while(itW.hasNext()) {
				WordDTO w = itW.next();
				annotateSenses(w.getSenses());
			}
		}
	}
	
	public void annotateSenses(List<SenseDTO> senses) {
		Iterator<SenseDTO> it = senses.iterator();
		while(it.hasNext()) {
			SenseDTO sense = it.next();
			sense.setLemmas(getLemmas(sense.getSense()));
		}
	}
	
	public List<String> getLemmas(String sense) {
		List<String> words = new ArrayList<>();
		ListString results = semDB.getSenseWords(sense);
		while(!results.empty()) {
			words.add(results.front());
			results.popFront();
		}
		return words;
	}

}
