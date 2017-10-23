package io.github.robertovillarejo.sexualslang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.upc.freeling.HmmTagger;
import edu.upc.freeling.ListSentence;
import edu.upc.freeling.Maco;
import io.github.robertovillarejo.sexualslang.Analyzer;

@Component("analyzer")
public class SpanishAnalyzer implements Analyzer{
	
	@Autowired
	private Maco maco;
	
	@Autowired
	private HmmTagger tg;

	@Override
	public void analyze(ListSentence ls) {
		maco.analyze(ls);
		tg.analyze(ls);
	}

}
